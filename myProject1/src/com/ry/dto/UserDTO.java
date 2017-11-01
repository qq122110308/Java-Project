package com.ry.dto;

import java.util.Date;

import com.ry.pojo.User;

/**
 * 解释：为什么要用DTO， data transfer object  数据传输对象
 * 今天我在写用户添加功能的时候发现，通过ognl类型的方式 ，如果name包含不再user里面的字段，那么
 * use对象的数据就解析不出来， 具体请看源码！
 * UserDTO.java
 * @author ruanyang
 * 2017年10月30日
 */
public class UserDTO extends User{
	
    private String password2;
    
    private String roles;


	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
    
    
    
    
}
