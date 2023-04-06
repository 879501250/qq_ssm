package com.qq.ssm.service;

import com.qq.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UserInfo> findAll(int pageNum,int pageSize);

    void addUser(UserInfo userInfo);

    UserInfo findById(String id);

    void addRole(String userid, String s);

    void delRole(String userid, String roleid);
}
