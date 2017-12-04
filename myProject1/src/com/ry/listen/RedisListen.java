package com.ry.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import redis.clients.jedis.JedisPubSub;

/** 
* @author ry 
* @version 创建时间：2017年11月27日 下午4:33:45 
* 类说明   消息订阅者的监听器
*/
public class RedisListen extends JedisPubSub implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	public  void onMessage(String channel, String message){
		System.out.println("进来了啊1");
	}

    public  void onPMessage(String pattern, String channel,
            String message){
    	System.out.println("进来了啊2");
    }
	
}
 