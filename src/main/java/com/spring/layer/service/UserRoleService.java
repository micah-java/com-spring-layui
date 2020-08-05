package com.spring.layer.service;

import com.spring.layer.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    public List<UserRole> query(UserRole userRole);

    public List<UserRole> queryUserRoleByUserId(Integer userId);

    int count(UserRole userRole);

    int create(UserRole userRole);

    int edit(UserRole userRole);
}
