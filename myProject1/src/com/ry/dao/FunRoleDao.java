package com.ry.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ry.pojo.Fun_Role;

@Component("funRoleDao")
public interface FunRoleDao {
	int deleteByPrimaryKey(String funRoleId);

    int insert(Fun_Role record);

    int insertSelective(Fun_Role record);

    Fun_Role selectByPrimaryKey(String funRoleId);

    int updateByPrimaryKeySelective(Fun_Role record);

    int updateByPrimaryKey(Fun_Role record);
    
    //下面是自己写的
    
    //查询某个角色锁拥有的权限
    List selectFunRole(String roleId);
}
