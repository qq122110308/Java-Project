package com.ry.service;

import java.util.List;

import com.ry.commons.PageInfo;
import com.ry.pojo.Log;
import com.ry.pojo.User;

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
    
    List<Log> selectAll();
    
    Long selectCount();
    
    public PageInfo<Log> selectAll(int pageIndex, int pageNum);
    
}
 