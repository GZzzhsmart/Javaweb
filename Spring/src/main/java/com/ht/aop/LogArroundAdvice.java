package com.ht.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogArroundAdvice implements MethodInterceptor{
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	public Object invoke(MethodInvocation arg) throws Throwable {
		Object result=null;
		logger.log(Level.INFO, arg.getMethod().getName()+ "函数运行之前");
		result = arg.proceed();
		logger.log(Level.INFO, arg.getMethod().getName()+ "函数运行结束");
		return result;
	}

}
