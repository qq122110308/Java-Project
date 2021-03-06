package com.ry.controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ry.annotation.SystemControllerLog;

/**
 * FileUploadController.java
 * @author ruanyang
 * 2017年10月26日
 */
@Controller
@RequestMapping("file")
public class FileUploadController {
	
	@RequestMapping("index")
	public String index(){
		//跳转到下载界面
		return "file/index";
	}
	
	@RequestMapping("uploadFile")
	@SystemControllerLog(description = "下载文件")
	public String uploadFile(MultipartFile file ,HttpSession session ,HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("file"+file);
		String path = session.getServletContext().getRealPath("/files");
		
		if(file.getSize()>0){
			//获取上传文件的原始名字
			String fileName = file.getOriginalFilename();
			
			//判断文件类型
			if(fileName.endsWith("jpg")||fileName.endsWith("png")){
				File files = new File(path,fileName);
				file.transferTo(files);
				
				request.setAttribute("message", "上传成功");
				request.setAttribute("title", "上传文件");
				
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
