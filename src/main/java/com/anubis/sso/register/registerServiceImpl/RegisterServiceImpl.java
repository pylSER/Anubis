package com.anubis.sso.register.registerServiceImpl;


import com.anubis.sso.RegResult;
import com.anubis.sso.UserInfo;
import com.anubis.sso.dao.DaoService;
import com.anubis.sso.dao.SsoinfoEntity;
import com.anubis.sso.register.registerService.RegisterService;
import com.anubis.sso.register.rule.PwdRuleFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@Service("register")
public class RegisterServiceImpl implements RegisterService {
    private final static String currentPwdRule="noRule";

    @Resource
    DaoService daoService;



    @Override
    public RegResult register(UserInfo userInfo) {
        //check if user exists first
        SsoinfoEntity dbentity=daoService.findSsoinfoEntityByUserName(userInfo.getUserName());

        if(dbentity!=null){
            //duplicate name!
            RegResult regResult=RegResult.newBuilder().setIsRegOK(false)
                    .setIsPwdTooEasy(false)
                    .setIsUserExists(true).build();
            return regResult;

        }else{
            //check if pwd too easy
            if(isPwdTooEasy(userInfo.getPassword())){
                //too easy!
                RegResult regResult=RegResult.newBuilder().setIsRegOK(false)
                        .setIsPwdTooEasy(true)
                        .setIsUserExists(false).build();
                return regResult;
            }else{
                //ok to reg
                SsoinfoEntity entity=new SsoinfoEntity();

                entity.setUserName(userInfo.getUserName());
                entity.setPassword(userInfo.getPassword());

                Date date=new Date();
                Timestamp currentTime=new Timestamp(date.getTime());
                entity.setRegTime(currentTime);

                RegResult regResult=RegResult.newBuilder().setIsRegOK(true)
                        .setIsPwdTooEasy(false)
                        .setIsUserExists(false).build();

                daoService.saveAndFlush(entity);

                return regResult;

            }

        }
    }


    private boolean isPwdTooEasy(String pwd){
        PwdRuleFactory ruleFactory =new PwdRuleFactory();

        return ruleFactory.getPwdRule(currentPwdRule).isPwdTooEasy(pwd);
    }
}
