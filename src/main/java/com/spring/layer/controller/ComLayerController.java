package com.spring.layer.controller;

import com.spring.layer.entity.Menu;
import com.spring.layer.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComLayerController {

    private static final Logger logger = LoggerFactory.getLogger(ComLayerController.class);

    @Autowired
    MenuService menuService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<Menu> menus = menuService.queryMenuList(null);
        model.addAttribute("menus",menus);
        return "index";
    }
}
