package com.ry.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ry.commons.PageInfo;
import com.ry.dao.FunDao;
import com.ry.pojo.Fun;
import com.ry.service.FunService;

@Service("funService")
public class FunServiceImpl implements FunService{
	
	@Resource
	FunDao funDao;
	
	@Override
	public int deleteByPrimaryKey(String funid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Fun record) {
		// TODO Auto-generated method stub
		return funDao.insert(record);
	}

	@Override
	public int insertSelective(Fun record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fun selectByPrimaryKey(String funid) {
		// TODO Auto-generated method stub
		return funDao.selectByPrimaryKey(funid);
	}

	@Override
	public int updateByPrimaryKeySelective(Fun record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Fun record) {
		// TODO Auto-generated method stub
		return funDao.updateByPrimaryKey(record);
	}

	@Override
	public PageInfo<Fun> selectAll(int pageNum,int pageSize) {
		PageInfo pageInfo=new PageInfo();
		//根据条件获取总条数
		Long count=funDao.selectCount();
		
		if(count!=null&&count>0){
			PageHelper.startPage(pageNum, pageSize);
			List<Fun> list=funDao.selectAll();
			PageInfo<Fun> page=new PageInfo<>(pageNum, pageSize, count, list);
			
			return page;
		}
		else{
			return null;
		}
		
		
	}

	@Override
	public long selectCount() {
		
		return funDao.selectCount();
	}

	@Override
	public List<Fun> selectAlls() {
		// TODO Auto-generated method stub
		
		return funDao.selectAll();
	}

	@Override
	public List<Fun> selectByUser(String userid) {
		return funDao.selectByUser(userid);
	}

	
	
	

	
	
	
	
	
}
