package com.ry.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
* @author ry 
* @version 创建时间：2017年11月6日 上午8:53:02 
* 类说明  自定义注解 拦截Controller
*/
@Target({ElementType.PARAMETER , ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
	String description() default "";
}
 