package com.anubis.sso.login.loginServiceImpl;

import com.anubis.sso.UserInfo;
import com.anubis.sso.dao.DaoService;
import com.anubis.sso.dao.SsoinfoEntity;
import com.anubis.sso.login.loginService.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;


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
    public String generateAndSaveToken(String username) {
        String md5=getMD5(username);

        String loginTime=""+System.currentTimeMillis();

        String token= md5+loginTime;

        //save token and update login Time

        SsoinfoEntity entity=daoService.findSsoinfoEntityByUserName(username);

        entity.setToken(token);

        Date date=new Date();
        Timestamp currentTime=new Timestamp(date.getTime());
        entity.setLastLoginTime(currentTime);

        daoService.saveAndFlush(entity);

        return token;
    }


    private String getMD5(String info) {
        try {
            //获取 MessageDigest 对象，参数为 MD5 字符串，表示这是一个 MD5 算法（其他还有 SHA1 算法等）：
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //update(byte[])方法，输入原数据
            //类似StringBuilder对象的append()方法，追加模式，属于一个累计更改的过程
            md5.update(info.getBytes("UTF-8"));
            //digest()被调用后,MessageDigest对象就被重置，即不能连续再次调用该方法计算原数据的MD5值。可以手动调用reset()方法重置输入源。
            //digest()返回值16位长度的哈希值，由byte[]承接
            byte[] md5Array = md5.digest();
            //byte[]通常我们会转化为十六进制的32位长度的字符串来使用,本文会介绍三种常用的转换方法
            return DatatypeConverter.printHexBinary(md5Array);
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
