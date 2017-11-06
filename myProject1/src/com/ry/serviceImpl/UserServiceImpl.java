package com.ry.serviceImpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ry.annotation.SystemServiceLog;
import com.ry.commons.PageInfo;
import com.ry.dao.UserDao;
import com.ry.pojo.Fun;
import com.ry.pojo.User;
import com.ry.service.UserService;


/**
 * UserServiceImpl.java
 * @author ruanyang
 * 2017��10��26��
 */

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	public UserDao userDao;
	
	
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	@Override
	public List selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public User selectByUserAccount(String userAccount) {
		// TODO Auto-generated method stub
		return userDao.selectByUserAccount(userAccount);
	}

	@Override
	@SystemServiceLog(description = "��ѯ�û�")
	public PageInfo<User> selectAll(int pageIndex, int pageNum) {
		PageInfo pageInfo=new PageInfo();
		//����������ȡ������
		Long count=userDao.selectCount();
		
		if(count!=null&&count>0){
			PageHelper.startPage(pageIndex, pageNum);
			List<User> list=userDao.selectAll();
			PageInfo<User> page=new PageInfo<>(pageIndex, pageNum, count, list);
			
			return page;
		}
		else{
			return null;
		}
	}

	@Override
	public void export(String[] titles, ServletOutputStream out) {
		
		// ��һ��������һ��workbook����Ӧһ��Excel�ļ�
		HSSFWorkbook workbook = new HSSFWorkbook();
		// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
		HSSFSheet hssfSheet = workbook.createSheet("sheet1");
		// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short
		HSSFRow hssfRow = hssfSheet.createRow(0);
		// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
		HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
		
		HSSFCell hssfCell = null;
		for (int i = 0; i < titles.length; i++) {
			hssfCell = hssfRow.createCell(i);//��������0��ʼ
			hssfCell.setCellValue(titles[i]);//����1
			hssfCell.setCellStyle(hssfCellStyle);//�о�����ʾ
		}
		
		// ���岽��д��ʵ������ 
		List<User> users =userDao.selectAll();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(users != null && !users.isEmpty()){
			for (int i = 0; i < users.size(); i++) {
				hssfRow = hssfSheet.createRow(i+1);
				User user = users.get(i);
				
				// ��������������Ԫ�񣬲�����ֵ
				if(user.getUserid() != null){
					hssfRow.createCell(0).setCellValue(user.getUserid());
				}
				if(user.getUsername() != null){
					hssfRow.createCell(1).setCellValue(user.getUsername());
				}
				if(user.getPassword() != null){
					hssfRow.createCell(2).setCellValue(user.getPassword());
				}
				if(user.getUseraccount() != null){
					hssfRow.createCell(3).setCellValue(user.getUseraccount());
				}
				if(user.getUsercontact() != null){
					hssfRow.createCell(4).setCellValue(user.getUsercontact());
				}
				if(user.getUsercreate() != null){
					HSSFCell cell = hssfRow.createCell(5);
					cell.setCellValue(user.getUsercreate());
					//�ж��Ƿ�Ϊ��������
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						Date d = cell.getDateCellValue();
						DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						cell.setCellValue(formater.format(d));
					}
					
				}
				
			}
			
		}
		// ���߲������ļ�������ͻ��������
		
		try {
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
	
	
	}

	@Override
	public User selectByPrimaryKey(String userid) {
		return userDao.selectByPrimaryKey(userid);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String userid) {
		return userDao.deleteByPrimaryKey(userid);
	}
}
