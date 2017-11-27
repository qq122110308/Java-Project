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
* @version ����ʱ�䣺2017��11��4�� ����11:41:06 
* ��˵�� 
*/
@Controller
@RequestMapping("/msg")
public class MsgController {
	
	@RequestMapping("/msgIndex")
	public String msgIndex(){
		//��ת�����ŷ��ͽ���
		
		return "msg/msgIndex";
	}
	
	/**
	 * ������ð���Ķ����շѷ���
	 * ���Ͷ��Ź���  ajax
	 * @return
	 */
	@RequestMapping(value = "/sendMsg", produces = "application/json;charset=UTF-8")
	@SystemControllerLog(description = "���Ͷ���")
	@ResponseBody
	public String sendMsg(){
		String host = "http://sms.market.alicloudapi.com";
		String path = "/singleSenSms";
		String method = "GET";
		//���Լ���AppCode
		String appcode = "c06117b0aa214d1e8a8f09e72c820c28";
		Map<String, String> headers = new HashMap<>();
		//�����header�еĸ�ʽ(�м���Ӣ�Ŀո�)ΪAuthorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE "+appcode);
		Map<String, String> querys = new HashMap<>();
		
		querys.put("ParamString", "{\"no\":\"123456\"}");
	    querys.put("RecNum", "RecNum");
	    querys.put("SignName", "SignName");
	    querys.put("TemplateCode", "TemplateCode");

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
	    	obj = obj.parseObject(EntityUtils.toString(response.getEntity()));
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
	    return obj.toString();
	    
	}
	
}
 