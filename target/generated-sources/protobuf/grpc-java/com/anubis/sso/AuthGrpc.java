package com.anubis.sso;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: auth.proto")
public final class AuthGrpc {

  private AuthGrpc() {}

  public static final String SERVICE_NAME = "com.anubis.sso.Auth";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAuthMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.anubis.sso.TokenInfo,
      com.anubis.sso.AuthResult> METHOD_AUTH = getAuthMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.anubis.sso.TokenInfo,
      com.anubis.sso.AuthResult> getAuthMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.anubis.sso.TokenInfo,
      com.anubis.sso.AuthResult> getAuthMethod() {
    return getAuthMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.anubis.sso.TokenInfo,
      com.anubis.sso.AuthResult> getAuthMethodHelper() {
    io.grpc.MethodDescriptor<com.anubis.sso.TokenInfo, com.anubis.sso.AuthResult> getAuthMethod;
    if ((getAuthMethod = AuthGrpc.getAuthMethod) == null) {
      synchronized (AuthGrpc.class) {
        if ((getAuthMethod = AuthGrpc.getAuthMethod) == null) {
          AuthGrpc.getAuthMethod = getAuthMethod = 
              io.grpc.MethodDescriptor.<com.anubis.sso.TokenInfo, com.anubis.sso.AuthResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.anubis.sso.Auth", "auth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.anubis.sso.TokenInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.anubis.sso.AuthResult.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthMethodDescriptorSupplier("auth"))
                  .build();
          }
        }
     }
     return getAuthMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.LoginResult> METHOD_LOGIN = getLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.LoginResult> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.LoginResult> getLoginMethod() {
    return getLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.LoginResult> getLoginMethodHelper() {
    io.grpc.MethodDescriptor<com.anubis.sso.UserInfo, com.anubis.sso.LoginResult> getLoginMethod;
    if ((getLoginMethod = AuthGrpc.getLoginMethod) == null) {
      synchronized (AuthGrpc.class) {
        if ((getLoginMethod = AuthGrpc.getLoginMethod) == null) {
          AuthGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.anubis.sso.UserInfo, com.anubis.sso.LoginResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.anubis.sso.Auth", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.anubis.sso.UserInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.anubis.sso.LoginResult.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRegisterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.RegResult> METHOD_REGISTER = getRegisterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.RegResult> getRegisterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.RegResult> getRegisterMethod() {
    return getRegisterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.anubis.sso.UserInfo,
      com.anubis.sso.RegResult> getRegisterMethodHelper() {
    io.grpc.MethodDescriptor<com.anubis.sso.UserInfo, com.anubis.sso.RegResult> getRegisterMethod;
    if ((getRegisterMethod = AuthGrpc.getRegisterMethod) == null) {
      synchronized (AuthGrpc.class) {
        if ((getRegisterMethod = AuthGrpc.getRegisterMethod) == null) {
          AuthGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<com.anubis.sso.UserInfo, com.anubis.sso.RegResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.anubis.sso.Auth", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.anubis.sso.UserInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.anubis.sso.RegResult.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthStub newStub(io.grpc.Channel channel) {
    return new AuthStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthImplBase implements io.grpc.BindableService {

    /**
     */
    public void auth(com.anubis.sso.TokenInfo request,
        io.grpc.stub.StreamObserver<com.anubis.sso.AuthResult> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthMethodHelper(), responseObserver);
    }

    /**
     */
    public void login(com.anubis.sso.UserInfo request,
        io.grpc.stub.StreamObserver<com.anubis.sso.LoginResult> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethodHelper(), responseObserver);
    }

    /**
     */
    public void register(com.anubis.sso.UserInfo request,
        io.grpc.stub.StreamObserver<com.anubis.sso.RegResult> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuthMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.anubis.sso.TokenInfo,
                com.anubis.sso.AuthResult>(
                  this, METHODID_AUTH)))
          .addMethod(
            getLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.anubis.sso.UserInfo,
                com.anubis.sso.LoginResult>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getRegisterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.anubis.sso.UserInfo,
                com.anubis.sso.RegResult>(
                  this, METHODID_REGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class AuthStub extends io.grpc.stub.AbstractStub<AuthStub> {
    private AuthStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthStub(channel, callOptions);
    }

    /**
     */
    public void auth(com.anubis.sso.TokenInfo request,
        io.grpc.stub.StreamObserver<com.anubis.sso.AuthResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuthMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.anubis.sso.UserInfo request,
        io.grpc.stub.StreamObserver<com.anubis.sso.LoginResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void register(com.anubis.sso.UserInfo request,
        io.grpc.stub.StreamObserver<com.anubis.sso.RegResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthBlockingStub extends io.grpc.stub.AbstractStub<AuthBlockingStub> {
    private AuthBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.anubis.sso.AuthResult auth(com.anubis.sso.TokenInfo request) {
      return blockingUnaryCall(
          getChannel(), getAuthMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.anubis.sso.LoginResult login(com.anubis.sso.UserInfo request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.anubis.sso.RegResult register(com.anubis.sso.UserInfo request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthFutureStub extends io.grpc.stub.AbstractStub<AuthFutureStub> {
    private AuthFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.anubis.sso.AuthResult> auth(
        com.anubis.sso.TokenInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getAuthMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.anubis.sso.LoginResult> login(
        com.anubis.sso.UserInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.anubis.sso.RegResult> register(
        com.anubis.sso.UserInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTH = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_REGISTER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTH:
          serviceImpl.auth((com.anubis.sso.TokenInfo) request,
              (io.grpc.stub.StreamObserver<com.anubis.sso.AuthResult>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.anubis.sso.UserInfo) request,
              (io.grpc.stub.StreamObserver<com.anubis.sso.LoginResult>) responseObserver);
          break;
        case METHODID_REGISTER:
          serviceImpl.register((com.anubis.sso.UserInfo) request,
              (io.grpc.stub.StreamObserver<com.anubis.sso.RegResult>) responseObserver);
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

  private static abstract class AuthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.anubis.sso.AuthOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Auth");
    }
  }

  private static final class AuthFileDescriptorSupplier
      extends AuthBaseDescriptorSupplier {
    AuthFileDescriptorSupplier() {}
  }

  private static final class AuthMethodDescriptorSupplier
      extends AuthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthFileDescriptorSupplier())
              .addMethod(getAuthMethodHelper())
              .addMethod(getLoginMethodHelper())
              .addMethod(getRegisterMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
