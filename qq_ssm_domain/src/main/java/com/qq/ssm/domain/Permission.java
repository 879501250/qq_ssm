package com.qq.ssm.domain;

import java.util.List;

/**
 * 资源权限
 */
public class Permission {

    private String id;  //无意义，主键uuid
    private String permissionName;  //权限名
    private String url;  //资源路径
    private List<Role> roles;  //管理的角色

    public Permission() {
    }

    public Permission(String id, String permissionName, String url, List<Role> roles) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roles=" + roles +
                '}';
    }
}
