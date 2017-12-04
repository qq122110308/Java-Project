package com.ry.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import redis.clients.jedis.JedisPubSub;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��27�� ����4:33:45 
* ��˵��   ��Ϣ�����ߵļ�����
*/
public class RedisListen extends JedisPubSub implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
	public  void onMessage(String channel, String message){
		System.out.println("�����˰�1");
	}

    public  void onPMessage(String pattern, String channel,
            String message){
    	System.out.println("�����˰�2");
    }
	
}
 