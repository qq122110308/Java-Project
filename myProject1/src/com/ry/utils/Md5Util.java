package com.ry.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
* @author ry 
* @version 创建时间：2017年11月27日 上午9:16:14 
* 类说明
* 参考： http://blog.csdn.net/miaoyahong/article/details/50561881 
*/
public class Md5Util {
	//生成MD5
	public static String getMD5(String message){
		String md5 = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");//创建一个MD5算法对象
			byte[] messageByte = message.getBytes("UTF-8");
			byte[] md5Byte = md.digest(messageByte); // 获得MD5字节数组,16*8=128位
			md5 = bytesToHex(md5Byte); //转换为16进制字符串
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return md5;
	}
	
	
	//二进制转十六进制
	public static String bytesToHex(byte[] bytes){
		StringBuffer hexStr = new StringBuffer();
		int num; 
		for(int i =0; i < bytes.length; i++){
			num = bytes[i];
			if(num < 0){
				num += 256;
			}
			if(num < 16){
				hexStr.append("0");
			}
			hexStr.append(Integer.toHexString(num));
		}
		return hexStr.toString().toUpperCase();
	}
}
 