package com.anubis.sso.auth.authServiceImpl;

import com.anubis.sso.SSOConfig;
import com.anubis.sso.auth.authService.AuthService;
import com.anubis.sso.dao.DaoService;
import com.anubis.sso.dao.SsoinfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


@Service("auth")
public class AuthServiceImpl implements AuthService {

    private final static Logger logger= LoggerFactory.getLogger(AuthServiceImpl.class);

    @Resource
    DaoService daoService;

    @Override
    public boolean auth(String token) {
        SsoinfoEntity entity=daoService.findSsoinfoEntityByToken(token);

        if(entity==null){
            return false;
        }else{
            // check if in the expired time
            final Timestamp lastLoginTime = entity.getLastLoginTime();

            Date lastLoginDate=lastLoginTime;

            Date nowDate=new Date();

            long interval=  ((nowDate.getTime()-lastLoginDate.getTime())/(1000*60));

            if(interval>SSOConfig.getExpiredMinutes()){
                return false;
            }else {
                // refresh lastloginTime
                Timestamp currentTime=new Timestamp(nowDate.getTime());
                entity.setLastLoginTime(currentTime);

                daoService.saveAndFlush(entity);

                return true;
            }

        }
    }
}
