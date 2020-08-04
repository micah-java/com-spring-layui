package com.spring.layer.mapper;

import com.spring.layer.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<UserRole> query(UserRole userRole);

    int count(UserRole userRole);
}
