package com.spring.layer.service.impl;

import com.spring.layer.entity.Menu;
import com.spring.layer.entity.RoleMenu;
import com.spring.layer.entity.TreeType;
import com.spring.layer.mapper.MenuMapper;
import com.spring.layer.mapper.RoleMenuMapper;
import com.spring.layer.service.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    private static Logger logger = LoggerFactory.getLogger(RoleMenuServiceImpl.class);

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<RoleMenu> queryRoleMenuList(RoleMenu roleMenu) {
        return roleMenuMapper.queryRoleMenuList(roleMenu);
    }

    @Override
    public int addRoleMenu(RoleMenu roleMenu) {
        return roleMenuMapper.addRoleMenu(roleMenu);
    }

    @Override
    public int deleteRoleMenuByRoleId(Integer roleId) {
        return roleMenuMapper.deleteRoleMenuByRoleId(roleId);
    }

    @Override
    public List<Menu> queryRoleMenuTree(RoleMenu roleMenu) {
        List<Menu> menus = menuMapper.queryMenuList(null);
        List<RoleMenu> roleMenus = roleMenuMapper.queryRoleMenuList(roleMenu);
        for (RoleMenu rm : roleMenus) {
            for (Menu menu : menus) {
                if(Objects.equals(rm.getMenuId(),menu.getId())){
                    List<TreeType> checkArr = menu.getCheckArr();
                    TreeType treeType = checkArr.get(0);
                    treeType.setChecked("1");
                }
            }
        }
        return menus;
    }
}
