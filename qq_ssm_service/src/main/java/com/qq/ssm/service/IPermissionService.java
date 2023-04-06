package com.qq.ssm.service;

import com.qq.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll(int pageNum, int pageSize);

    void addPermission(Permission permission);

    void delPermission(String id);
}
