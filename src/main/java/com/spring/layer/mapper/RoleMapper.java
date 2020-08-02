package com.spring.layer.mapper;

import com.spring.layer.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> quertRoleList(Role role);

    int add(Role role);

    Role queryById(@Param("id") Integer id);

    int editRole(Role role);

    int deleteById(@Param("id") Integer id);
}
