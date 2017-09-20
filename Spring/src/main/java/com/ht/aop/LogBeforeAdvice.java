package com.ht.aop;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.MethodBeforeAdvice;

public class LogBeforeAdvice implements MethodBeforeAdvice{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		logger.log(Level.INFO, method.getName()+ "函数开始运行");
		for (Object object : args) {
			System.out.println(object);
		}
		
	}

}
