package com.ry.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ry.annotation.SystemControllerLog;
import com.ry.listen.RedisListen;
import com.ry.serviceImpl.RedisServiceImpl;

import net.agkn.hll.HLL;

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
	@SystemControllerLog(description = "进入redis主页")
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
	@SystemControllerLog(description = "redis数据类型添加")
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
	
	
	//hyperloglog  HyperLogLog一个常用的场景就是统计网站的UV。（独立IP）  还要 fastutil jar包
	@RequestMapping("/hyperloglog")
	public void testHyperloglog(){
		final int seed = 123456;
		
		final Integer[] data = new Integer[]{1,1,2,2,3,3,4,4,5,6,6,6,7,7,7,7,8,10}; 
		
		final HLL hll = new HLL(13, 5);
		
		for (Integer integer : data) {
			hll.addRaw(integer);	
		}
		
		System.out.println("Distinct count="+ hll.cardinality());
	}
	
	//redis的发布(publish)和订阅(subscribe)
	@RequestMapping("/publish")
	@SystemControllerLog(description = "redis发布")
	public String redisPublish() throws Exception {
		long t = redisService.publis("redisChat", "there is a test");
		Thread.sleep(5000);
    	t = redisService.publis("redisChat", "your mother is boom");
    	Thread.sleep(5000);
    	t = redisService.publis("redisChat", "wqnmlgb");
    	
		System.out.println(t);
		return "redis/redisPublish";
	}
	//订阅
	@RequestMapping("/subscriber")
	@SystemControllerLog(description = "redis订阅")
	public String redisSubscriber(){
		//参考 http://blog.csdn.net/u011734144/article/details/51782085
		//把监听加进来
		RedisListen listen = new RedisListen();
		redisService.subscribe(listen,"redisChat");
		return "redis/redisSubscriber";
	}
	
}
 