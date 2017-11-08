package com.ry.service;

import java.util.List;

import com.ry.commons.PageInfo;
import com.ry.pojo.Log;
import com.ry.pojo.User;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��6�� ����9:00:52 
* ��˵�� 
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
 