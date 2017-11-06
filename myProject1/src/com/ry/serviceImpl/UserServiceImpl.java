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
 * 2017年10月26日
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
	@SystemServiceLog(description = "查询用户")
	public PageInfo<User> selectAll(int pageIndex, int pageNum) {
		PageInfo pageInfo=new PageInfo();
		//根据条件获取总条数
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
		
		// 第一步，创建一个workbook，对应一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet hssfSheet = workbook.createSheet("sheet1");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow hssfRow = hssfSheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
		
		HSSFCell hssfCell = null;
		for (int i = 0; i < titles.length; i++) {
			hssfCell = hssfRow.createCell(i);//列索引从0开始
			hssfCell.setCellValue(titles[i]);//列名1
			hssfCell.setCellStyle(hssfCellStyle);//列居中显示
		}
		
		// 第五步，写入实体数据 
		List<User> users =userDao.selectAll();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(users != null && !users.isEmpty()){
			for (int i = 0; i < users.size(); i++) {
				hssfRow = hssfSheet.createRow(i+1);
				User user = users.get(i);
				
				// 第六步，创建单元格，并设置值
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
					//判断是否为日期类型
					if(HSSFDateUtil.isCellDateFormatted(cell)){
						Date d = cell.getDateCellValue();
						DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						cell.setCellValue(formater.format(d));
					}
					
				}
				
			}
			
		}
		// 第七步，将文件输出到客户端浏览器
		
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
