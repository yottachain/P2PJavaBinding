// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package io.yottachain.p2phost.pb;

public final class P2PHostProto {
  private P2PHostProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_StringMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_StringMsg_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_StringListMsg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_StringListMsg_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_ConnectReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_ConnectReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_SendMsgReq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_SendMsgReq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_pb_SendMsgResp_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_pb_SendMsgResp_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\013types.proto\022\002pb\"\007\n\005Empty\"\032\n\tStringMsg\022" +
      "\r\n\005value\030\001 \001(\t\"\037\n\rStringListMsg\022\016\n\006value" +
      "s\030\001 \003(\t\"\'\n\nConnectReq\022\n\n\002id\030\001 \001(\t\022\r\n\005add" +
      "rs\030\002 \003(\t\"6\n\nSendMsgReq\022\n\n\002id\030\001 \001(\t\022\017\n\007ms" +
      "gType\030\002 \001(\014\022\013\n\003msg\030\003 \001(\014\"\034\n\013SendMsgResp\022" +
      "\r\n\005value\030\001 \001(\0142\325\002\n\007P2PHost\022 \n\002ID\022\t.pb.Em" +
      "pty\032\r.pb.StringMsg\"\000\022\'\n\005Addrs\022\t.pb.Empty" +
      "\032\021.pb.StringListMsg\"\000\022&\n\007Connect\022\016.pb.Co" +
      "nnectReq\032\t.pb.Empty\"\000\022(\n\nDisConnect\022\r.pb" +
      ".StringMsg\032\t.pb.Empty\"\000\022,\n\007SendMsg\022\016.pb." +
      "SendMsgReq\032\017.pb.SendMsgResp\"\000\022-\n\017Registe" +
      "rHandler\022\r.pb.StringMsg\032\t.pb.Empty\"\000\022/\n\021" +
      "UnregisterHandler\022\r.pb.StringMsg\032\t.pb.Em" +
      "pty\"\000\022\037\n\005Close\022\t.pb.Empty\032\t.pb.Empty\"\000B," +
      "\n\030io.yottachain.p2phost.pbB\014P2PHostProto" +
      "H\001P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_pb_Empty_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_pb_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_Empty_descriptor,
        new String[] { });
    internal_static_pb_StringMsg_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_pb_StringMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_StringMsg_descriptor,
        new String[] { "Value", });
    internal_static_pb_StringListMsg_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_pb_StringListMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_StringListMsg_descriptor,
        new String[] { "Values", });
    internal_static_pb_ConnectReq_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_pb_ConnectReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_ConnectReq_descriptor,
        new String[] { "Id", "Addrs", });
    internal_static_pb_SendMsgReq_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_pb_SendMsgReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_SendMsgReq_descriptor,
        new String[] { "Id", "MsgType", "Msg", });
    internal_static_pb_SendMsgResp_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_pb_SendMsgResp_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_pb_SendMsgResp_descriptor,
        new String[] { "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
