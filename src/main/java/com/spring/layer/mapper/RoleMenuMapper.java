package com.spring.layer.mapper;

import com.spring.layer.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMenuMapper {

    List<RoleMenu> queryRoleMenuList(RoleMenu RoleMenu);

    int addRoleMenu(RoleMenu RoleMenu);

}
