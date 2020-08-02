package com.spring.layer.entity;

import java.io.Serializable;
import java.util.List;

public class RoleMenu implements Serializable {

    private Integer id;
    private Integer roleId;
    private Integer menuId;
    private List<Integer> menuIds;

    public RoleMenu() {
    }

    public RoleMenu(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
}
