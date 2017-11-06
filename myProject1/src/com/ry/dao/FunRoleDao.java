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
    
    //�������Լ�д��
    
    //��ѯĳ����ɫ��ӵ�е�Ȩ��
    List selectFunRole(String roleId);
}
