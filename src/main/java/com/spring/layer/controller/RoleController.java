package com.spring.layer.controller;

import com.spring.layer.entity.*;
import com.spring.layer.service.MenuService;
import com.spring.layer.service.RoleMenuService;
import com.spring.layer.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;
    @Autowired
    RoleMenuService roleMenuService;

    @RequestMapping
    public String role(){
        return "page/role";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result<List<Role>> query(Role role){
        List<Role> roles = roleService.queryRoleList(role);
        Result<List<Role>> userResult = new Result<>(0, roles.size(), roles);
        return userResult;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result saveRole(@RequestBody Role role){
        int lines = roleService.add(role);
        return new Result(0,lines,null);
    }
    @RequestMapping("/edit")
    @ResponseBody
    public Result edit(@RequestBody Role role){
        int lines = roleService.editRole(role);
        return new Result(0,lines,role);
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Result deleteRole(@PathVariable Integer id){
        int lines = roleService.deleteById(id);
        return new Result(0,lines,null);
    }

    @RequestMapping("/menuTree/{roleId}")
    @ResponseBody
    public Result<List<Menu>> menuTree(@PathVariable("roleId") Integer roleId){
        List<Menu> menus = roleMenuService.queryRoleMenuTree(new RoleMenu(roleId));
        Result<List<Menu>> menuResult = new Result<>(0, menus.size(), menus);
        return menuResult;
    }

    @RequestMapping("/add/roleMenu")
    @ResponseBody
    public Result addRoleMenu(RoleMenu roleMenu){
        Integer lines = roleMenuService.addRoleMenu(roleMenu);
        return Result.ok();
    }
}
