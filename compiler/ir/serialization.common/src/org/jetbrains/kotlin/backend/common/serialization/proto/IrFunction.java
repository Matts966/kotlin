// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: compiler/ir/serialization.common/src/KotlinIr.proto

package org.jetbrains.kotlin.backend.common.serialization.proto;

/**
 * Protobuf type {@code org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction}
 */
public final class IrFunction extends
    org.jetbrains.kotlin.protobuf.GeneratedMessageLite implements
    // @@protoc_insertion_point(message_implements:org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction)
    IrFunctionOrBuilder {
  // Use IrFunction.newBuilder() to construct.
  private IrFunction(org.jetbrains.kotlin.protobuf.GeneratedMessageLite.Builder builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private IrFunction(boolean noInit) { this.unknownFields = org.jetbrains.kotlin.protobuf.ByteString.EMPTY;}

  private static final IrFunction defaultInstance;
  public static IrFunction getDefaultInstance() {
    return defaultInstance;
  }

  public IrFunction getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final org.jetbrains.kotlin.protobuf.ByteString unknownFields;
  private IrFunction(
      org.jetbrains.kotlin.protobuf.CodedInputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    org.jetbrains.kotlin.protobuf.ByteString.Output unknownFieldsOutput =
        org.jetbrains.kotlin.protobuf.ByteString.newOutput();
    org.jetbrains.kotlin.protobuf.CodedOutputStream unknownFieldsCodedOutput =
        org.jetbrains.kotlin.protobuf.CodedOutputStream.newInstance(
            unknownFieldsOutput);
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFieldsCodedOutput,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = base_.toBuilder();
            }
            base_ = input.readMessage(org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(base_);
              base_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind value = org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind.valueOf(rawValue);
            if (value == null) {
              unknownFieldsCodedOutput.writeRawVarint32(tag);
              unknownFieldsCodedOutput.writeRawVarint32(rawValue);
            } else {
              bitField0_ |= 0x00000002;
              modality_ = value;
            }
            break;
          }
          case 24: {
            bitField0_ |= 0x00000004;
            isTailrec_ = input.readBool();
            break;
          }
          case 32: {
            bitField0_ |= 0x00000008;
            isSuspend_ = input.readBool();
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
              overridden_ = new java.util.ArrayList<org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex>();
              mutable_bitField0_ |= 0x00000010;
            }
            overridden_.add(input.readMessage(org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex.PARSER, extensionRegistry));
            break;
          }
        }
      }
    } catch (org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000010) == 0x00000010)) {
        overridden_ = java.util.Collections.unmodifiableList(overridden_);
      }
      try {
        unknownFieldsCodedOutput.flush();
      } catch (java.io.IOException e) {
      // Should not happen
      } finally {
        unknownFields = unknownFieldsOutput.toByteString();
      }
      makeExtensionsImmutable();
    }
  }
  public static org.jetbrains.kotlin.protobuf.Parser<IrFunction> PARSER =
      new org.jetbrains.kotlin.protobuf.AbstractParser<IrFunction>() {
    public IrFunction parsePartialFrom(
        org.jetbrains.kotlin.protobuf.CodedInputStream input,
        org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
        throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
      return new IrFunction(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public org.jetbrains.kotlin.protobuf.Parser<IrFunction> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  public static final int BASE_FIELD_NUMBER = 1;
  private org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base_;
  /**
   * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
   */
  public boolean hasBase() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
   */
  public org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase getBase() {
    return base_;
  }

  public static final int MODALITY_FIELD_NUMBER = 2;
  private org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality_;
  /**
   * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality = 2;</code>
   */
  public boolean hasModality() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality = 2;</code>
   */
  public org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind getModality() {
    return modality_;
  }

  public static final int IS_TAILREC_FIELD_NUMBER = 3;
  private boolean isTailrec_;
  /**
   * <code>required bool is_tailrec = 3;</code>
   */
  public boolean hasIsTailrec() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>required bool is_tailrec = 3;</code>
   */
  public boolean getIsTailrec() {
    return isTailrec_;
  }

  public static final int IS_SUSPEND_FIELD_NUMBER = 4;
  private boolean isSuspend_;
  /**
   * <code>required bool is_suspend = 4;</code>
   */
  public boolean hasIsSuspend() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>required bool is_suspend = 4;</code>
   */
  public boolean getIsSuspend() {
    return isSuspend_;
  }

  public static final int OVERRIDDEN_FIELD_NUMBER = 5;
  private java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex> overridden_;
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
   *
   * <pre>
   *optional UniqId corresponding_property = 7;
   * </pre>
   */
  public java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex> getOverriddenList() {
    return overridden_;
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
   *
   * <pre>
   *optional UniqId corresponding_property = 7;
   * </pre>
   */
  public java.util.List<? extends org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndexOrBuilder> 
      getOverriddenOrBuilderList() {
    return overridden_;
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
   *
   * <pre>
   *optional UniqId corresponding_property = 7;
   * </pre>
   */
  public int getOverriddenCount() {
    return overridden_.size();
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
   *
   * <pre>
   *optional UniqId corresponding_property = 7;
   * </pre>
   */
  public org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex getOverridden(int index) {
    return overridden_.get(index);
  }
  /**
   * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
   *
   * <pre>
   *optional UniqId corresponding_property = 7;
   * </pre>
   */
  public org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndexOrBuilder getOverriddenOrBuilder(
      int index) {
    return overridden_.get(index);
  }

  private void initFields() {
    base_ = org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.getDefaultInstance();
    modality_ = org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind.FINAL_MODALITY;
    isTailrec_ = false;
    isSuspend_ = false;
    overridden_ = java.util.Collections.emptyList();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasBase()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasModality()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasIsTailrec()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasIsSuspend()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!getBase().isInitialized()) {
      memoizedIsInitialized = 0;
      return false;
    }
    for (int i = 0; i < getOverriddenCount(); i++) {
      if (!getOverridden(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(org.jetbrains.kotlin.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeMessage(1, base_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeEnum(2, modality_.getNumber());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      output.writeBool(3, isTailrec_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      output.writeBool(4, isSuspend_);
    }
    for (int i = 0; i < overridden_.size(); i++) {
      output.writeMessage(5, overridden_.get(i));
    }
    output.writeRawBytes(unknownFields);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += org.jetbrains.kotlin.protobuf.CodedOutputStream
        .computeMessageSize(1, base_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += org.jetbrains.kotlin.protobuf.CodedOutputStream
        .computeEnumSize(2, modality_.getNumber());
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += org.jetbrains.kotlin.protobuf.CodedOutputStream
        .computeBoolSize(3, isTailrec_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += org.jetbrains.kotlin.protobuf.CodedOutputStream
        .computeBoolSize(4, isSuspend_);
    }
    for (int i = 0; i < overridden_.size(); i++) {
      size += org.jetbrains.kotlin.protobuf.CodedOutputStream
        .computeMessageSize(5, overridden_.get(i));
    }
    size += unknownFields.size();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(
      org.jetbrains.kotlin.protobuf.ByteString data)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(
      org.jetbrains.kotlin.protobuf.ByteString data,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(byte[] data)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(
      byte[] data,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(
      java.io.InputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseDelimitedFrom(
      java.io.InputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(
      org.jetbrains.kotlin.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parseFrom(
      org.jetbrains.kotlin.protobuf.CodedInputStream input,
      org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  /**
   * Protobuf type {@code org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction}
   */
  public static final class Builder extends
      org.jetbrains.kotlin.protobuf.GeneratedMessageLite.Builder<
        org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction, Builder>
      implements
      // @@protoc_insertion_point(builder_implements:org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction)
      org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionOrBuilder {
    // Construct using org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      base_ = org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.getDefaultInstance();
      bitField0_ = (bitField0_ & ~0x00000001);
      modality_ = org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind.FINAL_MODALITY;
      bitField0_ = (bitField0_ & ~0x00000002);
      isTailrec_ = false;
      bitField0_ = (bitField0_ & ~0x00000004);
      isSuspend_ = false;
      bitField0_ = (bitField0_ & ~0x00000008);
      overridden_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000010);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction getDefaultInstanceForType() {
      return org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction.getDefaultInstance();
    }

    public org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction build() {
      org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction buildPartial() {
      org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction result = new org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.base_ = base_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.modality_ = modality_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.isTailrec_ = isTailrec_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.isSuspend_ = isSuspend_;
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        overridden_ = java.util.Collections.unmodifiableList(overridden_);
        bitField0_ = (bitField0_ & ~0x00000010);
      }
      result.overridden_ = overridden_;
      result.bitField0_ = to_bitField0_;
      return result;
    }

    public Builder mergeFrom(org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction other) {
      if (other == org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction.getDefaultInstance()) return this;
      if (other.hasBase()) {
        mergeBase(other.getBase());
      }
      if (other.hasModality()) {
        setModality(other.getModality());
      }
      if (other.hasIsTailrec()) {
        setIsTailrec(other.getIsTailrec());
      }
      if (other.hasIsSuspend()) {
        setIsSuspend(other.getIsSuspend());
      }
      if (!other.overridden_.isEmpty()) {
        if (overridden_.isEmpty()) {
          overridden_ = other.overridden_;
          bitField0_ = (bitField0_ & ~0x00000010);
        } else {
          ensureOverriddenIsMutable();
          overridden_.addAll(other.overridden_);
        }
        
      }
      setUnknownFields(
          getUnknownFields().concat(other.unknownFields));
      return this;
    }

    public final boolean isInitialized() {
      if (!hasBase()) {
        
        return false;
      }
      if (!hasModality()) {
        
        return false;
      }
      if (!hasIsTailrec()) {
        
        return false;
      }
      if (!hasIsSuspend()) {
        
        return false;
      }
      if (!getBase().isInitialized()) {
        
        return false;
      }
      for (int i = 0; i < getOverriddenCount(); i++) {
        if (!getOverridden(i).isInitialized()) {
          
          return false;
        }
      }
      return true;
    }

    public Builder mergeFrom(
        org.jetbrains.kotlin.protobuf.CodedInputStream input,
        org.jetbrains.kotlin.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (org.jetbrains.kotlin.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base_ = org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.getDefaultInstance();
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
     */
    public boolean hasBase() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
     */
    public org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase getBase() {
      return base_;
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
     */
    public Builder setBase(org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase value) {
      if (value == null) {
        throw new NullPointerException();
      }
      base_ = value;

      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
     */
    public Builder setBase(
        org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.Builder builderForValue) {
      base_ = builderForValue.build();

      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
     */
    public Builder mergeBase(org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase value) {
      if (((bitField0_ & 0x00000001) == 0x00000001) &&
          base_ != org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.getDefaultInstance()) {
        base_ =
          org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.newBuilder(base_).mergeFrom(value).buildPartial();
      } else {
        base_ = value;
      }

      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase base = 1;</code>
     */
    public Builder clearBase() {
      base_ = org.jetbrains.kotlin.backend.common.serialization.proto.IrFunctionBase.getDefaultInstance();

      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    private org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality_ = org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind.FINAL_MODALITY;
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality = 2;</code>
     */
    public boolean hasModality() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality = 2;</code>
     */
    public org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind getModality() {
      return modality_;
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality = 2;</code>
     */
    public Builder setModality(org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      modality_ = value;
      
      return this;
    }
    /**
     * <code>required .org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind modality = 2;</code>
     */
    public Builder clearModality() {
      bitField0_ = (bitField0_ & ~0x00000002);
      modality_ = org.jetbrains.kotlin.backend.common.serialization.proto.ModalityKind.FINAL_MODALITY;
      
      return this;
    }

    private boolean isTailrec_ ;
    /**
     * <code>required bool is_tailrec = 3;</code>
     */
    public boolean hasIsTailrec() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required bool is_tailrec = 3;</code>
     */
    public boolean getIsTailrec() {
      return isTailrec_;
    }
    /**
     * <code>required bool is_tailrec = 3;</code>
     */
    public Builder setIsTailrec(boolean value) {
      bitField0_ |= 0x00000004;
      isTailrec_ = value;
      
      return this;
    }
    /**
     * <code>required bool is_tailrec = 3;</code>
     */
    public Builder clearIsTailrec() {
      bitField0_ = (bitField0_ & ~0x00000004);
      isTailrec_ = false;
      
      return this;
    }

    private boolean isSuspend_ ;
    /**
     * <code>required bool is_suspend = 4;</code>
     */
    public boolean hasIsSuspend() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required bool is_suspend = 4;</code>
     */
    public boolean getIsSuspend() {
      return isSuspend_;
    }
    /**
     * <code>required bool is_suspend = 4;</code>
     */
    public Builder setIsSuspend(boolean value) {
      bitField0_ |= 0x00000008;
      isSuspend_ = value;
      
      return this;
    }
    /**
     * <code>required bool is_suspend = 4;</code>
     */
    public Builder clearIsSuspend() {
      bitField0_ = (bitField0_ & ~0x00000008);
      isSuspend_ = false;
      
      return this;
    }

    private java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex> overridden_ =
      java.util.Collections.emptyList();
    private void ensureOverriddenIsMutable() {
      if (!((bitField0_ & 0x00000010) == 0x00000010)) {
        overridden_ = new java.util.ArrayList<org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex>(overridden_);
        bitField0_ |= 0x00000010;
       }
    }

    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public java.util.List<org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex> getOverriddenList() {
      return java.util.Collections.unmodifiableList(overridden_);
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public int getOverriddenCount() {
      return overridden_.size();
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex getOverridden(int index) {
      return overridden_.get(index);
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder setOverridden(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureOverriddenIsMutable();
      overridden_.set(index, value);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder setOverridden(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex.Builder builderForValue) {
      ensureOverriddenIsMutable();
      overridden_.set(index, builderForValue.build());

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder addOverridden(org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureOverriddenIsMutable();
      overridden_.add(value);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder addOverridden(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureOverriddenIsMutable();
      overridden_.add(index, value);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder addOverridden(
        org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex.Builder builderForValue) {
      ensureOverriddenIsMutable();
      overridden_.add(builderForValue.build());

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder addOverridden(
        int index, org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex.Builder builderForValue) {
      ensureOverriddenIsMutable();
      overridden_.add(index, builderForValue.build());

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder addAllOverridden(
        java.lang.Iterable<? extends org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex> values) {
      ensureOverriddenIsMutable();
      org.jetbrains.kotlin.protobuf.AbstractMessageLite.Builder.addAll(
          values, overridden_);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder clearOverridden() {
      overridden_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000010);

      return this;
    }
    /**
     * <code>repeated .org.jetbrains.kotlin.backend.common.serialization.proto.IrDataIndex overridden = 5;</code>
     *
     * <pre>
     *optional UniqId corresponding_property = 7;
     * </pre>
     */
    public Builder removeOverridden(int index) {
      ensureOverriddenIsMutable();
      overridden_.remove(index);

      return this;
    }

    // @@protoc_insertion_point(builder_scope:org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction)
  }

  static {
    defaultInstance = new IrFunction(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:org.jetbrains.kotlin.backend.common.serialization.proto.IrFunction)
}
