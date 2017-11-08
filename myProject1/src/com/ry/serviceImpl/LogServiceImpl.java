package com.ry.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ry.annotation.SystemServiceLog;
import com.ry.commons.PageInfo;
import com.ry.dao.LogDao;
import com.ry.pojo.Log;
import com.ry.pojo.User;
import com.ry.service.LogService;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��6�� ����9:51:26 
* ��˵�� 
*/
@Service
public class LogServiceImpl implements LogService{
	
	@Resource
	private LogDao logDao;

	@Override
	public int deleteByPrimaryKey(String logid) {
		return logDao.deleteByPrimaryKey(logid);
	}

	@Override
	public int insert(Log record) {
		return logDao.insert(record);
	}

	@Override
	public int insertSelective(Log record) {
		return logDao.insertSelective(record);
	}

	@Override
	public Log selectByPrimaryKey(String logid) {
		return logDao.selectByPrimaryKey(logid);
	}

	@Override
	public int updateByPrimaryKeySelective(Log record) {
		return logDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Log record) {
		return logDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Log> selectAll() {
		return logDao.selectAll();
	}

	@Override
	public Long selectCount() {
		return logDao.selectCount();
	}
	
	@SystemServiceLog(description = "��ѯ�û�")
	public PageInfo<Log> selectAll(int pageIndex, int pageNum) {
		PageInfo pageInfo=new PageInfo();
		//����������ȡ������
		Long count=logDao.selectCount();
		
		if(count!=null&&count>0){
			PageHelper.startPage(pageIndex, pageNum);
			List<Log> list=logDao.selectAll();
			PageInfo<Log> page=new PageInfo<>(pageIndex, pageNum, count, list);
			
			return page;
		}
		else{
			return null;
		}
	}
	
	
	
	
	
}
 