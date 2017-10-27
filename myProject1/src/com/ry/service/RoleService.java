package com.ry.service;

import java.util.List;

import com.ry.commons.PageInfo;
import com.ry.pojo.Role;
import com.ry.pojo.User;

public interface RoleService {
	int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
	
	public List selectAllRole();
	
	public PageInfo<Role> selectAll(int pageIndex,int pageNum);
}
