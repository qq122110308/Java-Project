package com.ry.serviceImpl;

import java.util.List;

import com.ry.service.UserRoleService;
import com.ry.dao.UesrRoleDao;

public class UserRoleServiceImpl implements UserRoleService{
	
	public UesrRoleDao userRole;
	
	
	@Override
	public List selectAllUserRole() {
		// TODO Auto-generated method stub
		return userRole.selectAllUserRole();
	}


	public UesrRoleDao getUserRole() {
		return userRole;
	}


	public void setUserRole(UesrRoleDao userRole) {
		this.userRole = userRole;
	}
	
	
	
	
}
