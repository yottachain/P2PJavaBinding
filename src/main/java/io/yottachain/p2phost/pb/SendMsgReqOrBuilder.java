// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: types.proto

package io.yottachain.p2phost.pb;

public interface SendMsgReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:pb.SendMsgReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   */
  java.lang.String getId();
  /**
   * <code>string id = 1;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>int32 msgType = 2;</code>
   */
  int getMsgType();

  /**
   * <code>bytes msg = 3;</code>
   */
  com.google.protobuf.ByteString getMsg();
}
