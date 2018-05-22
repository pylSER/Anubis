package com.anubis.sso.dao;

import com.anubis.sso.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


@Repository("ssoDao")
public interface DaoService extends JpaRepository<SsoinfoEntity,Long>{
    SsoinfoEntity findSsoinfoEntityByUserName(String username);

    @Override
    SsoinfoEntity saveAndFlush(SsoinfoEntity s);
}
