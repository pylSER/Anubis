package com.anubis.sso.grpc;

import com.anubis.sso.SSOConfig;
import com.anubis.sso.SSOServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Component
public class GrpcStarter {
    private static final String configFilePath="config.yml";
    private final static Logger logger= LoggerFactory.getLogger(GrpcStarter.class);


    @Value("${grpc.port}")
    private String grpcPort;

    @Value("${grpc.expiredMinutes}")
    private String grpcExpiredMinutes;

    @Resource
    SSOServiceImpl ssoService;

    @Async
    protected void startServer(){
        if(initConfig()){
            Server server= ServerBuilder.forPort(SSOConfig.getPort()).addService(ssoService).build();
            try {
                server.start();

                logger.info("Server Started at {}!",SSOConfig.getPort());


                server.awaitTermination();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Server Start Failed");
            }


        }
    }


    private boolean initConfig(){
        try {
            int port=Integer.parseInt(grpcPort);
            int expiredMinutes=Integer.parseInt(grpcExpiredMinutes);

            SSOConfig.setExpiredMinutes(expiredMinutes);
            SSOConfig.setPort(port);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Config Reading Failed");
            return false;
        }
    }
}
