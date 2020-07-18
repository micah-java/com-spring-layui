package com.spring.layer.realm;

import com.spring.layer.entity.ActiveUser;
import com.spring.layer.entity.User;
import com.spring.layer.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Wrapper;
import java.util.Objects;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        User user = new User();
        user.setName(authenticationToken.getPrincipal().toString());
        User u = userService.queryUser(user);
        if(Objects.nonNull(u)){
            ActiveUser activeUser = new ActiveUser();
            activeUser.setUser(u);
            SimpleAuthenticationInfo saf = new SimpleAuthenticationInfo(activeUser,u.getPassword(),this.getName());
            return saf;
        }
        return null;
    }
}
