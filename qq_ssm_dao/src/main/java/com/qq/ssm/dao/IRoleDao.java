package com.qq.ssm.dao;

import com.qq.ssm.domain.Permission;
import com.qq.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //根据userid查找该用户所有的角色
    @Select("select * from role where id in " +
            "(select roleId from users_role where userId = #{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissions",
                    column = "id",
                    many = @Many(select = "com.qq.ssm.dao.IPermissionDao.findByRoleId"))
    })
    List<Role> findRolesByUserId(String id);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void addRole(Role role);

    @Delete("delete from role where id = #{id}")
    void delRole(String id);

    @Delete("delete from role_permission where roleId = #{id}")
    void delRole_Permission(String id);

    @Select("select * from role where id not in " +
            "(select roleId from users_role where userId = #{id})")
    List<Role> otherRoles(String id);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissions",
                    column = "id",
                    many = @Many(select = "com.qq.ssm.dao.IPermissionDao.findByRoleId"))
    })
    Role findById(String id);

    @Select("select * from permission where id not in " +
            "(select permissionId from role_permission where roleId= #{id})")
    List<Permission> otherpermissions(String id);

    @Delete("delete from role_permission where permissionid = #{permissionid} and roleId = #{roleid}")
    void delPermission(@Param("roleid") String roleid,@Param("permissionid") String permissionid);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleid},#{permissionid})")
    void addPermissions(@Param("roleid")String roleid,@Param("permissionid") String permissionid);
}
