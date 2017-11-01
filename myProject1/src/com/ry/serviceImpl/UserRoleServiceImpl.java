package com.ry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.service.UserRoleService;
import com.ry.dao.UesrRoleDao;
import com.ry.pojo.User_Role;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{
	
	@Autowired
	public UesrRoleDao userRole;
	
	
	
	@Override
	public List selectAllUserRole() {
		return userRole.selectAllUserRole();
	}



	@Override
	public int deleteByPrimaryKey(String userRoleId) {
		return userRole.deleteByPrimaryKey(userRoleId);
	}


	@Override
	public int insert(User_Role record) {
		return userRole.insert(record);
	}


	@Override
	public int insertSelective(User_Role record) {
		return userRole.insertSelective(record);
	}


	@Override
	public User_Role selectByPrimaryKey(String userRoleId) {
		return userRole.selectByPrimaryKey(userRoleId);
	}


	@Override
	public int updateByPrimaryKeySelective(User_Role record) {
		return userRole.updateByPrimaryKeySelective(record);
	}


	@Override
	public int updateByPrimaryKey(User_Role record) {
		return userRole.updateByPrimaryKey(record);
	}



	@Override
	public List selectByCondition(User_Role record) {
		return userRole.selectByCondition(record);
	}



	@Override
	public List selectUserRole(String userid) {
		return userRole.selectUserRole(userid);
	}
	
	
	
	
}
