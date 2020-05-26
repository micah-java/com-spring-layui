package com.spring.layer.controller;

import com.spring.layer.entity.Result;
import com.spring.layer.entity.User;
import com.spring.layer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/layer")
public class ComLayerController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result<List<User>> query(User user){
        List<User> users = userService.query(user);
        int size = userService.count(user);
        Result<List<User>> userResult = new Result<>(0, size, users);
        return userResult;
    }

    @RequestMapping("/create")
    @ResponseBody
    public Result saveUser(@RequestBody User user){
        int lines = userService.create(user);
        return new Result(0,lines,null);
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Map deleteUser(@PathVariable Integer id){
        int i = 1 / 0;
        Map map = new HashMap();
        int lines = userService.deleteUserById(id);
        map.put("lines",lines);
        return map;
    }
}
