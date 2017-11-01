package com.ry.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.commons.PageInfo;
import com.ry.dto.UserDTO;
import com.ry.pojo.Fun;
import com.ry.pojo.Role;
import com.ry.pojo.User;
import com.ry.pojo.User_Role;
import com.ry.service.FunService;
import com.ry.service.RoleService;
import com.ry.service.UserRoleService;
import com.ry.service.UserService;
import com.ry.utils.BuildUUID;

@Controller
@RequestMapping("/user")
public class UserController {
	
	public static Logger logger = Logger.getLogger(UserController.class);
	
	String uuid=UUID.randomUUID().toString().replace("-", "");
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	//���ڲ�����ͬһ��mapper��  ��ע��
	@Resource(name="funService")
	FunService funService;

	@RequestMapping("/selectAllUser")
	public String selectAllUser(){
		return null;
	}
	
	
	/**
	 * Create by  ry  2017-10-10 19:55
	 */
	@RequestMapping("/goLogin")
	//����ǧ��Ҫ��responseBody �����ַ������ index  ����  user/login
	public String goLogin(String userAccount,String password,HttpSession session,HttpServletResponse response,HttpServletRequest request)throws Exception{
		//�ж��Ƿ��¼�ɹ���
		System.out.println("�û����ڽ��е�¼");
		User user = userService.selectByUserAccount(userAccount);
		System.out.println(user);
		
		if(user==null&&!user.getPassword().equals(password)){
			//response.sendRedirect("../user/login");
			return "user/login";
		}
		else{
			//��ת����ҳ
			session.setAttribute("nowUser", user);
			session.setAttribute("userAccount", user.getUseraccount());
			session.setAttribute("userId", user.getUserid());
			
			//������Ĺ�����ʾ left.jsp    ��ѯ�û�Ȩ�ޣ�������session
			//List<Fun> funList = funService.selectByUser(user.getUserid());
			List<Fun> funList = funService.selectAlls();
			System.out.println(funList.size());
			session.setAttribute("funList", funList);
			
			//��ѯ�û�
			PageInfo<User> pageInfos = userService.selectAll(1, 10);
			request.setAttribute("pageInfo", pageInfos);
			
			//response.sendRedirect("index");
			return "user/index";
		}
		
	}
	
	
	@RequestMapping("/login")
	public String isLogin(String username,String password){
		System.out.println("�����¼����");
		
		
		return "user/login";
	}
	
	@RequestMapping("/register")
	public String goRegister(){
		//��ת��ע�����
		System.out.println("����ע�����");
		return "user/register";
	}
	
	/**
	 * ����û�ע��
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	@RequestMapping("/registerUser")
	@ResponseBody
	public void registerUser(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(user.getUseraccount());
		System.out.println(user.getPassword());
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		user.setUserid(uuid);
		user.setUsercontact("18163114756");
		user.setPassword("111");
		user.setUseraccount("772917198@qq.com");
		user.setUsername("admin2");
		user.setUsercreate(new Date());
	
		userService.insertUser(user);
		
		//��ת����
		//request.getRequestDispatcher("../index.jsp").forward(request, response); 
		response.sendRedirect("index.jsp");
	}
	
	
	@RequestMapping("/userIndex")
	public String index(HttpServletRequest request, Integer pageIndex ){
		//��ѯ�û��б�
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<User> pageInfos = userService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "user/index";
	}
	
	
	/**
	 * ��ת�����ҳ��
	 * @return
	 */
	@RequestMapping("/goadd")
	public String goadd(HttpServletRequest request){
		//�û������ɫ
		//���еĽ�ɫ
		List roleList = roleService.selectAllRole();
		
		request.setAttribute("roleList", roleList);
		
		return "user/userAdd";
	}
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional   //��һ���Ҳ��Ǻ��˽�  ����һ��
	public String add(UserDTO user){
		
		user.setUserid(uuid);
		user.setUsercreate(new Date());
		
		userService.insertUser(user);
		
		String[] roles = user.getRoles().split(",");
		
		for (int i = 0; i < roles.length; i++) {
			String uuids = UUID.randomUUID().toString().replace("-", "");
			User_Role userRole = new User_Role();
			userRole.setRoleid(roles[i]);
			userRole.setUserid(uuid);
			userRole.setUserRoleId(uuids);
			userRoleService.insert(userRole);
		}
		return "redirect:/user/userIndex";
	}
	
