package com.spring.layer.service;

import com.spring.layer.entity.Role;

import java.util.List;

public interface RoleService {

    public List<Role> queryRoleList(Role role);

    int add(Role role);

    Role queryById(Integer id);

    int deleteById(Integer id);

    int editRole(Role role);
}
