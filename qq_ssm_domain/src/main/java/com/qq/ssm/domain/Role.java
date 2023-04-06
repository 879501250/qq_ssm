package com.qq.ssm.domain;

import java.util.List;

/**
 * 资源权限
 */
public class Role {

    private String id;  //无意义，主键uuid
    private String roleName;  //角色名
    private String roleDesc;  //角色描述
    private List<Permission> permissions;  //关联的权限
    private List<UserInfo> userInfo;  //关联的用户

    public Role() {
    }

    public Role(String id, String roleName, String roleDesc, List<Permission> permissions, List<UserInfo> userInfo) {
        this.id = id;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.permissions = permissions;
        this.userInfo = userInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<UserInfo> userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", permissions=" + permissions +
                ", userInfo=" + userInfo +
                '}';
    }
}
