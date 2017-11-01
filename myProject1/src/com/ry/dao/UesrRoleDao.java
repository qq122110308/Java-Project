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
    
    //下面是自己写的，上面是mabatis-generator生成的
    
    List selectByCondition(User_Role record);  
    
    //查询用户所拥有的角色
    List selectUserRole(String userid);
    	
    
}
