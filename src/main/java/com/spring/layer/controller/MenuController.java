package com.spring.layer.controller;

import com.spring.layer.entity.Menu;
import com.spring.layer.entity.Result;
import com.spring.layer.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public String menu(){
        return "page/menu";
    }


    @RequestMapping("/query")
    @ResponseBody
    public Result<List<Menu>> query(Menu menu){
        List<Menu> menus = menuService.queryMenuList(menu);
        Result<List<Menu>> menusResult = new Result<>(0, menus.size(), menus);
        return menusResult;
    }

    @RequestMapping("/add")
    @ResponseBody
    public Result addMenu(Menu menu){
        int line = menuService.add(menu);
        return Result.ok();
    }
}
