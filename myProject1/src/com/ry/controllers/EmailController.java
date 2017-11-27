package com.ry.controllers;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ry.annotation.SystemControllerLog;

/** 
* @author ry 
* @version 创建时间：2017年11月3日 上午10:01:06 
* 类说明 
*/
@Controller
@RequestMapping("/email")
public class EmailController {
	
	@RequestMapping("/emailIndex")
	public String emailIndex(){
		return "email/emailIndex";
	}
	
	
	@RequestMapping("/emailSend")
	@SystemControllerLog(description = "发送邮件")
	public String sendEmail(String topic ,String content, HttpServletRequest request) throws Exception{
		
		/**
		 * 发送邮件过程
		 */
		String emailAccount = "122110308@qq.com";
		//请自己获取
		String emailPassword = "";
		
		
		String emailSMTPHost = "smtp.qq.com";
		String receiveMailAccount = "772917198@qq.com";
		
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", emailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		
		final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        
        Session session = Session.getInstance(props);
        session.setDebug(true); 
        
        MimeMessage message = createMimeMessage(session, emailAccount, receiveMailAccount, topic, content);
        
        Transport transport = session.getTransport();
        
        transport.connect(emailAccount, emailPassword);

        transport.sendMessage(message, message.getAllRecipients());
        
        transport.close();
        
        //设置参数，弹出提示框
        request.setAttribute("message", "发送成功！");
        
		return "email/emailIndex";
	}
	
	/**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return
     * @throws Exception
     */
	 public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String topic, String content) throws Exception {
	        // 1. 创建一封邮件
	        MimeMessage message = new MimeMessage(session);

	        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
	        message.setFrom(new InternetAddress(sendMail, "122110308@qq.com", "UTF-8"));

	        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "本人用户", "UTF-8"));

	        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
	        message.setSubject(topic, "UTF-8");

	        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
	        message.setContent(content,"text/html;charset=UTF-8");

	        // 6. 设置发件时间
	        message.setSentDate(new Date());

	        // 7. 保存设置
	        message.saveChanges();

	        return message;
	    }
	
}
 