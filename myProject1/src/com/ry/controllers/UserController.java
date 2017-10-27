package com.ry.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.commons.PageInfo;
import com.ry.pojo.Fun;
import com.ry.pojo.User;
import com.ry.service.FunService;
import com.ry.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	public static Logger logger = Logger.getLogger(UserController.class);
	
	String uuid=UUID.randomUUID().toString().replace("-", "");
	
	@Resource
	private UserService userService;
	
	//由于不是在同一个mapper中  请注意
	@Resource(name="funService")
	FunService funService;

	@RequestMapping("selectAllUser")
	public String selectAllUser(){
		return null;
	}
	
	
	/**
	 * Create by  ry  2017-10-10 19:55
	 */
	@RequestMapping("goLogin")
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
			
			//response.sendRedirect("index");
			return "user/index";
		}
		
	}
	
	
	@RequestMapping("login")
	public String isLogin(String username,String password){
		System.out.println("进入登录界面");
		
		
		return "user/login";
	}
	
	@RequestMapping("register")
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
	
	@RequestMapping("registerUser")
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
	
	
	@RequestMapping("userIndex")
	public String index(HttpServletRequest request, Integer pageIndex ){
		//查询用户列表
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<User> pageInfos = userService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "user/index";
	}
	
}
