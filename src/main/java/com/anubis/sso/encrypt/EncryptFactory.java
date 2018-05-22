package com.anubis.sso.encrypt;

import com.anubis.sso.encrypt.encryptService.EncryptService;
import com.anubis.sso.encrypt.encryptServiceImpl.MD5EncryptService;
import com.anubis.sso.encrypt.encryptServiceImpl.NoEncryptService;
import org.springframework.stereotype.Component;


@Component
public class EncryptFactory {

    public EncryptService getEncryptService(String encryptType){
        switch (encryptType){
            case "md5":
                return new MD5EncryptService();
            case "noEncrypt":
                return new NoEncryptService();
                //you can add your own encrypt method if necessary
        }


        return null;
    }




}
