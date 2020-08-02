package com.spring.layer.service;

import com.spring.layer.entity.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> queryMenuList(Menu menu);

    public List<Menu> queryMenuTree(Menu menu);

    int add(Menu dept);

    Menu queryById(Integer id);

    int deleteById(Integer id);

    int editMenu(Menu dept);
}
