package com.qq.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.qq.ssm.dao.IRoleDao;
import com.qq.ssm.domain.Permission;
import com.qq.ssm.domain.Role;
import com.qq.ssm.service.IRoleServiec;
import com.qq.ssm.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleServiec {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> otherRoles(String id) {
        return roleDao.otherRoles(id);
    }

    @Override
    public void addRole(Role role) {
        role.setId(UUIDGenerator.getUUID());
        roleDao.addRole(role);
    }

    @Override
    public List<Permission> otherpermissions(String id) {
        return roleDao.otherpermissions(id);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void addPermissions(String roleid, String permissionid) {
        roleDao.addPermissions(roleid, permissionid);
    }

    @Override
    public void delPermission(String roleid, String permissionid) {
        roleDao.delPermission(roleid, permissionid);
    }

    @Override
    public void delRole(String id) {
        roleDao.delRole_Permission(id);
        roleDao.delRole(id);
    }

    @Override
    public List<Role> findAll(int pageNum, int pageSize) {
        //在真正执行sql前，自动分页，pageNum：页码值；pageSize：每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return roleDao.findAll();
    }
}
