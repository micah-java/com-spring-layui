package com.spring.layer.controller;

import com.spring.layer.entity.Result;
import com.spring.layer.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Result<String> login(User user) throws IOException {
        //1、获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        //3、执行登录方法，没有异常代表登录成功，否则登录失败
        try{
            subject.login(token);
        }catch (UnknownAccountException e){
            logger.error("用户名{}不存在:{}",user.getName(),e.getMessage(),e);
            return new Result(0,0, "http://localhost:8081/tologin");//返回登录页面
        }catch (IncorrectCredentialsException e){
            logger.error("密码{}错误:{}",user.getPassword(),e.getMessage(),e);
            return new Result(0,0, "http://localhost:8081/tologin");//返回登录页面
        }
        return new Result(0,0, "http://localhost:8081/index");//返回登录页面
    }
}
