package com.eliteams.quick4j.dao;

import com.eliteams.quick4j.bean.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}