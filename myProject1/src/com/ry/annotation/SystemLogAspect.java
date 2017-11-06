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
* @version 创建时间：2017年11月6日 上午8:58:23 
* 类说明   切点类
*/
@Aspect
@Component
public class SystemLogAspect {
	//注入Service用于把日志保存数据库
	@Resource
	private LogService logService;
	
	
	
	//本地异常日志记录对象
	private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
	
	//Service层切点
	@Pointcut("@annotation(com.ry.annotation.SystemServiceLog)")
	public void serviceAspect(){
		
	}
	
	//Controller层切点
	@Pointcut("@annotation(com.ry.annotation.SystemControllerLog)")
	public void controllerAspect(){
		
	}
	
	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //读取session中的用户    
        User user = (User) session.getAttribute("nowUser");    
        //请求的IP    
        String ip = request.getRemoteAddr();    
         try {    
            //*========控制台输出=========*//    
            System.out.println("=====前置通知开始=====");    
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));    
            System.out.println("请求人:" + user.getUsername());    
            System.out.println("请求IP:" + ip);    
            //*========数据库日志=========*//    
            Log log =new Log();
            log.setLogcreate(new Date());
            log.setLogip(ip);
            log.setLogexception(null);
            log.setLogid(BuildUUID.getUUID());
            log.setLogname(getControllerMethodDescription(joinPoint));
            log.setLogtype((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            
            //保存数据库    
            logService.insertSelective(log); 
            log = null;
            System.out.println("=====前置通知结束=====");    
        }  catch (Exception e) {    
            //记录本地异常日志    
            logger.error("==前置通知异常==");    
            logger.error("异常信息:{}", e.getMessage());    
        } 
	}
	
	/**
	 * 异常通知 用于拦截service层记录异常日志
	 */
	@AfterThrowing(pointcut = "serviceAspect()",throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();    
        //读取session中的用户    
        User user = (User) session.getAttribute("nowUser");           //获取请求ip    
        String ip = request.getRemoteAddr();    
        //获取用户请求方法的参数并序列化为JSON格式字符串    
        String params = "";    
         
         try {    
              /*========控制台输出=========*/    
            System.out.println("=====异常通知开始=====");    
            System.out.println("异常代码:" + e.getClass().getName());    
            System.out.println("异常信息:" + e.getMessage());    
            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
            System.out.println("方法描述:" + getServiceMethodDescription(joinPoint));    
            System.out.println("请求人:" + user.getUsername());    
            System.out.println("请求IP:" + ip);    
            System.out.println("请求参数:" + params);    
               /*==========数据库日志=========*/   
            Log log =new Log();
            log.setLogcreate(new Date());
            log.setLogip(ip);
            log.setLogexception(null);
            log.setLogid(BuildUUID.getUUID());
            log.setLogname(getControllerMethodDescription(joinPoint));
            log.setLogtype((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            
            //保存数据库    
            logService.insertSelective(log); 
            log = null;   
            System.out.println("=====异常通知结束=====");    
        }  catch (Exception ex) {    
            //记录本地异常日志    
            logger.error("==异常通知异常==");    
            logger.error("异常信息:{}", ex.getMessage());    
        }    
         /*==========记录本地异常日志==========*/    
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);    
    
	}
	
	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 */
	public static String getServiceMethodDescription(JoinPoint joinPoint) throws Exception{
		String targetName = joinPoint.getTarget().getClass().getName();
		//signature 签名
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
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
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
 