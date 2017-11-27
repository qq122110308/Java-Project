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
* @version ����ʱ�䣺2017��11��3�� ����10:01:06 
* ��˵�� 
*/
@Controller
@RequestMapping("/email")
public class EmailController {
	
	@RequestMapping("/emailIndex")
	public String emailIndex(){
		return "email/emailIndex";
	}
	
	
	@RequestMapping("/emailSend")
	@SystemControllerLog(description = "�����ʼ�")
	public String sendEmail(String topic ,String content, HttpServletRequest request) throws Exception{
		
		/**
		 * �����ʼ�����
		 */
		String emailAccount = "122110308@qq.com";
		//���Լ���ȡ
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
        
        //���ò�����������ʾ��
        request.setAttribute("message", "���ͳɹ���");
        
		return "email/emailIndex";
	}
	
	/**
     * ����һ��ֻ�����ı��ļ��ʼ�
     *
     * @param session �ͷ����������ĻỰ
     * @param sendMail ����������
     * @param receiveMail �ռ�������
     * @return
     * @throws Exception
     */
	 public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String topic, String content) throws Exception {
	        // 1. ����һ���ʼ�
	        MimeMessage message = new MimeMessage(session);

	        // 2. From: �����ˣ��ǳ��й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸��ǳƣ�
	        message.setFrom(new InternetAddress(sendMail, "122110308@qq.com", "UTF-8"));

	        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�����û�", "UTF-8"));

	        // 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
	        message.setSubject(topic, "UTF-8");

	        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
	        message.setContent(content,"text/html;charset=UTF-8");

	        // 6. ���÷���ʱ��
	        message.setSentDate(new Date());

	        // 7. ��������
	        message.saveChanges();

	        return message;
	    }
	
}
 