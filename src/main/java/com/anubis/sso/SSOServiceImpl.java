package com.anubis.sso;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSOServiceImpl extends AuthGrpc.AuthImplBase{

    private final static Logger logger= LoggerFactory.getLogger(SSOServiceImpl.class);

    @Override
    public void auth(TokenInfo request, StreamObserver<AuthResult> responseObserver) {
        super.auth(request, responseObserver);

        logger.info("now is in the auth()");


    }

    @Override
    public void login(UserInfo request, StreamObserver<LoginResult> responseObserver) {
        logger.info("now is in the login(),username:{},password:{}",request.getUserName(),request.getPassword());

        LoginResult result=LoginResult.newBuilder().setIsLoginOK(false).build();

        responseObserver.onNext(result);

        responseObserver.onCompleted();
    }

    @Override
    public void register(UserInfo request, StreamObserver<RegResult> responseObserver) {
        super.register(request, responseObserver);

        logger.info("now is in the register()");
    }
}
