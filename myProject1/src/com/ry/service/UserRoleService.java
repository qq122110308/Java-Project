package com.ry.service;

import java.util.List;

import com.ry.pojo.User_Role;

public interface UserRoleService {
	public List selectAllUserRole();
	
	int deleteByPrimaryKey(String userRoleId);

    int insert(User_Role record);

    int insertSelective(User_Role record);

    User_Role selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(User_Role record);

    int updateByPrimaryKey(User_Role record);
    
    //�������Լ�д�ģ�������mabatis-generator���ɵ�
    
    List selectByCondition(User_Role record);  
	
    //��ѯĳ���û���ӵ�е�Ȩ��	
    List selectUserRole(String userid);
}
