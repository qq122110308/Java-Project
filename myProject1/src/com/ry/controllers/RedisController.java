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
* @version ����ʱ�䣺2017��11��2�� ����4:34:15 
* ��˵�� 
*/
@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
	RedisServiceImpl redisService;
	
	
	@RequestMapping("/redisIndex")
	@SystemControllerLog(description = "����redis��ҳ")
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
	@SystemControllerLog(description = "redis�����������")
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
	
	
	//hyperloglog  HyperLogLogһ�����õĳ�������ͳ����վ��UV��������IP��  ��Ҫ fastutil jar��
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
	
	//redis�ķ���(publish)�Ͷ���(subscribe)
	@RequestMapping("/publish")
	@SystemControllerLog(description = "redis����")
	public String redisPublish() throws Exception {
		long t = redisService.publis("redisChat", "there is a test");
		Thread.sleep(5000);
    	t = redisService.publis("redisChat", "your mother is boom");
    	Thread.sleep(5000);
    	t = redisService.publis("redisChat", "wqnmlgb");
    	
		System.out.println(t);
		return "redis/redisPublish";
	}
	//����
	@RequestMapping("/subscriber")
	@SystemControllerLog(description = "redis����")
	public String redisSubscriber(){
		//�ο� http://blog.csdn.net/u011734144/article/details/51782085
		//�Ѽ����ӽ���
		RedisListen listen = new RedisListen();
		redisService.subscribe(listen,"redisChat");
		return "redis/redisSubscriber";
	}
	
}
 