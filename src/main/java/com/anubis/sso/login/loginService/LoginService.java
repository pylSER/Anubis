package com.anubis.sso.login.loginService;

import com.anubis.sso.UserInfo;

public interface LoginService {
    public boolean verifyUserNameAndPassword(UserInfo userInfo);

    public String generateAndSaveToken(String username);
}
