package com.ry.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ry.dto.weatherObject;
import com.ry.utils.HttpUtils;

/** 
* @author ry 
* @version 创建时间：2017年11月3日 下午3:32:32 
* 类说明 
*/
@Controller
@RequestMapping("/weather")
public class WeatherController {
	
	@RequestMapping("/weatherIndex")
	public String weatherIndex(){
		
    	
		return "weather/weatherIndex";
	}
	
	@RequestMapping(value = "showCity",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String showCity(){
		//查询所有查找天气的城市
		String host = "http://jisutqybmf.market.alicloudapi.com";
		String path = "/weather/city";
		String method = "GET";
		String appcode = "";//自己的appCode
		Map<String, String> headers = new HashMap<>();
		///最后在header中的格式(中间是英文空格)为Authorization:APPCODE 
		headers.put("Authorization", "APPCODE " +appcode);
		Map<String, String> querys = new HashMap<String, String>();
		JSONObject obj = new JSONObject();
		
		HttpResponse response;
		try {
			response = HttpUtils.doGet(host, path, method, headers, querys);
			//System.out.println(response.toString());
			
			obj = obj.parseObject(EntityUtils.toString(response.getEntity()));

			//System.out.println(obj.getString("result"));
			//List<weatherObject> list = JSON.parseArray(obj.getString("result"), weatherObject.class);
			
			//System.out.println(obj.get("result"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//由于有乱码，请传中文
		return obj.get("result").toString();
	}
	
	
	@RequestMapping(value = "/weatherSelect",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String weatherSelect(String city,String citycode,String cityid){
		String host = "http://jisutqybmf.market.alicloudapi.com";
	    String path = "/weather/query";
	    String method = "GET";
	    String appcode = "c06117b0aa214d1e8a8f09e72c820c28";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("city", city);
	    querys.put("citycode", citycode);
	    querys.put("cityid", cityid);
	    //querys.put("ip", "ip");
	    //querys.put("location", "location");

	    JSONObject obj = new JSONObject();
	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());
	    	//获取response的body
	    	
	    	obj = obj.parseObject(EntityUtils.toString(response.getEntity()).toString());
	    	
	    	//System.out.println(obj.get("result"));
	    } catch (Exception e) {
	    	e.printStackTrace ();
	    }
		return obj.get("result").toString();
	}
	
}
 