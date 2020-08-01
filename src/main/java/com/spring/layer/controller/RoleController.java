package com.spring.layer.controller;

import com.spring.layer.entity.Result;
import com.spring.layer.entity.Role;
import com.spring.layer.entity.User;
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
}
