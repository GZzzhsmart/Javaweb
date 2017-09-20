package com.ht.aop;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterAdvice implements AfterReturningAdvice{

	private Logger logger = Logger.getLogger(this.getClass().getName());
	public void afterReturning(Object object, Method method, Object[] args,
			Object target) throws Throwable {
		logger.log(Level.INFO, method.getName()+ "函数结束运行");
	}

}
