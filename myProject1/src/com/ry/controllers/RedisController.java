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
* @version 创建时间：2017年11月2日 下午4:34:15 
* 类说明 
*/
@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	RedisServiceImpl redisService;
	
	
	@RequestMapping("/redisIndex")
	public String redisIndex(HttpSession session , HttpServletRequest request){
		//显示redis数据库的数据
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
		//根据不同的类型进行添加操作
		if(type.equals("String")){
			redisService.set(key, value);
		}
		
		//指定key  设置field 和  value
		if(type.equals("Hash")){
			redisService.hset("object", key, value);
		}
		
		
		
		//list  保持输入的key相同
		if(type.equals("List")){
			redisService.lpush(key, value);
		}
		
		//这一块是Ajax传过来的
		
		
		
		return "success";
	}
	
}
 