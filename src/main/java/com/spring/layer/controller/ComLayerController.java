package com.spring.layer.controller;

import com.spring.layer.entity.Menu;
import com.spring.layer.entity.User;
import com.spring.layer.entity.UserRole;
import com.spring.layer.service.MenuService;
import com.spring.layer.service.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ComLayerController {

    private static final Logger logger = LoggerFactory.getLogger(ComLayerController.class);

    @Autowired
    MenuService menuService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping("/index")
    public String index(Model model) {
        Subject subject = SecurityUtils.getSubject();
        //该user就是认证方法中返回的SimpleAuthenticationInfo对象的第一个参数principal
        User user = (User)subject.getPrincipal();
        //通过用户去获取对应的角色id
        List<UserRole> userRoles = userRoleService.queryUserRoleByUserId(user.getId());
        Set<Integer> roleIds = userRoles.stream().map(e -> e.getRoleId()).collect(Collectors.toSet());
        List<Menu> menus = menuService.queryMenuTree(new Menu(roleIds));
        model.addAttribute("menus",menus);
        return "index";
    }
}
