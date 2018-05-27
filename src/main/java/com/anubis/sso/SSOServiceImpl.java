package com.anubis.sso;

import com.anubis.sso.login.loginService.LoginService;
import com.anubis.sso.register.registerService.RegisterService;
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

    @Resource
    RegisterService registerService;


    @Override
    public void auth(TokenInfo request, StreamObserver<AuthResult> responseObserver) {
        super.auth(request, responseObserver);

        logger.info("now is in the auth()");


    }

    @Override
    public void login(UserInfo request, StreamObserver<LoginResult> responseObserver) {
        logger.info("now is in the login(),username:{},password:{}",request.getUserName(),request.getPassword());

        boolean isPasswordRight=loginService.verifyUserNameAndPassword(request);

        String token="";

        if(isPasswordRight){
           token=loginService.generateAndSaveToken(request.getUserName());
        }


        LoginResult result=LoginResult.newBuilder()
                .setIsLoginOK(isPasswordRight)
                .setToken(token).build();

        responseObserver.onNext(result);

        responseObserver.onCompleted();
    }

    @Override
    public void register(UserInfo request, StreamObserver<RegResult> responseObserver) {
        logger.info("now is in the register()username:{},password:{}",request.getUserName(),request.getPassword());

        RegResult regResult=registerService.register(request);

        responseObserver.onNext(regResult);

        responseObserver.onCompleted();
    }
}
