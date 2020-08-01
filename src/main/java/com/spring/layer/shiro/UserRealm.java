package com.spring.layer.shiro;

import com.spring.layer.entity.User;
import com.spring.layer.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        Subject subject = SecurityUtils.getSubject();
        //该user就是认证方法中返回的SimpleAuthenticationInfo对象的第一个参数principal
        User user = (User)subject.getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> authSet = new HashSet<>();
        authSet.add("dept:edit");
        authSet.add("dept:delete1");
        simpleAuthorizationInfo.setStringPermissions(authSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        User user = new User("admin");
        user = userService.queryUser(user);
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //1、验证用户名
        if(Objects.isNull(user)){
            //用户名不存在
            return null;//shiro会抛出UnknownAccountException异常
        }
        //2、判断密码，将密码通过子类返回，shiro会自己判断
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
