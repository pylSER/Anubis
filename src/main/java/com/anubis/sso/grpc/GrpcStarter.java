package com.anubis.sso.grpc;

import com.amihaiemil.camel.Yaml;
import com.amihaiemil.camel.YamlMapping;
import com.anubis.sso.SSOConfig;
import com.anubis.sso.SSOServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class GrpcStarter {
    private static final String configFilePath="config.yml";
    private final static Logger logger= LoggerFactory.getLogger(GrpcStarter.class);

    @Async
    protected void startServer(){
        if(initConfig()){
            Server server= ServerBuilder.forPort(SSOConfig.getPort()).addService(new SSOServiceImpl()).build();
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
            File configFile=new File(GrpcStarter.class.getResource("../../../../").getPath()+configFilePath);
            YamlMapping yamlMapping = Yaml.createYamlInput(configFile).readYamlMapping();
            String portStr=yamlMapping.string("port");
            String expiredMinutesStr=yamlMapping.string("expiredMinutes");

            int port=Integer.parseInt(portStr);
            int expiredMinutes=Integer.parseInt(expiredMinutesStr);

            SSOConfig.setExpiredMinutes(expiredMinutes);
            SSOConfig.setPort(port);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Config Reading Failed");
            return false;
        }
    }
}
