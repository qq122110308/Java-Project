package com.ry.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ry.pojo.Role;

@Component("roleDao")
public interface RoleDao {
    int deleteByPrimaryKey(String roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
	List<Role> selectAll();
    
	//下面是自己写的 ，可以在baseDao里面写 这里继承
	
    Long selectCount();
    
    //多条件查询，这里的多条件要自己写
    List selectByConditions(List cList);
    
}