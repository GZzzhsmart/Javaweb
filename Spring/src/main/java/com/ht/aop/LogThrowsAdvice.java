package com.ht.aop;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.ThrowsAdvice;

public class LogThrowsAdvice implements ThrowsAdvice{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void afterThrowing(Method method,Object[] args,Object target,Throwable subclass) {
		logger.log(Level.INFO, method.getName()+"函数发生了异常：异常原因如下：\n"+subclass);
	}
}
