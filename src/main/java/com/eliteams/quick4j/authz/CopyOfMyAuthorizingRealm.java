package com.eliteams.quick4j.authz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.eliteams.quick4j.bean.Permission;
import com.eliteams.quick4j.bean.Role;
import com.eliteams.quick4j.bean.User;
import com.eliteams.quick4j.dao.PermissionMapper;
import com.eliteams.quick4j.dao.RoleMapper;
import com.eliteams.quick4j.service.UserService;

public class CopyOfMyAuthorizingRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private PermissionMapper permissionMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		//获取登录时输入的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();  
        //到数据库查是否有此对象  
        User user=userService.findByName(loginName);  
        if(user!=null){  
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
            //用户的角色
            List<Role> roleList = roleMapper.selectByUserId(user.getUserId());
            for (Role role : roleList) {
            	info.addRole(role.getRoleName());
			}
            //用户的角色对应的所有权限
            List<Permission> permissionList = permissionMapper.selectByUserId(user.getUserId());
            for (Permission permission : permissionList) {  
                info.addStringPermission(permission.getPermissionName());  
            }  
            return info;  
        }  
        return null;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = userService.findByName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getUserName(),
					user.getPassword(), getName());
		}
		return null;
	}

}
