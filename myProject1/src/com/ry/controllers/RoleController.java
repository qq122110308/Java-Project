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
 * 2017��10��26��
 * ������ ʵ�ֽ�ɫ�������ع���
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
		//��ѯ��ɫ�б�
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<Role> pageInfos = roleService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "role/roleIndex";
	}
	
	@RequestMapping("/goadd")
	public String goadd(HttpServletRequest request){
		//�г����Ը����Ȩ��
		List<Fun> funList = funService.selectAlls();
		request.setAttribute("funList", funList);
		
		return "role/roleAdd";
	}
	
	
	@RequestMapping("/addRole")
	@Transactional
	public String add(HttpServletRequest request){
		
		//System.out.println("�������Ȩ�ޣ�"+request.getParameter("funids"));
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
		//�����ɫ���ܱ�
		
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
		
		request.setAttribute("title", "��Ӳ���");
		request.setAttribute("message", "�����ɹ���");
		
		return "redirect:roleIndex";
	}
	
	/**
	 * ��ת���޸Ľ���
	 * @param roleid
	 * @param request
	 * @return
	 */
	@RequestMapping("/goupdate")
	public String goupdate(String roleid,HttpServletRequest request){
		
		Role role = roleService.selectByPrimaryKey(roleid);
		//��ѯ����ɫӵ�е�Ȩ���Լ�Ȩ�ޱ���Ϣ
		List<Fun> funList = funService.selectAlls();
		//��������ò��� ����session
		
		//��ɫ��ӵ�е�Ȩ��
		List<Fun_Role> funRoleList = funRoleService.selectFunRole(roleid);
		
		//���� ����ModelAndView  ���ǰ�����Ƶ��ѧ���ģ�����������Ŀ��ʱ�����ڴ��� ����ͼ�����ϵͳ
		request.setAttribute("role", role);
		request.setAttribute("funRoleList", funRoleList);
		
		return "role/roleUpdate";
	}
	
	
	/**
	 * �޸Ľ�ɫ
	 * @param roleDTO
	 * @return
	 */
	@RequestMapping("updateRole")
	@Transactional
	public String updateRole(RoleDTO roleDTO)
	{
		roleService.updateByPrimaryKeySelective(roleDTO);
		
		//����Ҫ�ı��ɫȨ�ޱ�
		//ˢѡ��Ҫ��ӵĹ��ܣ�ɾ��δ��ӵĹ���
		List<Fun_Role> funRoleList =  funRoleService.selectFunRole(roleDTO.getRoleid());
		
		String[] selectFun = roleDTO.getFunids().split(",");
		
		//��ɸѡ��Ҫ��ӵ�
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
		
		
		//Ҫɾ��������
		for (Fun_Role fun : funRoleList) {
			if(funs.indexOf(fun.getFunid()) < 0){
				funRoleService.deleteByPrimaryKey(fun.getFunRoleId());
			}
		}
		
		System.out.println("��ɽ�ɫ�޸Ĺ��ܣ�");
		
		return "redirect:/role/roleIndex";
	}
	
	/**
	 * ɾ����ɫ
	 * @param roleid
	 * @return
	 */
	@RequestMapping("/deleteRole")
	public String deleteRole(String roleid){
		
		roleService.deleteByPrimaryKey(roleid);
		return "redirect:/role/roleIndex";
	}
	
}
