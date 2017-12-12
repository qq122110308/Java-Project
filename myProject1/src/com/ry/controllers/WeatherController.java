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
* @version ����ʱ�䣺2017��11��3�� ����3:32:32 
* ��˵�� 
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
		//��ѯ���в��������ĳ���
		String host = "http://jisutqybmf.market.alicloudapi.com";
		String path = "/weather/city";
		String method = "GET";
		String appcode = "";//�Լ���appCode
		Map<String, String> headers = new HashMap<>();
		///�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 
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
		
		
		//���������룬�봫����
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
	    //�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 
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
	    	* ��Ҫ��ʾ����:
	    	* HttpUtils���
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* ����
	    	*
	    	* ��Ӧ�����������
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	//System.out.println(response.toString());
	    	//��ȡresponse��body
	    	
	    	obj = obj.parseObject(EntityUtils.toString(response.getEntity()).toString());
	    	
	    	//System.out.println(obj.get("result"));
	    } catch (Exception e) {
	    	e.printStackTrace ();
	    }
		return obj.get("result").toString();
	}
	
}
 