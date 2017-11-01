package com.ry.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import com.ry.commons.PageInfo;
import com.ry.pojo.User;

public interface UserService {
	int deleteByPrimaryKey(String userid);
	
	public int insertUser(User user);
	
	User selectByPrimaryKey(String userid);
	
	public List selectAllUser();
	
	public User selectByUserAccount(String userAccount);
	
	int updateByPrimaryKey(User record);
	
	int updateByPrimaryKeySelective(User record);
	
	public PageInfo<User> selectAll(int pageIndex,int pageNum);
	
	//µ¼³öexcel
	public void export(String[] titles, ServletOutputStream out);
	
}
