package com.ry.controllers;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.serviceImpl.RedisServiceImpl;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��2�� ����4:34:15 
* ��˵�� 
*/
@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	RedisServiceImpl redisService;
	
	
	@RequestMapping("/redisIndex")
	public String redisIndex(HttpSession session , HttpServletRequest request){
		//��ʾredis���ݿ������
		List stringList = new ArrayList<>();  
		Map hashList = new HashMap<>();
		List listList = new ArrayList<>();
		
		if(redisService.get("name") != null){
			stringList.add(redisService.get("name"));
		}
		
		
		hashList = redisService.hgetAll("object");
		
		//listList = redisService.lpop("list");
		
		request.setAttribute("stringList", stringList);
		request.setAttribute("hashList", hashList);
		request.setAttribute("hashList", hashList);
		
		
		return "redis/redisIndex";
	}
	
	@RequestMapping("redisAdd")
	@ResponseBody
	public String redisAdd(String type ,String key,String value){
		//���ݲ�ͬ�����ͽ�����Ӳ���
		if(type.equals("String")){
			redisService.set(key, value);
		}
		
		//ָ��key  ����field ��  value
		if(type.equals("Hash")){
			redisService.hset("object", key, value);
		}
		
		
		
		//list  ���������key��ͬ
		if(type.equals("List")){
			redisService.lpush(key, value);
		}
		
		//��һ����Ajax��������
		
		
		
		return "success";
	}
	
}
 