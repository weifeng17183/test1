package com.eliteams.quick4j.dao;

import java.util.List;

import com.eliteams.quick4j.bean.Permission;

public interface PermissionMapper {
	int deleteByPrimaryKey(Long permissionId);

	int insert(Permission record);

	int insertSelective(Permission record);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
	
    List<Permission> selectByUserId(Long userId);
}