package com.spring.layer.service;

import com.spring.layer.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    public List<UserRole> query(UserRole userRole);

    int count(UserRole userRole);

}
