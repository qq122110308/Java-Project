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
    
	//�������Լ�д�� ��������baseDao����д ����̳�
	
    Long selectCount();
    
    //��������ѯ������Ķ�����Ҫ�Լ�д
    List selectByConditions(List cList);
    
}