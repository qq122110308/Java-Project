package com.ry.pojo;

public class User_Role {
	private String user_Role_Id;
	private String userId;
	private String roleId;
	public String getUser_Role_Id() {
		return user_Role_Id;
	}
	public void setUser_Role_Id(String user_Role_Id) {
		this.user_Role_Id = user_Role_Id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public User_Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_Role(String user_Role_Id, String userId, String roleId) {
		super();
		this.user_Role_Id = user_Role_Id;
		this.userId = userId;
		this.roleId = roleId;
	}
	
	
}
