package com.ry.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileUploadController.java
 * @author ruanyang
 * 2017��10��26��
 */
@Controller
@RequestMapping("file")
public class FileUploadController {
	
	@RequestMapping("index")
	public String index(){
		//��ת�����ؽ���
		return "file/index";
	}
	
	@RequestMapping("uploadFile")
	public String uploadFile(MultipartFile file ,HttpSession session) throws IllegalStateException, IOException{
		System.out.println("file"+file);
		String path = session.getServletContext().getRealPath("/files");
		
		if(file.getSize()>0){
			//��ȡ�ϴ��ļ���ԭʼ����
			String fileName = file.getOriginalFilename();
			
			//�ж��ļ�����
			if(fileName.endsWith("jpg")||fileName.endsWith("png")){
				File files = new File(path,fileName);
				file.transferTo(files);
				return "file/uploadSuccess";
			}
			else{
				return "error";
			}
		}
		else{
			return "error";
		}
		
	}
}	
