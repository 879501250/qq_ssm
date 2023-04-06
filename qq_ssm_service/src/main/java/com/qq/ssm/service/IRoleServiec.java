package com.qq.ssm.service;

import com.qq.ssm.domain.Permission;
import com.qq.ssm.domain.Role;

import java.util.List;

public interface IRoleServiec {
    List<Role> findAll(int pageNum, int pageSize);

    void addRole(Role role);

    void delRole(String id);

    List<Role> otherRoles(String id);

    Role findById(String id);

    List<Permission> otherpermissions(String id);

    void delPermission(String roleid, String permissionid);

    void addPermissions(String roleid, String permissionid);
}
