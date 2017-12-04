package com.ry.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author ry 
* @version 创建时间：2017年11月28日 上午10:07:02 
* 类说明 
*/
@Controller
@RequestMapping("/nginx")
public class NginxController {
	
	@RequestMapping("/test")
	public String testNginx(){
		
		return "nginx/index1";
	}
}
 