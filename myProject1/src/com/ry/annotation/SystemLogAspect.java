package com.ry.annotation;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ry.pojo.Log;
import com.ry.pojo.User;
import com.ry.service.LogService;
import com.ry.utils.BuildUUID;

/** 
* @author ry 
* @version ����ʱ�䣺2017��11��6�� ����8:58:23 
* ��˵��   �е���
*/
@Aspect
@Component
public class SystemLogAspect {
	//ע��Service���ڰ���־�������ݿ�
	@Resource
	private LogService logService;
	
	
	
	//�����쳣��־��¼����
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
	
	//Service���е�
	@Pointcut("@annotation(com.ry.annotation.SystemServiceLog)")
	public void serviceAspect(){
		
	}
	
	//Controller���е�
	@Pointcut("@annotation(com.ry.annotation.SystemControllerLog)")
	public void controllerAspect(){
		
	}
	
	/**
	 * ǰ��֪ͨ ��������Controller���¼�û��Ĳ���
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //��ȡsession�е��û�    
        User user = (User) session.getAttribute("nowUser");    
        //�����IP    
        String ip = request.getRemoteAddr();    
         try {    
            //*========����̨���=========*//    
            System.out.println("=====ǰ��֪ͨ��ʼ=====");    
            System.out.println("���󷽷�:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("��������:" + getControllerMethodDescription(joinPoint));    
            System.out.println("������:" + user.getUsername());    
            System.out.println("����IP:" + ip);    
            //*========���ݿ���־=========*//    
            Log log =new Log();
            log.setLogcreate(new Date());
            log.setLogip(ip);
            log.setLogexception(null);
            log.setLogid(BuildUUID.getUUID());
            log.setLogname(getControllerMethodDescription(joinPoint));
            log.setLogtype((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            
            //�������ݿ�    
            logService.insertSelective(log); 
            log = null;
            System.out.println("=====ǰ��֪ͨ����=====");    
        }  catch (Exception e) {    
            //��¼�����쳣��־    
            logger.error("==ǰ��֪ͨ�쳣==");    
            logger.error("�쳣��Ϣ:{}", e.getMessage());    
        } 
	}
	
	/**
	 * �쳣֪ͨ ��������service���¼�쳣��־
	 */
	@AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //��ȡsession�е��û�    
        User user = (User) session.getAttribute("nowUser");           //��ȡ����ip    
        String ip = request.getRemoteAddr();    
        //��ȡ�û����󷽷��Ĳ��������л�ΪJSON��ʽ�ַ���    
        String params = "";    
         
         try {    
              /*========����̨���=========*/    
            System.out.println("=====�쳣֪ͨ��ʼ=====");    
            System.out.println("�쳣����:" + e.getClass().getName());    
            System.out.println("�쳣��Ϣ:" + e.getMessage());    
            System.out.println("�쳣����:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("��������:" + getServiceMethodDescription(joinPoint));    
            System.out.println("������:" + user.getUsername());    
            System.out.println("����IP:" + ip);    
            System.out.println("�������:" + params);    
               /*==========���ݿ���־=========*/   
            Log log =new Log();
            log.setLogcreate(new Date());
            log.setLogip(ip);
            log.setLogexception(null);
            log.setLogid(BuildUUID.getUUID());
            log.setLogname(getControllerMethodDescription(joinPoint));
            log.setLogtype((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            
            //�������ݿ�    
            logService.insertSelective(log); 
            log = null;   
            System.out.println("=====�쳣֪ͨ����=====");    
        }  catch (Exception ex) {    
            //��¼�����쳣��־    
            logger.error("==�쳣֪ͨ�쳣==");    
            logger.error("�쳣��Ϣ:{}", ex.getMessage());    
        }    
         /*==========��¼�����쳣��־==========*/    
        logger.error("�쳣����:{}�쳣����:{}�쳣��Ϣ:{}����:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);    
    
	}
	
	/**
	 * ��ȡע���жԷ�����������Ϣ ����service��ע��
	 */
	public static String getServiceMethodDescription(JoinPoint joinPoint) throws Exception{
		String targetName = joinPoint.getTarget().getClass().getName();
		//signature ǩ��
		String methodName = joinPoint.getSignature().getName(); 
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemControllerLog. class).description();    
                     break;    
                }    
            }    
        }  
		
		return description;
	}
	
	
	/**  
     * ��ȡע���жԷ�����������Ϣ ����Controller��ע��  
     *  
     * @param joinPoint �е�  
     * @return ��������  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemControllerLog. class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    } 
	
	
	
}
 