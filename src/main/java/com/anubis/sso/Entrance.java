package com.anubis.sso;

import com.amihaiemil.camel.Yaml;
import com.amihaiemil.camel.YamlMapping;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.IOException;


public class Entrance {
    private static final String configFilePath="config.yml";

    private final static Logger logger=Logger.getLogger(Entrance.class);

    public static void main(String[] args){
        if(initConfig()){
            Server server= ServerBuilder.forPort(SSOConfig.getPort()).addService(new SSOServiceImpl()).build();
            try {
                server.start();


                logger.info("Server Started!");


                server.awaitTermination();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Server Start Failed");
            }


        }
    }


    private static boolean initConfig(){
        try {
            File configFile=new File(Entrance.class.getResource("../../../").getPath()+configFilePath);
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
