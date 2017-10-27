package com.ry.controllers;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ry.commons.PageInfo;
import com.ry.pojo.Fun;
import com.ry.pojo.Fun_Role;
import com.ry.pojo.Role;
import com.ry.service.FunRoleService;
import com.ry.service.FunService;
import com.ry.service.RoleService;

/**
 * RoleController.java
 * @author ruanyang
 * 2017年10月26日
 * 控制器 实现角色管理的相关功能
 */

@Controller
@RequestMapping("role")
public class RoleController {
	public static Logger logger = Logger.getLogger(RoleController.class);
	
	String uuid=UUID.randomUUID().toString().replace("-", "");
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FunService funService;
	
	@Autowired
	private FunRoleService funRoleService;
	
	
	@RequestMapping("roleIndex")
	public String roleIndex(HttpServletRequest request, Integer pageIndex){
		//查询角色列表
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<Role> pageInfos = roleService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "role/roleIndex";
	}
	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request){
		//列出可以赋予的权限
		List<Fun> funList = funService.selectAlls();
		request.setAttribute("funList", funList);
		
		return "role/roleAdd";
	}
	
	
	@RequestMapping("add")
	public String add(HttpServletRequest request){
		
		//System.out.println("所赋予的权限："+request.getParameter("funids"));
		String roleName =request.getParameter("rolename");
		try {
			roleName=new String(roleName.trim().getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String funids = request.getParameter("funids");
		
		Role role = new Role();
		role.setRoleid(uuid);
		role.setRolecreate(new Date());
		role.setRolename(roleName);
		role.setRolestate(1);
		
		roleService.insert(role);
		//整理角色功能表
		
		String[] funid = funids.split(",");
		for(int i=0;i<funid.length;i++){
			String uuids=UUID.randomUUID().toString().replace("-", "");
			Fun_Role funRole = new Fun_Role();
			funRole.setFunRoleId(uuids);
			funRole.setFuncreate(new Date());
			funRole.setFunid(funid[i]);
			funRole.setRoleid(uuid);
			funRoleService.insert(funRole);
		}
		
		
		return "redirect:roleIndex";
	}
	
}
