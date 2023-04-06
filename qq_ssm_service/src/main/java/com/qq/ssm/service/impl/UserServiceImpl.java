package com.qq.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.qq.ssm.dao.IUserInfoDao;
import com.qq.ssm.domain.Role;
import com.qq.ssm.domain.UserInfo;
import com.qq.ssm.service.IUserService;
import com.qq.ssm.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//设置service别名为userService供spring-security.xml调用
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserInfo findById(String id) {
        return userInfoDao.findById(id);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfo.setId(UUIDGenerator.getUUID());
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode("123"));
        userInfoDao.addUser(userInfo);
    }

    @Override
    public void delRole(String userid, String roleid) {
        userInfoDao.delRole(userid, roleid);
    }

    @Override
    public void addRole(String userid, String roleid) {
        userInfoDao.addRole(userid, roleid);
    }

    @Override
    public List<UserInfo> findAll(int pageNum, int pageSize) {
        //在真正执行sql前，自动分页，pageNum：页码值；pageSize：每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return userInfoDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoDao.findUser(username);
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true,
                true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
