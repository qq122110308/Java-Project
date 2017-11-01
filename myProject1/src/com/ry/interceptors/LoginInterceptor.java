package com.ry.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ry.pojo.User;

/**
 * LoginInterceptor.java
 * @author ruanyang
 * 2017年10月30日
 * 判断用户是否登录，如果未登录 那么就跳转到登录界面
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	public  LoginInterceptor() {
	
	}
	
	
	// afterCompletion()方法在DispatcherServlet完全处理完请求后被调用
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	
	// postHandle()方法在业务处理器处理请求之后被调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	
	// preHandle()方法在业务处理器处理请求之前被调用 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//判断session 是否存在
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("nowUser");
		String url = request.getRequestURL().toString();
		
//		String url1 = request.getRealPath("../");//存放在d盘的地址
//		String url2 = request.getContextPath();// 项目应用地址   /myProject1
		
		if(url.indexOf("user/login") >= 0 || url.indexOf(request.getContextPath()+"/user/goLogin") >= 0){
			return true;
		}
		else{
			if(user == null){
				//跳转页面
				response.sendRedirect(request.getContextPath() +"/user/login");
				return false;
			}
			else
				return true;
		}
		
		
	}
	
}
