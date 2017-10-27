package com.ry.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ry.commons.PageInfo;
import com.ry.dao.RoleDao;
import com.ry.pojo.Role;
import com.ry.pojo.User;
import com.ry.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
	
	@Resource
	public RoleDao roles;

	

	@Override
	public List selectAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<Role> selectAll(int pageIndex, int pageNum) {
		PageInfo pageInfo=new PageInfo();
		//根据条件获取总条数
		Long count=roles.selectCount();
		
		if(count!=null&&count>0){
			PageHelper.startPage(pageIndex, pageNum);
			List<Role> list=roles.selectAll();
			PageInfo<Role> page=new PageInfo<>(pageIndex, pageNum, count, list);
			
			return page;
		}
		else{
			return null;
		}
	}

	@Override
	public int deleteByPrimaryKey(String roleid) {

		return roles.deleteByPrimaryKey(roleid);
	}

	@Override
	public int insert(Role record) {

		return roles.insert(record);
	}

	@Override
	public int insertSelective(Role record) {

		return roles.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(String roleid) {

		return roles.selectByPrimaryKey(roleid);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {

		return roles.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {

		return roles.updateByPrimaryKey(record);
	}
	
	
	

	

	
	
	
	
	
}
