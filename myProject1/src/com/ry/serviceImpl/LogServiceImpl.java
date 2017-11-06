package com.ry.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ry.dao.LogDao;
import com.ry.pojo.Log;
import com.ry.service.LogService;

/** 
* @author ry 
* @version 创建时间：2017年11月6日 上午9:51:26 
* 类说明 
*/
@Service
public class LogServiceImpl implements LogService{
	
	@Resource
	private LogDao logDao;

	@Override
	public int deleteByPrimaryKey(String logid) {
		// TODO Auto-generated method stub
		return logDao.deleteByPrimaryKey(logid);
	}

	@Override
	public int insert(Log record) {
		// TODO Auto-generated method stub
		return logDao.insert(record);
	}

	@Override
	public int insertSelective(Log record) {
		// TODO Auto-generated method stub
		return logDao.insertSelective(record);
	}

	@Override
	public Log selectByPrimaryKey(String logid) {
		// TODO Auto-generated method stub
		return logDao.selectByPrimaryKey(logid);
	}

	@Override
	public int updateByPrimaryKeySelective(Log record) {
		// TODO Auto-generated method stub
		return logDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Log record) {
		// TODO Auto-generated method stub
		return logDao.updateByPrimaryKey(record);
	}
	
	
	
	
	
}
 