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
    
    //下面是自己写的，上面是mabatis-generator生成的
    
    List selectByCondition(User_Role record);  
	
    //查询某个用户所拥有的权限	
    List selectUserRole(String userid);
}
