package com.eliteams.quick4j.service.impl;

import javax.annotation.Resource;

import com.eliteams.quick4j.bean.User;
import com.eliteams.quick4j.dao.UserMapper;
import com.eliteams.quick4j.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Resource
	UserMapper userMapper;

	@Override
	public User findByName(String userName) {
		return userMapper.findByName(userName);
	}

}
