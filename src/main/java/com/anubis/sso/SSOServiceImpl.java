package com.anubis.sso;

import io.grpc.stub.StreamObserver;
import org.apache.log4j.Logger;

public class SSOServiceImpl extends AuthGrpc.AuthImplBase{

    private final static Logger logger=Logger.getLogger(SSOServiceImpl.class);

    @Override
    public void auth(TokenInfo request, StreamObserver<AuthResult> responseObserver) {
        super.auth(request, responseObserver);

        logger.info("now is in the auth()");


    }

    @Override
    public void login(UserInfo request, StreamObserver<LoginResult> responseObserver) {
        super.login(request, responseObserver);

        logger.info("now is in the login()");
    }

    @Override
    public void register(UserInfo request, StreamObserver<RegResult> responseObserver) {
        super.register(request, responseObserver);

        logger.info("now is in the register()");
    }
}
