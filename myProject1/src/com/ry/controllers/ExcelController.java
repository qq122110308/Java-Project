package com.ry.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.annotation.SystemControllerLog;
import com.ry.commons.PageInfo;
import com.ry.pojo.User;
import com.ry.service.UserService;

@Controller
@RequestMapping("excel")
public class ExcelController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request, Integer pageIndex ){
		//��ѯ�û��б�
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<User> pageInfos = userService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "excel/excelIndex";
	}
	
	
	@RequestMapping("toExcel")
	@SystemControllerLog(description = "����Excel�ļ�")
	@ResponseBody
	public  String toExcel(HttpServletResponse response){
		response.setContentType("application/binary;charset=UTF-8");
		
		try {
			ServletOutputStream out=response.getOutputStream();
			String fileName=new String(("UserInfo "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(),"UTF-8");
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
			String[] titles = { "�û�ID", "�û�����", "�û�����", "�û�����","��ϵ�绰","����ʱ��" }; 
			
//			response.reset();
//		    response.setContentType("application/vnd.ms-excel;charset=utf-8");
//		    response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes(), "iso-8859-1"));
//			
			
			userService.export(titles, out);
			return null;
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "������Ϣʧ��";
		}
		
	}
}
