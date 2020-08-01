package com.spring.layer.service.impl;

import com.spring.layer.entity.Menu;
import com.spring.layer.mapper.MenuMapper;
import com.spring.layer.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> queryMenuList(Menu menu) {
        List<Menu> menus = menuMapper.queryMenuList(menu);
        List<Menu> menuRootTree = menus.stream().filter(e -> e.getParentId() == -1).collect(Collectors.toList());
        for(Menu m : menuRootTree){
            List<Menu> children = bilidChildren(m.getId(), menus);
            m.setChildren(children);
        }
        return menuRootTree;
    }
    //递归构建子节点
    private List<Menu> bilidChildren(Integer id,List<Menu> menus){
        List<Menu> menuChildren = new ArrayList<>();
        for(Menu m : menus){
            if(id == m.getParentId()){
                menuChildren.add(m);
            }
        }
        for(Menu c:menuChildren){
            c.setChildren(bilidChildren(c.getId(),menus));
        }
        return menuChildren;
    }

    @Override
    public int add(Menu menu) {
        return menuMapper.add(menu);
    }

    @Override
    public Menu queryById(Integer id) {
        return menuMapper.queryById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return menuMapper.deleteById(id);
    }

    @Override
    public int editMenu(Menu menu) {
        return menuMapper.editMenu(menu);
    }
}
