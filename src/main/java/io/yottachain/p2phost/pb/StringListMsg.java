// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package io.yottachain.p2phost.pb;

/**
 * <pre>
 * message that contains a list of string
 * </pre>
 *
 * Protobuf type {@code pb.StringListMsg}
 */
public  final class StringListMsg extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:pb.StringListMsg)
    StringListMsgOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StringListMsg.newBuilder() to construct.
  private StringListMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StringListMsg() {
    values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new StringListMsg();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StringListMsg(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              values_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            values_.add(s);
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        values_ = values_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return P2PHostProto.internal_static_pb_StringListMsg_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return P2PHostProto.internal_static_pb_StringListMsg_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            StringListMsg.class, Builder.class);
  }

  public static final int VALUES_FIELD_NUMBER = 1;
  private com.google.protobuf.LazyStringList values_;
  /**
   * <code>repeated string values = 1;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getValuesList() {
    return values_;
  }
  /**
   * <code>repeated string values = 1;</code>
   */
  public int getValuesCount() {
    return values_.size();
  }
  /**
   * <code>repeated string values = 1;</code>
   */
  public String getValues(int index) {
    return values_.get(index);
  }
  /**
   * <code>repeated string values = 1;</code>
   */
  public com.google.protobuf.ByteString
      getValuesBytes(int index) {
    return values_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < values_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, values_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < values_.size(); i++) {
        dataSize += computeStringSizeNoTag(values_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getValuesList().size();
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof StringListMsg)) {
      return super.equals(obj);
    }
    StringListMsg other = (StringListMsg) obj;

    if (!getValuesList()
        .equals(other.getValuesList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getValuesCount() > 0) {
      hash = (37 * hash) + VALUES_FIELD_NUMBER;
      hash = (53 * hash) + getValuesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static StringListMsg parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StringListMsg parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StringListMsg parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StringListMsg parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StringListMsg parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static StringListMsg parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static StringListMsg parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static StringListMsg parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static StringListMsg parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static StringListMsg parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static StringListMsg parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static StringListMsg parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(StringListMsg prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * message that contains a list of string
   * </pre>
   *
   * Protobuf type {@code pb.StringListMsg}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:pb.StringListMsg)
      StringListMsgOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return P2PHostProto.internal_static_pb_StringListMsg_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return P2PHostProto.internal_static_pb_StringListMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              StringListMsg.class, Builder.class);
    }

    // Construct using io.yottachain.p2phost.pb.StringListMsg.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return P2PHostProto.internal_static_pb_StringListMsg_descriptor;
    }

    @Override
    public StringListMsg getDefaultInstanceForType() {
      return StringListMsg.getDefaultInstance();
    }

    @Override
    public StringListMsg build() {
      StringListMsg result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public StringListMsg buildPartial() {
      StringListMsg result = new StringListMsg(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        values_ = values_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.values_ = values_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof StringListMsg) {
        return mergeFrom((StringListMsg)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(StringListMsg other) {
      if (other == StringListMsg.getDefaultInstance()) return this;
      if (!other.values_.isEmpty()) {
        if (values_.isEmpty()) {
          values_ = other.values_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureValuesIsMutable();
          values_.addAll(other.values_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      StringListMsg parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (StringListMsg) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.LazyStringList values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureValuesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        values_ = new com.google.protobuf.LazyStringArrayList(values_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getValuesList() {
      return values_.getUnmodifiableView();
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public int getValuesCount() {
      return values_.size();
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public String getValues(int index) {
      return values_.get(index);
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public com.google.protobuf.ByteString
        getValuesBytes(int index) {
      return values_.getByteString(index);
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public Builder setValues(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureValuesIsMutable();
      values_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public Builder addValues(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureValuesIsMutable();
      values_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public Builder addAllValues(
        Iterable<String> values) {
      ensureValuesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, values_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public Builder clearValues() {
      values_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string values = 1;</code>
     */
    public Builder addValuesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureValuesIsMutable();
      values_.add(value);
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:pb.StringListMsg)
  }

  // @@protoc_insertion_point(class_scope:pb.StringListMsg)
  private static final StringListMsg DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new StringListMsg();
  }

  public static StringListMsg getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StringListMsg>
      PARSER = new com.google.protobuf.AbstractParser<StringListMsg>() {
    @Override
    public StringListMsg parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StringListMsg(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StringListMsg> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<StringListMsg> getParserForType() {
    return PARSER;
  }

  @Override
  public StringListMsg getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

