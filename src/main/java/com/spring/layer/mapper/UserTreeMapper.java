package com.spring.layer.mapper;

import com.spring.layer.entity.UserTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserTreeMapper {

    List<UserTree> queryTree();

    int addTree(UserTree userTree);

    int delTree(@Param("id") Integer id);
}
