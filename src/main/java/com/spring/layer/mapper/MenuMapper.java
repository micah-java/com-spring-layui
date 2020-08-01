package com.spring.layer.mapper;

import com.spring.layer.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu> queryMenuList(Menu menu);

    int add(Menu dept);

    Menu queryById(@Param("id") Integer id);

    int editMenu(Menu menu);

    int deleteById(@Param("id") Integer id);
}
