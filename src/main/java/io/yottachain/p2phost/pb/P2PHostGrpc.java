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
  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty,
      io.yottachain.p2phost.pb.StringMsg> getIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ID",
      requestType = io.yottachain.p2phost.pb.Empty.class,
      responseType = io.yottachain.p2phost.pb.StringMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty,
      io.yottachain.p2phost.pb.StringMsg> getIDMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty, io.yottachain.p2phost.pb.StringMsg> getIDMethod;
    if ((getIDMethod = P2PHostGrpc.getIDMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getIDMethod = P2PHostGrpc.getIDMethod) == null) {
          P2PHostGrpc.getIDMethod = getIDMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.Empty, io.yottachain.p2phost.pb.StringMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.StringMsg.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("ID"))
              .build();
        }
      }
    }
    return getIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty,
      io.yottachain.p2phost.pb.StringListMsg> getAddrsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Addrs",
      requestType = io.yottachain.p2phost.pb.Empty.class,
      responseType = io.yottachain.p2phost.pb.StringListMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty,
      io.yottachain.p2phost.pb.StringListMsg> getAddrsMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty, io.yottachain.p2phost.pb.StringListMsg> getAddrsMethod;
    if ((getAddrsMethod = P2PHostGrpc.getAddrsMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getAddrsMethod = P2PHostGrpc.getAddrsMethod) == null) {
          P2PHostGrpc.getAddrsMethod = getAddrsMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.Empty, io.yottachain.p2phost.pb.StringListMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Addrs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.StringListMsg.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("Addrs"))
              .build();
        }
      }
    }
    return getAddrsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.ConnectReq,
      io.yottachain.p2phost.pb.Empty> getConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Connect",
      requestType = io.yottachain.p2phost.pb.ConnectReq.class,
      responseType = io.yottachain.p2phost.pb.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.ConnectReq,
      io.yottachain.p2phost.pb.Empty> getConnectMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.ConnectReq, io.yottachain.p2phost.pb.Empty> getConnectMethod;
    if ((getConnectMethod = P2PHostGrpc.getConnectMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getConnectMethod = P2PHostGrpc.getConnectMethod) == null) {
          P2PHostGrpc.getConnectMethod = getConnectMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.ConnectReq, io.yottachain.p2phost.pb.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Connect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.ConnectReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("Connect"))
              .build();
        }
      }
    }
    return getConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg,
      io.yottachain.p2phost.pb.Empty> getDisConnectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisConnect",
      requestType = io.yottachain.p2phost.pb.StringMsg.class,
      responseType = io.yottachain.p2phost.pb.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg,
      io.yottachain.p2phost.pb.Empty> getDisConnectMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg, io.yottachain.p2phost.pb.Empty> getDisConnectMethod;
    if ((getDisConnectMethod = P2PHostGrpc.getDisConnectMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getDisConnectMethod = P2PHostGrpc.getDisConnectMethod) == null) {
          P2PHostGrpc.getDisConnectMethod = getDisConnectMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.StringMsg, io.yottachain.p2phost.pb.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisConnect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.StringMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("DisConnect"))
              .build();
        }
      }
    }
    return getDisConnectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.SendMsgReq,
      io.yottachain.p2phost.pb.SendMsgResp> getSendMsgMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMsg",
      requestType = io.yottachain.p2phost.pb.SendMsgReq.class,
      responseType = io.yottachain.p2phost.pb.SendMsgResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.SendMsgReq,
      io.yottachain.p2phost.pb.SendMsgResp> getSendMsgMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.SendMsgReq, io.yottachain.p2phost.pb.SendMsgResp> getSendMsgMethod;
    if ((getSendMsgMethod = P2PHostGrpc.getSendMsgMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getSendMsgMethod = P2PHostGrpc.getSendMsgMethod) == null) {
          P2PHostGrpc.getSendMsgMethod = getSendMsgMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.SendMsgReq, io.yottachain.p2phost.pb.SendMsgResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMsg"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.SendMsgReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.SendMsgResp.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("SendMsg"))
              .build();
        }
      }
    }
    return getSendMsgMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg,
      io.yottachain.p2phost.pb.Empty> getRegisterHandlerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterHandler",
      requestType = io.yottachain.p2phost.pb.StringMsg.class,
      responseType = io.yottachain.p2phost.pb.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg,
      io.yottachain.p2phost.pb.Empty> getRegisterHandlerMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg, io.yottachain.p2phost.pb.Empty> getRegisterHandlerMethod;
    if ((getRegisterHandlerMethod = P2PHostGrpc.getRegisterHandlerMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getRegisterHandlerMethod = P2PHostGrpc.getRegisterHandlerMethod) == null) {
          P2PHostGrpc.getRegisterHandlerMethod = getRegisterHandlerMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.StringMsg, io.yottachain.p2phost.pb.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterHandler"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.StringMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("RegisterHandler"))
              .build();
        }
      }
    }
    return getRegisterHandlerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg,
      io.yottachain.p2phost.pb.Empty> getUnregisterHandlerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnregisterHandler",
      requestType = io.yottachain.p2phost.pb.StringMsg.class,
      responseType = io.yottachain.p2phost.pb.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg,
      io.yottachain.p2phost.pb.Empty> getUnregisterHandlerMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.StringMsg, io.yottachain.p2phost.pb.Empty> getUnregisterHandlerMethod;
    if ((getUnregisterHandlerMethod = P2PHostGrpc.getUnregisterHandlerMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getUnregisterHandlerMethod = P2PHostGrpc.getUnregisterHandlerMethod) == null) {
          P2PHostGrpc.getUnregisterHandlerMethod = getUnregisterHandlerMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.StringMsg, io.yottachain.p2phost.pb.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnregisterHandler"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.StringMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new P2PHostMethodDescriptorSupplier("UnregisterHandler"))
              .build();
        }
      }
    }
    return getUnregisterHandlerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty,
      io.yottachain.p2phost.pb.Empty> getCloseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Close",
      requestType = io.yottachain.p2phost.pb.Empty.class,
      responseType = io.yottachain.p2phost.pb.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty,
      io.yottachain.p2phost.pb.Empty> getCloseMethod() {
    io.grpc.MethodDescriptor<io.yottachain.p2phost.pb.Empty, io.yottachain.p2phost.pb.Empty> getCloseMethod;
    if ((getCloseMethod = P2PHostGrpc.getCloseMethod) == null) {
      synchronized (P2PHostGrpc.class) {
        if ((getCloseMethod = P2PHostGrpc.getCloseMethod) == null) {
          P2PHostGrpc.getCloseMethod = getCloseMethod =
              io.grpc.MethodDescriptor.<io.yottachain.p2phost.pb.Empty, io.yottachain.p2phost.pb.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Close"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.yottachain.p2phost.pb.Empty.getDefaultInstance()))
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
    public void iD(io.yottachain.p2phost.pb.Empty request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.StringMsg> responseObserver) {
      asyncUnimplementedUnaryCall(getIDMethod(), responseObserver);
    }

    /**
     */
    public void addrs(io.yottachain.p2phost.pb.Empty request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.StringListMsg> responseObserver) {
      asyncUnimplementedUnaryCall(getAddrsMethod(), responseObserver);
    }

    /**
     */
    public void connect(io.yottachain.p2phost.pb.ConnectReq request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getConnectMethod(), responseObserver);
    }

    /**
     */
    public void disConnect(io.yottachain.p2phost.pb.StringMsg request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDisConnectMethod(), responseObserver);
    }

    /**
     */
    public void sendMsg(io.yottachain.p2phost.pb.SendMsgReq request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.SendMsgResp> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMsgMethod(), responseObserver);
    }

    /**
     */
    public void registerHandler(io.yottachain.p2phost.pb.StringMsg request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterHandlerMethod(), responseObserver);
    }

    /**
     */
    public void unregisterHandler(io.yottachain.p2phost.pb.StringMsg request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUnregisterHandlerMethod(), responseObserver);
    }

    /**
     */
    public void close(io.yottachain.p2phost.pb.Empty request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getCloseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.Empty,
                io.yottachain.p2phost.pb.StringMsg>(
                  this, METHODID_ID)))
          .addMethod(
            getAddrsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.Empty,
                io.yottachain.p2phost.pb.StringListMsg>(
                  this, METHODID_ADDRS)))
          .addMethod(
            getConnectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.ConnectReq,
                io.yottachain.p2phost.pb.Empty>(
                  this, METHODID_CONNECT)))
          .addMethod(
            getDisConnectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.StringMsg,
                io.yottachain.p2phost.pb.Empty>(
                  this, METHODID_DIS_CONNECT)))
          .addMethod(
            getSendMsgMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.SendMsgReq,
                io.yottachain.p2phost.pb.SendMsgResp>(
                  this, METHODID_SEND_MSG)))
          .addMethod(
            getRegisterHandlerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.StringMsg,
                io.yottachain.p2phost.pb.Empty>(
                  this, METHODID_REGISTER_HANDLER)))
          .addMethod(
            getUnregisterHandlerMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.StringMsg,
                io.yottachain.p2phost.pb.Empty>(
                  this, METHODID_UNREGISTER_HANDLER)))
          .addMethod(
            getCloseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                io.yottachain.p2phost.pb.Empty,
                io.yottachain.p2phost.pb.Empty>(
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

    @java.lang.Override
    protected P2PHostStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PHostStub(channel, callOptions);
    }

    /**
     */
    public void iD(io.yottachain.p2phost.pb.Empty request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.StringMsg> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addrs(io.yottachain.p2phost.pb.Empty request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.StringListMsg> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddrsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void connect(io.yottachain.p2phost.pb.ConnectReq request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void disConnect(io.yottachain.p2phost.pb.StringMsg request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDisConnectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMsg(io.yottachain.p2phost.pb.SendMsgReq request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.SendMsgResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void registerHandler(io.yottachain.p2phost.pb.StringMsg request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterHandlerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unregisterHandler(io.yottachain.p2phost.pb.StringMsg request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnregisterHandlerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void close(io.yottachain.p2phost.pb.Empty request,
        io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty> responseObserver) {
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

    @java.lang.Override
    protected P2PHostBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PHostBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.yottachain.p2phost.pb.StringMsg iD(io.yottachain.p2phost.pb.Empty request) {
      return blockingUnaryCall(
          getChannel(), getIDMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.StringListMsg addrs(io.yottachain.p2phost.pb.Empty request) {
      return blockingUnaryCall(
          getChannel(), getAddrsMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.Empty connect(io.yottachain.p2phost.pb.ConnectReq request) {
      return blockingUnaryCall(
          getChannel(), getConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.Empty disConnect(io.yottachain.p2phost.pb.StringMsg request) {
      return blockingUnaryCall(
          getChannel(), getDisConnectMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.SendMsgResp sendMsg(io.yottachain.p2phost.pb.SendMsgReq request) {
      return blockingUnaryCall(
          getChannel(), getSendMsgMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.Empty registerHandler(io.yottachain.p2phost.pb.StringMsg request) {
      return blockingUnaryCall(
          getChannel(), getRegisterHandlerMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.Empty unregisterHandler(io.yottachain.p2phost.pb.StringMsg request) {
      return blockingUnaryCall(
          getChannel(), getUnregisterHandlerMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.yottachain.p2phost.pb.Empty close(io.yottachain.p2phost.pb.Empty request) {
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

    @java.lang.Override
    protected P2PHostFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new P2PHostFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.StringMsg> iD(
        io.yottachain.p2phost.pb.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getIDMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.StringListMsg> addrs(
        io.yottachain.p2phost.pb.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getAddrsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.Empty> connect(
        io.yottachain.p2phost.pb.ConnectReq request) {
      return futureUnaryCall(
          getChannel().newCall(getConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.Empty> disConnect(
        io.yottachain.p2phost.pb.StringMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getDisConnectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.SendMsgResp> sendMsg(
        io.yottachain.p2phost.pb.SendMsgReq request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMsgMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.Empty> registerHandler(
        io.yottachain.p2phost.pb.StringMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterHandlerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.Empty> unregisterHandler(
        io.yottachain.p2phost.pb.StringMsg request) {
      return futureUnaryCall(
          getChannel().newCall(getUnregisterHandlerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.yottachain.p2phost.pb.Empty> close(
        io.yottachain.p2phost.pb.Empty request) {
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

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ID:
          serviceImpl.iD((io.yottachain.p2phost.pb.Empty) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.StringMsg>) responseObserver);
          break;
        case METHODID_ADDRS:
          serviceImpl.addrs((io.yottachain.p2phost.pb.Empty) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.StringListMsg>) responseObserver);
          break;
        case METHODID_CONNECT:
          serviceImpl.connect((io.yottachain.p2phost.pb.ConnectReq) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty>) responseObserver);
          break;
        case METHODID_DIS_CONNECT:
          serviceImpl.disConnect((io.yottachain.p2phost.pb.StringMsg) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty>) responseObserver);
          break;
        case METHODID_SEND_MSG:
          serviceImpl.sendMsg((io.yottachain.p2phost.pb.SendMsgReq) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.SendMsgResp>) responseObserver);
          break;
        case METHODID_REGISTER_HANDLER:
          serviceImpl.registerHandler((io.yottachain.p2phost.pb.StringMsg) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty>) responseObserver);
          break;
        case METHODID_UNREGISTER_HANDLER:
          serviceImpl.unregisterHandler((io.yottachain.p2phost.pb.StringMsg) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty>) responseObserver);
          break;
        case METHODID_CLOSE:
          serviceImpl.close((io.yottachain.p2phost.pb.Empty) request,
              (io.grpc.stub.StreamObserver<io.yottachain.p2phost.pb.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
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

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.yottachain.p2phost.pb.P2PHostProto.getDescriptor();
    }

    @java.lang.Override
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

    @java.lang.Override
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
