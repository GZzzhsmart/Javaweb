package com.ht.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHandler implements InvocationHandler{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object  delegate;//代理
	public Object bind(Object delegate){
		this.delegate = delegate;
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result=null;
		logger.log(Level.INFO, "进入"+proxy.getClass().getName()+"对象的"+method.getName()+"方法");
		//处理业务
		result = method.invoke(delegate,args);
		
		logger.log(Level.INFO, "结束"+proxy.getClass().getName()+"对象的"+method.getName()+"方法");
		return result;
	}

}
