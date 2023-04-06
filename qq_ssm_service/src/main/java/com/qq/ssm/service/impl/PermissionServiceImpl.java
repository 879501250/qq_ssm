package com.qq.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.qq.ssm.dao.IPermissionDao;
import com.qq.ssm.domain.Permission;
import com.qq.ssm.service.IPermissionService;
import com.qq.ssm.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public void delPermission(String id) {
        permissionDao.delPermission_Role(id);
        permissionDao.delPermission(id);
    }

    @Override
    public void addPermission(Permission permission) {
        permission.setId(UUIDGenerator.getUUID());
        permissionDao.addPermission(permission);
    }

    @Override
    public List<Permission> findAll(int pageNum, int pageSize) {
        //在真正执行sql前，自动分页，pageNum：页码值；pageSize：每页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return permissionDao.findAll();
    }
}
