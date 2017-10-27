package com.ry.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ry.commons.PageInfo;
import com.ry.pojo.Fun;
import com.ry.service.FunService;

@Controller
@RequestMapping("user")
public class IndexController {
	
	public static Logger logger = Logger.getLogger(FunController.class);
	
	@Resource
	FunService funService;
	
	public PageInfo<Fun> funList;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request){
		//完成左侧的功能显示 left.jsp
		logger.info("进入系统首页");
		funList = funService.selectAll(1,10);
		//System.out.println(funList.size());
		request.setAttribute("funList", funList);
		return "index";
	}
}
