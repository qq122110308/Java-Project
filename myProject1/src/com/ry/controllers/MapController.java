package com.ry.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��3�� ����1:59:13 
* ��˵�� 
*/
@Controller
@RequestMapping("/map")
public class MapController {
	
	
	@RequestMapping("/mapIndex")
	public String mapIndex(){
		
		return "map/mapIndex";
	}
	
}
 