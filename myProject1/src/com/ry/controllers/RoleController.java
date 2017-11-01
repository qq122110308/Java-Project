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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ry.commons.PageInfo;
import com.ry.dto.RoleDTO;
import com.ry.pojo.Fun;
import com.ry.pojo.Fun_Role;
import com.ry.pojo.Role;
import com.ry.service.FunRoleService;
import com.ry.service.FunService;
import com.ry.service.RoleService;
import com.ry.utils.BuildUUID;

/**
 * RoleController.java
 * @author ruanyang
 * 2017年10月26日
 * 控制器 实现角色管理的相关功能
 */

@Controller
@RequestMapping("/role")
public class RoleController {
	public static Logger logger = Logger.getLogger(RoleController.class);
	
	String uuid=UUID.randomUUID().toString().replace("-", "");
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FunService funService;
	
	@Autowired
	private FunRoleService funRoleService;
	
	
	@RequestMapping("/roleIndex")
	public String roleIndex(HttpServletRequest request, Integer pageIndex){
		//查询角色列表
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<Role> pageInfos = roleService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "role/roleIndex";
	}
	
	@RequestMapping("/goadd")
	public String goadd(HttpServletRequest request){
		//列出可以赋予的权限
		List<Fun> funList = funService.selectAlls();
		request.setAttribute("funList", funList);
		
		return "role/roleAdd";
	}
	
	
	@RequestMapping("/addRole")
	@Transactional
	public String add(HttpServletRequest request){
		
		//System.out.println("所赋予的权限："+request.getParameter("funids"));
		String roleName =request.getParameter("rolename");
//		try {
//			roleName=new String(roleName.trim().getBytes("ISO-8859-1"),"utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
		
		request.setAttribute("title", "添加操作");
		request.setAttribute("message", "操作成功！");
		
		return "redirect:roleIndex";
	}
	
	/**
	 * 跳转到修改界面
	 * @param roleid
	 * @param request
	 * @return
	 */
	@RequestMapping("/goupdate")
	public String goupdate(String roleid,HttpServletRequest request){
		
		Role role = roleService.selectByPrimaryKey(roleid);
		//查询出角色拥有的权限以及权限表信息
		List<Fun> funList = funService.selectAlls();
		//上面这个用不上 存了session
		
		//角色锁拥有的权限
		List<Fun_Role> funRoleList = funRoleService.selectFunRole(roleid);
		
		//这里 不用ModelAndView  我是按照视频上学来的，用在其他项目的时候我在处理 比如图书管理系统
		request.setAttribute("role", role);
		request.setAttribute("funRoleList", funRoleList);
		
		return "role/roleUpdate";
	}
	
	
	/**
	 * 修改角色
	 * @param roleDTO
	 * @return
	 */
	@RequestMapping("updateRole")
	@Transactional
	public String updateRole(RoleDTO roleDTO)
	{
		roleService.updateByPrimaryKeySelective(roleDTO);
		
		//这里要改变角色权限表
		//刷选出要添加的功能，删除未添加的功能
		List<Fun_Role> funRoleList =  funRoleService.selectFunRole(roleDTO.getRoleid());
		
		String[] selectFun = roleDTO.getFunids().split(",");
		
		//先筛选出要添加的
		String funs="";
		for (String funid : selectFun) {
			int flag = 1;
			for (Fun_Role fun : funRoleList) {
				if(fun.getFunid().equals(funid)){
					flag = 0;
					funs +=fun.getFunid();
					break;
				}
			}
			if(flag == 1){
				Fun_Role funRole = new Fun_Role();
				funRole.setFunid(funid);
				funRole.setFuncreate(new Date());
				funRole.setFunRoleId(BuildUUID.getUUID());
				funRole.setRoleid(roleDTO.getRoleid());
				funRoleService.insert(funRole);
			}
		}
		
		
		//要删除的数据
		for (Fun_Role fun : funRoleList) {
			if(funs.indexOf(fun.getFunid()) < 0){
				funRoleService.deleteByPrimaryKey(fun.getFunRoleId());
			}
		}
		
		System.out.println("完成角色修改功能！");
		
		return "redirect:/role/roleIndex";
	}
	
	/**
	 * 删除角色
	 * @param roleid
	 * @return
	 */
	@RequestMapping("/deleteRole")
	public String deleteRole(String roleid){
		
		roleService.deleteByPrimaryKey(roleid);
		return "redirect:/role/roleIndex";
	}
	
}
