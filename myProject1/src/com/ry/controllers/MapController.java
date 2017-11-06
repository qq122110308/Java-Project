package com.ry.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author ry 
* @version 创建时间：2017年11月3日 下午1:59:13 
* 类说明 
*/
@Controller
@RequestMapping("/map")
public class MapController {
	
	
	@RequestMapping("/mapIndex")
	public String mapIndex(){
		
		return "map/mapIndex";
	}
	
}
 