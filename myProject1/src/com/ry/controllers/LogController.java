package com.ry.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ry.commons.PageInfo;
import com.ry.pojo.Log;
import com.ry.pojo.User;
import com.ry.service.LogService;

/** 
* @author ry 
* @version 创建时间：2017年11月8日 上午9:02:42 
* 类说明 
*/
@Controller
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping("/logIndex")
	public String logIndex(HttpServletRequest request, Integer pageIndex){
		
		//查询日志列表
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<Log> pageInfos = logService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "log/logIndex";
	}
}
 