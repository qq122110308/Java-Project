package com.ry.dto;

import java.util.Date;

import com.ry.pojo.User;

/**
 * ���ͣ�ΪʲôҪ��DTO�� data transfer object  ���ݴ������
 * ��������д�û���ӹ��ܵ�ʱ���֣�ͨ��ognl���͵ķ�ʽ �����name��������user������ֶΣ���ô
 * use��������ݾͽ����������� �����뿴Դ�룡
 * UserDTO.java
 * @author ruanyang
 * 2017��10��30��
 */
public class UserDTO extends User{
	
    private String password2;
    
    private String roles;


	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
    
    
    
    
}
