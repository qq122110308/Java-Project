package com.ry.controllers;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��30�� ����1:00:53 
* ��˵�� 
*/
@Controller
@RequestMapping("/task")
public class TaskController {
	
	
	@RequestMapping("/index")
	public String index(){
		return "task/taskIndex";
	}
	
	@RequestMapping("/executeTask")
	public void executeTask(){
		Queue<String> logs = new LinkedBlockingQueue<>(1000);
		
	}
}
 