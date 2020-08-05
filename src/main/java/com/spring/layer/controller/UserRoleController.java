package com.spring.layer.controller;

import com.spring.layer.entity.Result;
import com.spring.layer.entity.Role;
import com.spring.layer.entity.User;
import com.spring.layer.entity.UserRole;
import com.spring.layer.service.RoleService;
import com.spring.layer.service.UserRoleService;
import com.spring.layer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/role")
public class UserRoleController {

    private Logger logger = LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @RequestMapping
    public String userRole(Model model){
        List<Role> roles = roleService.queryRoleList(null);
        model.addAttribute("roles",roles);
        return "page/user_role";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result<List<UserRole>> query(UserRole userRole){
        List<UserRole> userRoles = userRoleService.query(userRole);
        int size = userRoleService.count(userRole);
        Result<List<UserRole>> userRoleResult = new Result<>(0, size, userRoles);
        return userRoleResult;
    }

    @RequestMapping("/create")
    @ResponseBody
    public Result create(UserRole userRole){
        //这里需要先查询一下用户是否存在
        User user = userService.findUserByName(userRole.getUsername());
        userRole.setUserId(user.getId());
        int lines = userRoleService.create(userRole);
        return Result.ok();
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Result edit(UserRole userRole){
        int lines = userRoleService.edit(userRole);
        return Result.ok();
    }
}
