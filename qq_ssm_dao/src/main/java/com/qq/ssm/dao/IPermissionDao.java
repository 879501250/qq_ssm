package com.qq.ssm.dao;

import com.qq.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    //根据roleid查询该角色所拥有的所有权限
    @Select("select * from permission where id in " +
            "(select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void addPermission(Permission permission);

    @Delete("delete from role_permission where permissionId = #{id}")
    void delPermission_Role(String id);

    @Delete("delete from permission where id = #{id}")
    void delPermission(String id);
}
