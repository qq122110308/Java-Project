package com.ry.service;

import com.ry.pojo.Log;

/** 
* @author ry 
* @version 创建时间：2017年11月6日 上午9:00:52 
* 类说明 
*/

public interface LogService {
	int deleteByPrimaryKey(String logid);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String logid);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}
 