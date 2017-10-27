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
		//跳转系统功能页面
		 List<Fun> list =(ArrayList<Fun>)session.getAttribute("funList");
		 //System.out.println(list.size());
		 
		 logger.debug("进入系统首页");
		 
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
		//跳转到系统功能添加页面
		
		return "system/systemAdd";
	}
	@RequestMapping("add")
	public String add(String funname,String funurl,String funicon,String funfathernode,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
		
		//解决中文乱码问题  除了这种还有没有别的方式 进行转码  我记得 web.xml那里已经处理过了
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

		//由于添加了数据 这里要重新处理左侧菜单栏
		PageInfo<Fun> funList=funService.selectAll(1,10);
		session.setAttribute("funList", funList);
		
		return "redirect:index";
	}
	
	@RequestMapping("goupdate")
	public String goUpdate(String funid,HttpServletRequest request){
		//跳转到修改页面
		Fun fun=funService.selectByPrimaryKey(funid);
		System.out.println(fun.getFunurl());
		request.setAttribute("fun", fun);
		return "system/systemUpdate";
	}
	
	@RequestMapping("update")
	public String update(Fun fun,HttpServletRequest request) throws UnsupportedEncodingException{
		//修改数据
		System.out.println("功能修改的id为："+fun.getFunid());
		request.setCharacterEncoding("utf-8");
		funService.updateByPrimaryKey(fun);
		return "redirect:index";
	}
	
	
}
