package com.ry.commons;

import redis.clients.jedis.JedisPubSub;

/** 
* @author ry 
* @version 创建时间：2017年11月9日 上午11:57:08 
* 类说明 
*/
public class Subscriber extends JedisPubSub {
	
	@Override  
    public void unsubscribe() {  
        super.unsubscribe();  
    }  
  
    @Override  
    public void unsubscribe(String... channels) {  
        super.unsubscribe(channels);  
    }  
  
    @Override  
    public void subscribe(String... channels) {  
        super.subscribe(channels);  
    }  
  
    @Override  
    public void psubscribe(String... patterns) {  
        super.psubscribe(patterns);  
    }  
  
    @Override  
    public void punsubscribe() {  
        super.punsubscribe();  
    }  
  
    @Override  
    public void punsubscribe(String... patterns) {  
        super.punsubscribe(patterns);  
    }  
  
    @Override  
    public void onMessage(String channel, String message) {  
        System.out.println("channel:" + channel + "receives message :" + message);  
        //下面这个是取消订阅
        //this.unsubscribe();  
    }  
  
    @Override  
    public void onPMessage(String pattern, String channel, String message) {  
  
    }  
  
    @Override  
    public void onSubscribe(String channel, int subscribedChannels) {  
        System.out.println("channel:" + channel + "is been subscribed:" + subscribedChannels);  
    }  
  
    @Override  
    public void onPUnsubscribe(String pattern, int subscribedChannels) {  
  
    }  
  
    @Override  
    public void onPSubscribe(String pattern, int subscribedChannels) {  
  
    }  
  
    @Override  
    public void onUnsubscribe(String channel, int subscribedChannels) {  
        System.out.println("channel:" + channel + "is been unsubscribed:" + subscribedChannels);  
    }
	
	
}
 