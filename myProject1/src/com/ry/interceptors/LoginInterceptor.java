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
 * 2017��10��30��
 * �ж��û��Ƿ��¼�����δ��¼ ��ô����ת����¼����
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	public  LoginInterceptor() {
	
	}
	
	
	// afterCompletion()������DispatcherServlet��ȫ����������󱻵���
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
	
	// postHandle()������ҵ��������������֮�󱻵���
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
	
	// preHandle()������ҵ��������������֮ǰ������ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		//�ж�session �Ƿ����
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("nowUser");
		String url = request.getRequestURL().toString();
		
//		String url1 = request.getRealPath("../");//�����d�̵ĵ�ַ
//		String url2 = request.getContextPath();// ��ĿӦ�õ�ַ   /myProject1
		
		if(url.indexOf("user/login") >= 0 || url.indexOf(request.getContextPath()+"/user/goLogin") >= 0){
			return true;
		}
		else{
			if(user == null){
				//��תҳ��
				response.sendRedirect(request.getContextPath() +"/user/login");
				return false;
			}
			else
				return true;
		}
		
		
	}
	
}