	/**
	 * ��ת���޸Ľ���
	 * @param userid
	 * @param request
	 * @return
	 */
	@RequestMapping("/goupdate")
	public String goupdate(String userid,HttpServletRequest request){
		//��ȡ�û���Ϣ���û�Ȩ��
		User user = userService.selectByPrimaryKey(userid);
		
		User_Role userRole = new User_Role();
		userRole.setUserid(userid);
		List<User_Role> userRoleList = userRoleService.selectByCondition(userRole);
		
		//����Ӧ���ö�������ѯ��������Ϊ��˯���ˣ�������ȡid����ƴ�� List
		//��Ϊ���� ������List(����) 
		// ������Ӧ�ø�ϰһ��  list��set�Լ�������Щ�ӿڵĲ��ֺ���
		
		List list = new ArrayList<>();
		
		Iterator iterator = userRoleList.iterator();
		while(iterator.hasNext()){
			userRole = (User_Role)iterator.next();
			Role role = new Role();
			role = roleService.selectByPrimaryKey(userRole.getRoleid());
			list.add(role.getRolename());
		}
		
		//��ѯ�����н�ɫ
		List  roleList = roleService.selectAllRole();
		
		
		request.setAttribute("user", user);
		request.setAttribute("roleNameSet", list);
		//request.setAttribute("userRoleList", userRoleList);
		request.setAttribute("roleList", roleList);
		
		return "user/userEdit";
	}
	
	
	/**
	 * �޸��û���Ϣ
	 * @param userDTO
	 * @return
	 */
	@RequestMapping("/updateUser")
	@Transactional
	public String updateUser(UserDTO userDTO,HttpServletRequest request){
		//���������һ����
		int flag = userService.updateByPrimaryKeySelective(userDTO);
		
		//����1�������û���ɫ����ɾ����ǰ�û����еĽ�ɫ�ٽ��Ժ�Ľ�ɫ��ӽ�ȥ
		//����2�������û���ɫ���Ȳ�ѯ�����û���ӵ�еĽ�ɫ��Ȼ����ƥ�䣬���ƥ��Ľ�ɫ,ɾ����ƥ��Ľ�ɫ
		
		List<User_Role> userRoleList = userRoleService.selectUserRole(userDTO.getUserid());
		String[] roles = userDTO.getRoles().split(",");
		
		//�����ڵľ�ɾ��
		String isExist = "";
		for (String role : roles) {
			int f = 1;
			for (User_Role userRole : userRoleList){
				if(roles.equals(userRole.getRoleid()) && isExist.indexOf(role) < 0){
					//ƥ����ӵ�е�Ȩ�ޣ�����Ҫ���
					f = 0;
					isExist += role;
				}
			}
			if(f==1){
				//��Ӹý�ɫ���û���û�иý�ɫ��Ȩ��
				User_Role userRoleAdd = new User_Role();
				userRoleAdd.setRoleid(role);
				userRoleAdd.setUserid(userDTO.getUserid());
				userRoleAdd.setUserRoleId(BuildUUID.getUUID());
				userRoleService.insert(userRoleAdd);
			}
		}
		//��ͨ��isExist ɾ��ԭ�����е�Ȩ�ޣ������queryû�����
		for (User_Role userRole : userRoleList){
			if(isExist.indexOf(userRole.getRoleid()) < 0){
				//ɾ��
				userRoleService.deleteByPrimaryKey(userRole.getUserRoleId());
			}
		}
		
		System.out.println("�û��޸ĳɹ�");
		return "redirect:/user/userIndex";
		// ����Ҳ���� return "redirect:userIndex";
		
	}
	
	
	@RequestMapping("/deleteUser")
	public String deleteUser(String userid ,HttpServletRequest request){
		int flag = userService.deleteByPrimaryKey(userid);
		
		System.out.println("ɾ���û�"+userid+"�ɹ���");
		
		request.setAttribute("title", "ɾ������");
		request.setAttribute("message", "ɾ���ɹ���");
		
		return "redirect:/user/userIndex";
	}
	
}
