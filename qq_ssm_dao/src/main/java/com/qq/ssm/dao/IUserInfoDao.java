package com.qq.ssm.dao;

import com.qq.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserInfoDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles",
                    column = "id",
                    many = @Many(select = "com.qq.ssm.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findUser(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(id,email,username,password,phoneNum,status) " +
            "values(#{id},#{email},#{username}," +
            "#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles",
                    column = "id",
                    many = @Many(select = "com.qq.ssm.dao.IRoleDao.findRolesByUserId"))
    })
    UserInfo findById(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userid},#{roleid})")
    void addRole(@Param("userid") String userid, @Param("roleid") String roleid);

    @Delete("delete from users_role where userId = #{userid} and roleId = #{roleid}")
    void delRole(@Param("userid") String userid, @Param("roleid") String roleid);
}
