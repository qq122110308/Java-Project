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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ry.commons.PageInfo;
import com.ry.pojo.Fun;
import com.ry.service.FunService;
import com.ry.utils.BuildUUID;

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
		//funname=new String(funname.trim().getBytes("ISO-8859-1"),"utf-8");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String funid= BuildUUID.getUUID();
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
		//请扩大pageNum的数值
		PageInfo<Fun> funList=funService.selectAll(1,1000);
		session.setAttribute("funList", funList.getList());
		
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
	
	@RequestMapping(value = "/sTree",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String systemStree(HttpServletRequest request, HttpServletResponse response){
		List<Fun> list = funService.selectAlls();
		
		StringBuilder sb = new StringBuilder();
		
		//排序  不在数据库中处理,格式如： 只处理二级的
		/*{ id:1, pId:0, name:"父节点 1", open:true},
		{ id:11, pId:1, name:"叶子节点 1-1"},
		{ id:12, pId:1, name:"叶子节点 1-2"},
		{ id:13, pId:1, name:"叶子节点 1-3"},
		{ id:2, pId:0, name:"父节点 2", open:true},
		{ id:21, pId:2, name:"叶子节点 2-1"},
		{ id:22, pId:2, name:"叶子节点 2-2"},
		{ id:23, pId:2, name:"叶子节点 2-3"},
		{ id:3, pId:0, name:"父节点 3", open:true},
		{ id:31, pId:3, name:"叶子节点 3-1"},
		{ id:32, pId:3, name:"叶子节点 3-2"},
		{ id:33, pId:3, name:"叶子节点 3-3"}*/
		for (Fun fun : list) {
			if(fun.getFunfathernode().equals("0")){
				if(sb.toString().equals("")){
					sb.append("{ \"id\":\""+fun.getFunid()+"\", \"pId\":\""+fun.getFunfathernode()+"\", \"name\":\""+fun.getFunname()+"\"}");
				}
				else{
					sb.append(",{ \"id\":\""+fun.getFunid()+"\", \"pId\":\""+fun.getFunfathernode()+"\", \"name\":\""+fun.getFunname()+"\"}");
				}
				
				for (Fun funson : list) {
					if(funson.getFunfathernode().equals(fun.getFunid())){
						sb.append(",{ \"id\":\""+funson.getFunid()+"\", \"pId\":\""+funson.getFunfathernode()+"\", \"name\":\""+funson.getFunname()+"\"}");
					}
				}
			}
		}
		return "["+sb.toString()+"]";
	}
	
	//找到父节点
	public String findFather(List<Fun> list){
		StringBuilder sb = new StringBuilder();
		StringBuilder sbFather = new StringBuilder();
		for(int i = 0; i < list.size(); i++){
			Fun fun = list.get(i);
			if(fun.getFunfathernode().equals("0")){
				//说明是父节点
				String son = findSon(list,fun.getFunid());
				if(sb.toString().equals("")){
					sb.append("{name:\""+fun.getFunname()+"\" ,children:["+son+"]}");
				}
				else {
					sb.append(",{name:\""+fun.getFunname()+"\" ,children:["+son+"]}");
				}
			}
			
			
		}
		return "["+sb.toString()+"]";
	}
	
	//找到子节点
	public String findSon(List<Fun> list ,String funid ){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i < list.size() ;i++){
			Fun fun = list.get(i);
			if(fun.getFunfathernode().equals(funid)){
				if(sb.toString().equals("")){
					sb.append("{name:\""+fun.getFunname()+"\"}");
				}
				else{
					sb.append(",{name:\""+fun.getFunname()+"\"}");
				}
				
			}
		}
		
		return sb.toString();
	}
	
}
