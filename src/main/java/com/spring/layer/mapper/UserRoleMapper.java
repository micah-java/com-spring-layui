package com.spring.layer.mapper;

import com.spring.layer.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<UserRole> query(UserRole userRole);

    int count(UserRole userRole);

    int create(UserRole userRole);

    int edit(UserRole userRole);

    public List<UserRole> queryUserRoleByUserId(@Param("userId") Integer userId);

}
