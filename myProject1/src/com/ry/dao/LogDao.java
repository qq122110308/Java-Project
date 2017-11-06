package com.ry.dao;

import org.springframework.stereotype.Component;

import com.ry.pojo.Log;

@Component("logDao")
public interface LogDao {
    int deleteByPrimaryKey(String logid);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String logid);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}