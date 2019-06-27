/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.contracts

import com.intellij.util.containers.MultiMap
import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.config.LanguageFeature
import org.jetbrains.kotlin.config.LanguageVersionSettings
import org.jetbrains.kotlin.contracts.extensions.ExtensionBindingContextData
import org.jetbrains.kotlin.contracts.extensions.ExtensionContractComponents
import org.jetbrains.kotlin.contracts.model.Computation
import org.jetbrains.kotlin.contracts.model.ESEffect
import org.jetbrains.kotlin.contracts.model.ExtensionEffect
import org.jetbrains.kotlin.contracts.model.MutableContextInfo
import org.jetbrains.kotlin.contracts.model.functors.EqualsFunctor
import org.jetbrains.kotlin.contracts.model.structure.ESCalls
import org.jetbrains.kotlin.contracts.model.structure.ESConstants
import org.jetbrains.kotlin.contracts.model.structure.ESReturns
import org.jetbrains.kotlin.contracts.model.structure.UNKNOWN_COMPUTATION
import org.jetbrains.kotlin.contracts.model.visitors.InfoCollector
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.extensions.ContractsExtension
import org.jetbrains.kotlin.extensions.contractExtensions
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.psiUtil.parentsWithSelf
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.calls.smartcasts.ConditionalDataFlowInfo
import org.jetbrains.kotlin.resolve.calls.smartcasts.DataFlowInfo
import org.jetbrains.kotlin.resolve.calls.smartcasts.DataFlowValueFactory

