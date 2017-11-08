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
* @version ����ʱ�䣺2017��11��8�� ����9:02:42 
* ��˵�� 
*/
@Controller
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping("/logIndex")
	public String logIndex(HttpServletRequest request, Integer pageIndex){
		
		//��ѯ��־�б�
		if(pageIndex==null){
			pageIndex=1;
		}
		PageInfo<Log> pageInfos = logService.selectAll(pageIndex, 10);
		request.setAttribute("pageInfo", pageInfos);
		
		return "log/logIndex";
	}
}
 