package com.spring.layer.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 需要创建三个Bean
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        /*
         * shiro的内置过滤器，可以实现权限相关拦截
         * anon: 无需登录也可以访问
         * authc: 必须认证才可以访问
         * user: 如果使用了rememberMe的功能可以直接访问
         * perms: 必须有资源权限才可以访问
         * roles: 必须有角色权限才可以访问
         */
        //保持顺序，用LinkedHashMap
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/dept/add","authc");
        filterMap.put("/dept/edit","authc");
        filterMap.put("/dept/edit","perms[dept:edit]");

        //修改跳转的默认登录页面
        shiroFilterFactoryBean.setLoginUrl("/page/login-1.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    /**
     * 用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
