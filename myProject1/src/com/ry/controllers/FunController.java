package com.ry.controllers;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.commons.PageInfo;
import com.ry.pojo.Fun;
import com.ry.service.FunService;

@Controller
@RequestMapping("system")
public class FunController implements Serializable {
	
	public static Logger logger = Logger.getLogger(FunController.class);
	
	@Resource(name="funService")
	FunService funService;
	
	@RequestMapping("index")
	public String  index(Integer pageIndex,HttpSession session,HttpServletRequest request){
		//��תϵͳ����ҳ��
		 List<Fun> list =(ArrayList<Fun>)session.getAttribute("funList");
		 //System.out.println(list.size());
		 
		 logger.debug("����ϵͳ��ҳ");
		 
		 if(pageIndex==null){
			 pageIndex=1;
		 }
		 PageInfo<Fun> pageInfos=funService.selectAll(pageIndex, 10); 
		 
		 request.setAttribute("pageInfo", pageInfos);
		//return funService.selectAll(1, 10);
		 return "system/systemIndex";
	}
	
	@RequestMapping("goadd")
	public String goAdd(){
		//��ת��ϵͳ�������ҳ��
		
		return "system/systemAdd";
	}
	@RequestMapping("add")
	public String add(String funname,String funurl,String funicon,String funfathernode,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		
		//���������������  �������ֻ���û�б�ķ�ʽ ����ת��  �Ҽǵ� web.xml�����Ѿ��������
		funname=new String(funname.trim().getBytes("ISO-8859-1"),"utf-8");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String funid= UUID.randomUUID().toString().replace("-", "");
		System.out.println(funname);
		Fun fun=new Fun();
		fun.setFunid(funid);
		fun.setFuncreate(new Date());
		fun.setFunname(funname);
		fun.setFunurl(funurl);
		fun.setFunicon(funicon);
		fun.setFunfathernode(funfathernode);
		funService.insert(fun);

		//������������� ����Ҫ���´������˵���
		PageInfo<Fun> funList=funService.selectAll(1,10);
		session.setAttribute("funList", funList);
		
		return "redirect:index";
	}
	
	@RequestMapping("goupdate")
	public String goUpdate(String funid,HttpServletRequest request){
		//��ת���޸�ҳ��
		Fun fun=funService.selectByPrimaryKey(funid);
		System.out.println(fun.getFunurl());
		request.setAttribute("fun", fun);
		return "system/systemUpdate";
	}
	
	@RequestMapping("update")
	public String update(Fun fun,HttpServletRequest request) throws UnsupportedEncodingException{
		//�޸�����
		System.out.println("�����޸ĵ�idΪ��"+fun.getFunid());
		request.setCharacterEncoding("utf-8");
		funService.updateByPrimaryKey(fun);
		return "redirect:index";
	}
	
	
}
