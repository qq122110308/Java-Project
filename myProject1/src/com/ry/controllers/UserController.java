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
	
	//由于不是在同一个mapper中  请注意
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
	//这里千万不要用responseBody 会以字符串输出 index  或者  user/login
	public String goLogin(String userAccount,String password,HttpSession session,HttpServletResponse response,HttpServletRequest request)throws Exception{
		//判断是否登录成功！
		System.out.println("用户正在进行登录");
		User user = userService.selectByUserAccount(userAccount);
		System.out.println(user);
		
		if(user==null&&!user.getPassword().equals(password)){
			//response.sendRedirect("../user/login");
			return "user/login";
		}
		else{
			//跳转到首页
			session.setAttribute("nowUser", user);
			session.setAttribute("userAccount", user.getUseraccount());
			session.setAttribute("userId", user.getUserid());
			
			//完成左侧的功能显示 left.jsp    查询用户权限，并存入session
			//List<Fun> funList = funService.selectByUser(user.getUserid());
			List<Fun> funList = funService.selectAlls();
			System.out.println(funList.size());
			session.setAttribute("funList", funList);
			
			//查询用户
			PageInfo<User> pageInfos = userService.selectAll(1, 10);
			request.setAttribute("pageInfo", pageInfos);
			
			//response.sendRedirect("index");
			return "user/index";
		}
		
	}
	
	
	@RequestMapping("/login")
	public String isLogin(String username,String password){
		System.out.println("进入登录界面");
		
		
		return "user/login";
	}
	
	@RequestMapping("/register")
	public String goRegister(){
		//跳转到注册界面
		System.out.println("进入注册界面");
		return "user/register";
	}
	
	/**
	 * 完成用户注册
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
		
		//跳转界面
		//request.getRequestDispatcher("../index.jsp").forward(request, response); 
		response.sendRedirect("index.jsp");
	}
	
	
	@RequestMapping("/userIndex")
	public String index(HttpServletRequest request, Integer pageIndex ){
		//查询用户列表
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<User> pageInfos = userService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "user/index";
	}
	
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/goadd")
	public String goadd(HttpServletRequest request){
		//用户分配角色
		//所有的角色
		List roleList = roleService.selectAllRole();
		
		request.setAttribute("roleList", roleList);
		
		return "user/userAdd";
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	@Transactional   //这一块我不是很了解  搜索一下
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
	 * 跳转到修改界面
	 * @param userid
	 * @param request
	 * @return
	 */
	@RequestMapping("/goupdate")
	public String goupdate(String userid,HttpServletRequest request){
		//获取用户信息及用户权限
		User user = userService.selectByPrimaryKey(userid);
		
		User_Role userRole = new User_Role();
		userRole.setUserid(userid);
		List<User_Role> userRoleList = userRoleService.selectByCondition(userRole);
		
		//这里应该用多条件查询，但是因为快睡觉了，这里先取id处理拼接 List
		//因为无序 这里用List(有序) 
		// 这里我应该复习一下  list、set以及引用这些接口的部分函数
		
		List list = new ArrayList<>();
		
		Iterator iterator = userRoleList.iterator();
		while(iterator.hasNext()){
			userRole = (User_Role)iterator.next();
			Role role = new Role();
			role = roleService.selectByPrimaryKey(userRole.getRoleid());
			list.add(role.getRolename());
		}
		
		//查询出所有角色
		List  roleList = roleService.selectAllRole();
		
		
		request.setAttribute("user", user);
		request.setAttribute("roleNameSet", list);
		//request.setAttribute("userRoleList", userRoleList);
		request.setAttribute("roleList", roleList);
		
		return "user/userEdit";
	}
	
	
	/**
	 * 修改用户信息
	 * @param userDTO
	 * @return
	 */
	@RequestMapping("/updateUser")
	@Transactional
	public String updateUser(UserDTO userDTO,HttpServletRequest request){
		//保持事务的一致性
		int flag = userService.updateByPrimaryKeySelective(userDTO);
		
		//方案1：对于用户角色，先删除当前用户所有的角色再将以后的角色添加进去
		//方案2：对于用户角色，先查询出该用户所拥有的角色，然后来匹配，添加匹配的角色,删除不匹配的角色
		
		List<User_Role> userRoleList = userRoleService.selectUserRole(userDTO.getUserid());
		String[] roles = userDTO.getRoles().split(",");
		
		//不存在的就删除
		String isExist = "";
		for (String role : roles) {
			int f = 1;
			for (User_Role userRole : userRoleList){
				if(roles.equals(userRole.getRoleid()) && isExist.indexOf(role) < 0){
					//匹配所拥有的权限，不需要添加
					f = 0;
					isExist += role;
				}
			}
			if(f==1){
				//添加该角色，用户并没有该角色的权限
				User_Role userRoleAdd = new User_Role();
				userRoleAdd.setRoleid(role);
				userRoleAdd.setUserid(userDTO.getUserid());
				userRoleAdd.setUserRoleId(BuildUUID.getUUID());
				userRoleService.insert(userRoleAdd);
			}
		}
		//再通过isExist 删除原来就有的权限，而这次query没有添加
		for (User_Role userRole : userRoleList){
			if(isExist.indexOf(userRole.getRoleid()) < 0){
				//删除
				userRoleService.deleteByPrimaryKey(userRole.getUserRoleId());
			}
		}
		
		System.out.println("用户修改成功");
		return "redirect:/user/userIndex";
		// 这样也可以 return "redirect:userIndex";
		
	}
	
	
	@RequestMapping("/deleteUser")
	public String deleteUser(String userid ,HttpServletRequest request){
		int flag = userService.deleteByPrimaryKey(userid);
		
		System.out.println("删除用户"+userid+"成功！");
		
		request.setAttribute("title", "删除操作");
		request.setAttribute("message", "删除成功！");
		
		return "redirect:/user/userIndex";
	}
	
}
