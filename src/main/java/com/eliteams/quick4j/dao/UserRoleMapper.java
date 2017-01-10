package com.eliteams.quick4j.dao;

import com.eliteams.quick4j.bean.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}