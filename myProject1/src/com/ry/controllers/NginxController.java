package com.ry.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��28�� ����10:07:02 
* ��˵�� 
*/
@Controller
@RequestMapping("/nginx")
public class NginxController {
	
	@RequestMapping("/test")
	public String testNginx(){
		
		return "nginx/index1";
	}
}
 