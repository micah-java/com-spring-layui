package com.spring.layer.service;

import com.spring.layer.entity.Menu;
import com.spring.layer.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    public List<RoleMenu> queryRoleMenuList(RoleMenu roleMenu);

    public List<Menu> queryRoleMenuTree(RoleMenu roleMenu);

    int addRoleMenu(RoleMenu roleMenu);
}
