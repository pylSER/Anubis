package com.anubis.sso.grpc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class GrpcServer implements ApplicationListener<ContextRefreshedEvent> {


    private final static Logger logger= LoggerFactory.getLogger(GrpcServer.class);

    @Resource GrpcStarter grpcStarter;


    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        grpcStarter.startServer();
    }




}
