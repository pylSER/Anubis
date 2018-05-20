package com.anubis.sso;

public class SSOConfig {
    private SSOConfig(){

    }

    private static int port;
    private static int expiredMinutes;

    public static void setPort(int portint){
        port=portint;
    }

    public static void setExpiredMinutes(int minutes){
        expiredMinutes=minutes;
    }

    public static int getExpiredMinutes(){
        return expiredMinutes;
    }

    public static int getPort(){
        return port;
    }
}
