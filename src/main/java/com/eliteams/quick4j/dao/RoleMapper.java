package com.eliteams.quick4j.dao;

import java.util.List;

import com.eliteams.quick4j.bean.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectByUserId(Long userId);
}