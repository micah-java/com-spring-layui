package com.spring.layer.mapper;

import com.spring.layer.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface MenuMapper {

    List<Menu> queryMenuList(Menu menu);

    List<Menu> queryMenuTreeByRoleId(@Param("roleIds") Set<Integer> roleIds);

    int add(Menu dept);

    Menu queryById(@Param("id") Integer id);

    int editMenu(Menu menu);

    int deleteById(@Param("id") Integer id);
}
