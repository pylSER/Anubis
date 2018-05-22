package com.anubis.sso.login.loginServiceImpl;

import com.anubis.sso.UserInfo;
import com.anubis.sso.dao.DaoService;
import com.anubis.sso.dao.SsoinfoEntity;
import com.anubis.sso.login.loginService.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("login")
public class LoginServiceImpl implements LoginService{

    @Resource
    private DaoService daoService;


    @Override
    public boolean verifyUserNameAndPassword(UserInfo userInfo) {
        String name=userInfo.getUserName();

        SsoinfoEntity dbentity=daoService.findSsoinfoEntityByUserName(name);

        if(dbentity==null){
            return false;
        }

        if(userInfo.getPassword().equals(dbentity.getPassword())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String generateToken() {
        return null;
    }
}