class EffectSystem(
    val languageVersionSettings: LanguageVersionSettings,
    val dataFlowValueFactory: DataFlowValueFactory,
    val builtIns: KotlinBuiltIns,
    private val contractComponents: ExtensionContractComponents
) {
    fun getDataFlowInfoForFinishedCall(
        resolvedCall: ResolvedCall<*>,
        bindingTrace: BindingTrace,
        moduleDescriptor: ModuleDescriptor
    ): DataFlowInfo {
        if (!languageVersionSettings.supportsFeature(LanguageFeature.UseReturnsEffect)) return DataFlowInfo.EMPTY

        // Prevent launch of effect system machinery on pointless cases (constants/enums/constructors/etc.)
        val callExpression = resolvedCall.call.callElement as? KtCallExpression ?: return DataFlowInfo.EMPTY
        if (callExpression is KtDeclaration) return DataFlowInfo.EMPTY

        val resultContextInfo = getContextInfoWhen(ESReturns(ESConstants.wildcard), callExpression, bindingTrace, moduleDescriptor)

        return resultContextInfo.toDataFlowInfo(languageVersionSettings, builtIns)
    }

    fun getDataFlowInfoWhenEquals(
        leftExpression: KtExpression?,
        rightExpression: KtExpression?,
        bindingTrace: BindingTrace,
        moduleDescriptor: ModuleDescriptor
    ): ConditionalDataFlowInfo {
        if (!languageVersionSettings.supportsFeature(LanguageFeature.UseReturnsEffect)) return ConditionalDataFlowInfo.EMPTY
        if (leftExpression == null || rightExpression == null) return ConditionalDataFlowInfo.EMPTY

        val leftComputation =
            getNonTrivialComputation(leftExpression, bindingTrace, moduleDescriptor) ?: return ConditionalDataFlowInfo.EMPTY
        val rightComputation =
            getNonTrivialComputation(rightExpression, bindingTrace, moduleDescriptor) ?: return ConditionalDataFlowInfo.EMPTY

        val effects = EqualsFunctor(false).invokeWithArguments(leftComputation, rightComputation)

        val equalsContextInfo = InfoCollector(ESReturns(ESConstants.trueValue), builtIns).collectFromSchema(effects)
        val notEqualsContextInfo = InfoCollector(ESReturns(ESConstants.falseValue), builtIns).collectFromSchema(effects)

        return ConditionalDataFlowInfo(
            equalsContextInfo.toDataFlowInfo(languageVersionSettings, builtIns),
            notEqualsContextInfo.toDataFlowInfo(languageVersionSettings, builtIns)
        )
    }

    fun recordDefiniteInvocations(resolvedCall: ResolvedCall<*>, bindingTrace: BindingTrace, moduleDescriptor: ModuleDescriptor) {
        if (!languageVersionSettings.supportsFeature(LanguageFeature.UseCallsInPlaceEffect)) return

        // Prevent launch of effect system machinery on pointless cases (constants/enums/constructors/etc.)
        val callExpression = resolvedCall.call.callElement as? KtCallExpression ?: return
        if (callExpression is KtDeclaration) return

        val extensionInfos = MultiMap.create<KtExpression, Pair<ContractsExtension, ExtensionBindingContextData>>()

        val resultingContextInfo = getContextInfoWhen(ESReturns(ESConstants.wildcard), callExpression, bindingTrace, moduleDescriptor)
        loop@ for (effect in resultingContextInfo.firedEffects) {
            when (effect) {
                is ESCalls -> {
                    val callsEffect = effect as? ESCalls ?: continue@loop
                    val lambdaExpression = (callsEffect.callable as? ESLambda)?.lambda ?: continue@loop
                    bindingTrace.record(BindingContext.LAMBDA_INVOCATIONS, lambdaExpression, callsEffect.kind)
                }
                is ExtensionEffect -> {
                    for (contractsExtension in contractComponents.contractExtensions) {
                        val (expression, data) = contractsExtension.collectDefiniteInvocations(
                            effect,
                            resolvedCall,
                            bindingTrace.bindingContext
                        ) ?: continue@loop
                        extensionInfos.putValue(expression, contractsExtension to data)
                    }
                }
            }
        }

        // record info from extensions
        for (expression in extensionInfos.keySet()) {
            val newData = extensionInfos[expression]
                .groupBy { it.first }
                .mapValues { (_, value) -> value.map { it.second } }

            val dataMap = bindingTrace[BindingContext.EXTENSION_SLICE, expression]?.toMutableMap() ?: mutableMapOf()
            for ((extension, effects) in newData) {
                val oldValue = dataMap[extension.id] ?: extension.emptyBindingContextData()
                dataMap[extension.id] = effects.fold(oldValue, ExtensionBindingContextData::combine)
            }

            bindingTrace.record(BindingContext.EXTENSION_SLICE, expression, dataMap)
        }
    }

    fun extractDataFlowInfoFromCondition(
        condition: KtExpression?,
        value: Boolean,
        bindingTrace: BindingTrace,
        moduleDescriptor: ModuleDescriptor
    ): DataFlowInfo {
        if (!languageVersionSettings.supportsFeature(LanguageFeature.UseReturnsEffect)) return DataFlowInfo.EMPTY
        if (condition == null) return DataFlowInfo.EMPTY

        return getContextInfoWhen(ESReturns(ESConstants.booleanValue(value)), condition, bindingTrace, moduleDescriptor)
            .toDataFlowInfo(languageVersionSettings, moduleDescriptor.builtIns)
    }

    private fun getContextInfoWhen(
        observedEffect: ESEffect,
        expression: KtExpression,
        bindingTrace: BindingTrace,
        moduleDescriptor: ModuleDescriptor
    ): MutableContextInfo {
        val isInContractBlock = expression.parentsWithSelf.filterIsInstance<KtExpression>().any {
            bindingTrace.bindingContext[BindingContext.IS_CONTRACT_DECLARATION_BLOCK, it] == true
        }
        if (isInContractBlock) return MutableContextInfo.EMPTY
        val computation = getNonTrivialComputation(expression, bindingTrace, moduleDescriptor) ?: return MutableContextInfo.EMPTY
        return InfoCollector(observedEffect, builtIns).collectFromSchema(computation.effects)
    }

    private fun getNonTrivialComputation(expression: KtExpression, trace: BindingTrace, moduleDescriptor: ModuleDescriptor): Computation? {
        val visitor = EffectsExtractingVisitor(trace, moduleDescriptor, dataFlowValueFactory, languageVersionSettings, contractComponents)
        return visitor.extractOrGetCached(expression).takeUnless { it == UNKNOWN_COMPUTATION }
    }
}
