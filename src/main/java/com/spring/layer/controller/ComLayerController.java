package com.spring.layer.controller;

import com.spring.layer.entity.Result;
import com.spring.layer.entity.User;
import com.spring.layer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ComLayerController {

    private static final Logger logger = LoggerFactory.getLogger(ComLayerController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/query")
    @ResponseBody
    public Result<List<User>> query(@RequestBody User user){
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
    @RequestMapping("/edit")
    @ResponseBody
    public Result edit(@RequestBody User user){
        int lines = userService.edit(user);
        return new Result(0,lines,user);
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Result deleteUser(@PathVariable Integer id){
        int lines = userService.deleteUserById(id);
        return new Result(0,lines,null);
    }
}
