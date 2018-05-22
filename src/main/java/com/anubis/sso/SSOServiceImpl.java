package com.anubis.sso;

import com.anubis.sso.login.loginService.LoginService;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SSOServiceImpl extends AuthGrpc.AuthImplBase{

    private final static Logger logger= LoggerFactory.getLogger(SSOServiceImpl.class);

    @Resource
    LoginService loginService;


    @Override
    public void auth(TokenInfo request, StreamObserver<AuthResult> responseObserver) {
        super.auth(request, responseObserver);

        logger.info("now is in the auth()");


    }

    @Override
    public void login(UserInfo request, StreamObserver<LoginResult> responseObserver) {
        logger.info("now is in the login(),username:{},password:{}",request.getUserName(),request.getPassword());

        boolean isPasswordRight=loginService.verifyUserNameAndPassword(request);


        LoginResult result=LoginResult.newBuilder().setIsLoginOK(isPasswordRight).build();

        responseObserver.onNext(result);

        responseObserver.onCompleted();
    }

    @Override
    public void register(UserInfo request, StreamObserver<RegResult> responseObserver) {
        super.register(request, responseObserver);

        logger.info("now is in the register()");
    }
}
