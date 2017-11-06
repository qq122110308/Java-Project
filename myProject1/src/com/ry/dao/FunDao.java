package com.ry.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ry.pojo.Fun;

@Component("funDao")
public interface FunDao {
    int deleteByPrimaryKey(String funid);

    int insert(Fun record);

    int insertSelective(Fun record);

    Fun selectByPrimaryKey(String funid);

    int updateByPrimaryKeySelective(Fun record);

    int updateByPrimaryKey(Fun record);
    
    List<Fun> selectAll();
    
    //下面都是自己写的
    
    Long selectCount();
    
    List<Fun> selectByUser(String userid); 
    
    
    
}