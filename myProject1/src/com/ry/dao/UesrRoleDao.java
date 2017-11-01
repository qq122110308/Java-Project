package com.ry.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ry.pojo.User_Role;

@Component("userRoleDao")
public interface UesrRoleDao {
	
	List selectAllUserRole();		
	
	int deleteByPrimaryKey(String userRoleId);

    int insert(User_Role record);

    int insertSelective(User_Role record);

    User_Role selectByPrimaryKey(String userRoleId);

    int updateByPrimaryKeySelective(User_Role record);

    int updateByPrimaryKey(User_Role record);
    
    //�������Լ�д�ģ�������mabatis-generator���ɵ�
    
    List selectByCondition(User_Role record);  
    
    //��ѯ�û���ӵ�еĽ�ɫ
    List selectUserRole(String userid);
    	
    
}
