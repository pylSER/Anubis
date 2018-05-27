package com.anubis.sso.register.registerService;

import com.anubis.sso.RegResult;
import com.anubis.sso.UserInfo;

public interface RegisterService {
    public RegResult register(UserInfo userInfo);
}
