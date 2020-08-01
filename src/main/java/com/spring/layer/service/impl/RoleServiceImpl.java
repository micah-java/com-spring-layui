package com.spring.layer.service.impl;

import com.spring.layer.entity.Role;
import com.spring.layer.mapper.RoleMapper;
import com.spring.layer.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRoleList(Role role) {
        return roleMapper.quertRoleList(role);
    }

    @Override
    public int add(Role role) {
        return 0;
    }

    @Override
    public Role queryById(Integer id) {
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int editRole(Role role) {
        return 0;
    }
}
