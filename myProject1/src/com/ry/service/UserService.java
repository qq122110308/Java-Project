package com.ry.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import com.ry.commons.PageInfo;
import com.ry.pojo.User;

public interface UserService {
	public int insertUser(User user);
	
	public List selectAllUser();
	
	public User selectByUserAccount(String userAccount);
	
	public PageInfo<User> selectAll(int pageIndex,int pageNum);
	
	//µ¼³öexcel
	public void export(String[] titles, ServletOutputStream out);
	
}
