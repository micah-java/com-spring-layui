package com.spring.layer.service.impl;

import com.spring.layer.entity.User;
import com.spring.layer.entity.UserRole;
import com.spring.layer.mapper.UserMapper;
import com.spring.layer.mapper.UserRoleMapper;
import com.spring.layer.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private static Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> query(UserRole userRole) {
        if(userRole != null){
            int start = (userRole.getPage() - 1) * userRole.getLimit();
            userRole.setStart(start);
        }
        return userRoleMapper.query(userRole);
    }

    @Override
    public int count(UserRole userRole) {
        return userRoleMapper.count(userRole);
    }
}
