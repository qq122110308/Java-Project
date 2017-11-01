package com.ry.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dao.FunRoleDao;
import com.ry.pojo.Fun_Role;
import com.ry.service.FunRoleService;

@Service("funRoleService")
public class FunRoleServiceImpl implements FunRoleService{

	@Autowired
	FunRoleDao funRoleDao;
	
	@Override
	public int deleteByPrimaryKey(String funRoleId) {
		// TODO Auto-generated method stub
		return funRoleDao.deleteByPrimaryKey(funRoleId);
	}

	@Override
	public int insert(Fun_Role record) {
		// TODO Auto-generated method stub
		return funRoleDao.insert(record);
	}

	@Override
	public int insertSelective(Fun_Role record) {
		// TODO Auto-generated method stub
		return funRoleDao.insertSelective(record);
	}

	@Override
	public Fun_Role selectByPrimaryKey(String funRoleId) {
		// TODO Auto-generated method stub
		return funRoleDao.selectByPrimaryKey(funRoleId);
	}

	@Override
	public int updateByPrimaryKeySelective(Fun_Role record) {
		// TODO Auto-generated method stub
		return funRoleDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(Fun_Role record) {
		// TODO Auto-generated method stub
		return funRoleDao.updateByPrimaryKey(record);
	}

	@Override
	public List selectFunRole(String roleId) {
		return funRoleDao.selectFunRole(roleId);
	}
	
	
}
