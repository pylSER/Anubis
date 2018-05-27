package com.anubis.sso.register.rule;

public class NoRule implements PwdRule{
    @Override
    public boolean isPwdTooEasy(String pwd) {
        return false;
    }
}
