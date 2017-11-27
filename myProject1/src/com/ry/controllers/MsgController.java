package com.ry.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ry.annotation.SystemControllerLog;
import com.ry.utils.HttpUtils;

/** 
* @author ry 
* @version 创建时间：2017年11月4日 上午11:41:06 
* 类说明 
*/
@Controller
@RequestMapping("/msg")
public class MsgController {
	
	@RequestMapping("/msgIndex")
	public String msgIndex(){
		//跳转到短信发送界面
		
		return "msg/msgIndex";
	}
	
	/**
	 * 这里采用阿里的短信收费服务
	 * 发送短信功能  ajax
	 * @return
	 */
	@RequestMapping(value = "/sendMsg", produces = "application/json;charset=UTF-8")
	@SystemControllerLog(description = "发送短信")
	@ResponseBody
	public String sendMsg(){
		String host = "http://sms.market.alicloudapi.com";
		String path = "/singleSenSms";
		String method = "GET";
		//你自己的AppCode
		String appcode = "c06117b0aa214d1e8a8f09e72c820c28";
		Map<String, String> headers = new HashMap<>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE "+appcode);
		Map<String, String> querys = new HashMap<>();
		
		querys.put("ParamString", "{\"no\":\"123456\"}");
	    querys.put("RecNum", "RecNum");
	    querys.put("SignName", "SignName");
	    querys.put("TemplateCode", "TemplateCode");

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
	    	obj = obj.parseObject(EntityUtils.toString(response.getEntity()));
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
	    return obj.toString();
	    
	}
	
}
 