package com.ry.service;

import java.util.List;

import com.ry.commons.PageInfo;
import com.ry.pojo.Fun;

public interface FunService {
	int deleteByPrimaryKey(String funid);

    int insert(Fun record);

    int insertSelective(Fun record);

    Fun selectByPrimaryKey(String funid);

    int updateByPrimaryKeySelective(Fun record);

    int updateByPrimaryKey(Fun record);
    
    PageInfo<Fun> selectAll(int pageNum,int pageSize);
    
    List<Fun> selectAlls();
    
    long selectCount();

    //查询用户所拥有的权限
    List<Fun> selectByUser(String userid); 
    
    

    
}
