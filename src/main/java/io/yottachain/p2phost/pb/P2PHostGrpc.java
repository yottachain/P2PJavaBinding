package io.yottachain.p2phost.pb;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * p2p micro-servicew
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.23.0)",
    comments = "Source: types.proto")
public final class P2PHostGrpc {

  private P2PHostGrpc() {}

  public static final String SERVICE_NAME = "pb.P2PHost";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Empty,
      StringMsg> getIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ID",
      requestType = Empty.class,
      responseType = StringMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Empty,
      StringMsg> getIDMethod() {
    io.grpc.MethodDescriptor<Empty, StringMsg> getIDMethod;
    if ((getIDMethod = P2PHostGrpc.getIDMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getIDMethod = P2PHostGrpc.getIDMethod) == null) {
          P2PHostGrpc.getIDMethod = getIDMethod =
              io.grpc.MethodDescriptor.<Empty, StringMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StringMsg.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("ID"))
              .build();
        }
      }
    }
    return getIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Empty,
      StringListMsg> getAddrsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Addrs",
      requestType = Empty.class,
      responseType = StringListMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Empty,
      StringListMsg> getAddrsMethod() {
    io.grpc.MethodDescriptor<Empty, StringListMsg> getAddrsMethod;
    if ((getAddrsMethod = P2PHostGrpc.getAddrsMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getAddrsMethod = P2PHostGrpc.getAddrsMethod) == null) {
          P2PHostGrpc.getAddrsMethod = getAddrsMethod =
              io.grpc.MethodDescriptor.<Empty, StringListMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Addrs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StringListMsg.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("Addrs"))
              .build();
        }
      }
    }
    return getAddrsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ConnectReq,
      Empty> getConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Connect",
      requestType = ConnectReq.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ConnectReq,
      Empty> getConnectMethod() {
    io.grpc.MethodDescriptor<ConnectReq, Empty> getConnectMethod;
    if ((getConnectMethod = P2PHostGrpc.getConnectMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getConnectMethod = P2PHostGrpc.getConnectMethod) == null) {
          P2PHostGrpc.getConnectMethod = getConnectMethod =
              io.grpc.MethodDescriptor.<ConnectReq, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Connect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ConnectReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("Connect"))
              .build();
        }
      }
    }
    return getConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StringMsg,
      Empty> getDisConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisConnect",
      requestType = StringMsg.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<StringMsg,
      Empty> getDisConnectMethod() {
    io.grpc.MethodDescriptor<StringMsg, Empty> getDisConnectMethod;
    if ((getDisConnectMethod = P2PHostGrpc.getDisConnectMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getDisConnectMethod = P2PHostGrpc.getDisConnectMethod) == null) {
          P2PHostGrpc.getDisConnectMethod = getDisConnectMethod =
              io.grpc.MethodDescriptor.<StringMsg, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisConnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StringMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("DisConnect"))
              .build();
        }
      }
    }
    return getDisConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<SendMsgReq,
      SendMsgResp> getSendMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMsg",
      requestType = SendMsgReq.class,
      responseType = SendMsgResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<SendMsgReq,
      SendMsgResp> getSendMsgMethod() {
    io.grpc.MethodDescriptor<SendMsgReq, SendMsgResp> getSendMsgMethod;
    if ((getSendMsgMethod = P2PHostGrpc.getSendMsgMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getSendMsgMethod = P2PHostGrpc.getSendMsgMethod) == null) {
          P2PHostGrpc.getSendMsgMethod = getSendMsgMethod =
              io.grpc.MethodDescriptor.<SendMsgReq, SendMsgResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SendMsgReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  SendMsgResp.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("SendMsg"))
              .build();
        }
      }
    }
    return getSendMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StringMsg,
      Empty> getRegisterHandlerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterHandler",
      requestType = StringMsg.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<StringMsg,
      Empty> getRegisterHandlerMethod() {
    io.grpc.MethodDescriptor<StringMsg, Empty> getRegisterHandlerMethod;
    if ((getRegisterHandlerMethod = P2PHostGrpc.getRegisterHandlerMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getRegisterHandlerMethod = P2PHostGrpc.getRegisterHandlerMethod) == null) {
          P2PHostGrpc.getRegisterHandlerMethod = getRegisterHandlerMethod =
              io.grpc.MethodDescriptor.<StringMsg, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterHandler"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StringMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("RegisterHandler"))
              .build();
        }
      }
    }
    return getRegisterHandlerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StringMsg,
      Empty> getUnregisterHandlerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnregisterHandler",
      requestType = StringMsg.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<StringMsg,
      Empty> getUnregisterHandlerMethod() {
    io.grpc.MethodDescriptor<StringMsg, Empty> getUnregisterHandlerMethod;
    if ((getUnregisterHandlerMethod = P2PHostGrpc.getUnregisterHandlerMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getUnregisterHandlerMethod = P2PHostGrpc.getUnregisterHandlerMethod) == null) {
          P2PHostGrpc.getUnregisterHandlerMethod = getUnregisterHandlerMethod =
              io.grpc.MethodDescriptor.<StringMsg, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnregisterHandler"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StringMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("UnregisterHandler"))
              .build();
        }
      }
    }
    return getUnregisterHandlerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Empty,
      Empty> getCloseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Close",
      requestType = Empty.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Empty,
      Empty> getCloseMethod() {
    io.grpc.MethodDescriptor<Empty, Empty> getCloseMethod;
    if ((getCloseMethod = P2PHostGrpc.getCloseMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getCloseMethod = P2PHostGrpc.getCloseMethod) == null) {
          P2PHostGrpc.getCloseMethod = getCloseMethod =
              io.grpc.MethodDescriptor.<Empty, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Close"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("Close"))
              .build();
        }
      }
    }
    return getCloseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static P2PHostStub newStub(io.grpc.Channel channel) {
    return new P2PHostStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static P2PHostBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new P2PHostBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static P2PHostFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new P2PHostFutureStub(channel);
  }

  /**
   * <pre>
   * p2p micro-servicew
   * </pre>
   */
  public static abstract class P2PHostImplBase implements io.grpc.BindableService {

    /**
     */
    public void iD(Empty request,
                   io.grpc.stub.StreamObserver<StringMsg> responseObserver) {
      asyncUnimplementedUnaryCall(getIDMethod(), responseObserver);
    }

    /**
     */
    public void addrs(Empty request,
                      io.grpc.stub.StreamObserver<StringListMsg> responseObserver) {
      asyncUnimplementedUnaryCall(getAddrsMethod(), responseObserver);
    }

    /**
     */
    public void connect(ConnectReq request,
                        io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getConnectMethod(), responseObserver);
    }

    /**
     */
    public void disConnect(StringMsg request,
                           io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDisConnectMethod(), responseObserver);
    }

    /**
     */
    public void sendMsg(SendMsgReq request,
                        io.grpc.stub.StreamObserver<SendMsgResp> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMsgMethod(), responseObserver);
    }

    /**
     */
    public void registerHandler(StringMsg request,
                                io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterHandlerMethod(), responseObserver);
    }

    /**
     */
    public void unregisterHandler(StringMsg request,
                                  io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUnregisterHandlerMethod(), responseObserver);
    }

    /**
     */
    public void close(Empty request,
                      io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getCloseMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Empty,
                StringMsg>(
                  this, METHODID_ID)))
          .addMethod(
            getAddrsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Empty,
                StringListMsg>(
                  this, METHODID_ADDRS)))
          .addMethod(
            getConnectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ConnectReq,
                Empty>(
                  this, METHODID_CONNECT)))
          .addMethod(
            getDisConnectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                StringMsg,
                Empty>(
                  this, METHODID_DIS_CONNECT)))
          .addMethod(
            getSendMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                SendMsgReq,
                SendMsgResp>(
                  this, METHODID_SEND_MSG)))
          .addMethod(
            getRegisterHandlerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                StringMsg,
                Empty>(
                  this, METHODID_REGISTER_HANDLER)))
          .addMethod(
            getUnregisterHandlerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                StringMsg,
                Empty>(
                  this, METHODID_UNREGISTER_HANDLER)))
          .addMethod(
            getCloseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Empty,
                Empty>(
                  this, METHODID_CLOSE)))
          .build();
    }
  }

  /**
   * <pre>
   * p2p micro-servicew
   * </pre>
   */
  public static final class P2PHostStub extends io.grpc.stub.AbstractStub<P2PHostStub> {
    private P2PHostStub(io.grpc.Channel channel) {
      super(channel);
    }

    private P2PHostStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected P2PHostStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PHostStub(channel, callOptions);
    }

    /**
     */
    public void iD(Empty request,
                   io.grpc.stub.StreamObserver<StringMsg> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addrs(Empty request,
                      io.grpc.stub.StreamObserver<StringListMsg> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddrsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void connect(ConnectReq request,
                        io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disConnect(StringMsg request,
                           io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDisConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMsg(SendMsgReq request,
                        io.grpc.stub.StreamObserver<SendMsgResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerHandler(StringMsg request,
                                io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterHandlerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unregisterHandler(StringMsg request,
                                  io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnregisterHandlerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void close(Empty request,
                      io.grpc.stub.StreamObserver<Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * p2p micro-servicew
   * </pre>
   */
  public static final class P2PHostBlockingStub extends io.grpc.stub.AbstractStub<P2PHostBlockingStub> {
    private P2PHostBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private P2PHostBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected P2PHostBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PHostBlockingStub(channel, callOptions);
    }

    /**
     */
    public StringMsg iD(Empty request) {
      return blockingUnaryCall(
          getChannel(), getIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public StringListMsg addrs(Empty request) {
      return blockingUnaryCall(
          getChannel(), getAddrsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Empty connect(ConnectReq request) {
      return blockingUnaryCall(
          getChannel(), getConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public Empty disConnect(StringMsg request) {
      return blockingUnaryCall(
          getChannel(), getDisConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public SendMsgResp sendMsg(SendMsgReq request) {
      return blockingUnaryCall(
          getChannel(), getSendMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public Empty registerHandler(StringMsg request) {
      return blockingUnaryCall(
          getChannel(), getRegisterHandlerMethod(), getCallOptions(), request);
    }

    /**
     */
    public Empty unregisterHandler(StringMsg request) {
      return blockingUnaryCall(
          getChannel(), getUnregisterHandlerMethod(), getCallOptions(), request);
    }

    /**
     */
    public Empty close(Empty request) {
      return blockingUnaryCall(
          getChannel(), getCloseMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * p2p micro-servicew
   * </pre>
   */
  public static final class P2PHostFutureStub extends io.grpc.stub.AbstractStub<P2PHostFutureStub> {
    private P2PHostFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private P2PHostFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected P2PHostFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PHostFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<StringMsg> iD(
        Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<StringListMsg> addrs(
        Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getAddrsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Empty> connect(
        ConnectReq request) {
      return futureUnaryCall(
          getChannel().newCall(getConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Empty> disConnect(
        StringMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getDisConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<SendMsgResp> sendMsg(
        SendMsgReq request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Empty> registerHandler(
        StringMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterHandlerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Empty> unregisterHandler(
        StringMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getUnregisterHandlerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Empty> close(
        Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCloseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ID = 0;
  private static final int METHODID_ADDRS = 1;
  private static final int METHODID_CONNECT = 2;
  private static final int METHODID_DIS_CONNECT = 3;
  private static final int METHODID_SEND_MSG = 4;
  private static final int METHODID_REGISTER_HANDLER = 5;
  private static final int METHODID_UNREGISTER_HANDLER = 6;
  private static final int METHODID_CLOSE = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final P2PHostImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(P2PHostImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ID:
          serviceImpl.iD((Empty) request,
              (io.grpc.stub.StreamObserver<StringMsg>) responseObserver);
          break;
        case METHODID_ADDRS:
          serviceImpl.addrs((Empty) request,
              (io.grpc.stub.StreamObserver<StringListMsg>) responseObserver);
          break;
        case METHODID_CONNECT:
          serviceImpl.connect((ConnectReq) request,
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
          break;
        case METHODID_DIS_CONNECT:
          serviceImpl.disConnect((StringMsg) request,
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
          break;
        case METHODID_SEND_MSG:
          serviceImpl.sendMsg((SendMsgReq) request,
              (io.grpc.stub.StreamObserver<SendMsgResp>) responseObserver);
          break;
        case METHODID_REGISTER_HANDLER:
          serviceImpl.registerHandler((StringMsg) request,
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
          break;
        case METHODID_UNREGISTER_HANDLER:
          serviceImpl.unregisterHandler((StringMsg) request,
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
          break;
        case METHODID_CLOSE:
          serviceImpl.close((Empty) request,
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class P2PHostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    P2PHostBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return P2PHostProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("P2PHost");
    }
  }

  private static final class P2PHostFileDescriptorSupplier
      extends P2PHostBaseDescriptorSupplier {
    P2PHostFileDescriptorSupplier() {}
  }

  private static final class P2PHostMethodDescriptorSupplier
      extends P2PHostBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    P2PHostMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (P2PHostGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new P2PHostFileDescriptorSupplier())
              .addMethod(getIDMethod())
              .addMethod(getAddrsMethod())
              .addMethod(getConnectMethod())
              .addMethod(getDisConnectMethod())
              .addMethod(getSendMsgMethod())
              .addMethod(getRegisterHandlerMethod())
              .addMethod(getUnregisterHandlerMethod())
              .addMethod(getCloseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
