package com.anubis.sso.encrypt.encryptServiceImpl;

import com.anubis.sso.encrypt.encryptService.EncryptService;

public class NoEncryptService implements EncryptService {
    @Override
    public String encrypt(String str) {
        return str;
    }
}
