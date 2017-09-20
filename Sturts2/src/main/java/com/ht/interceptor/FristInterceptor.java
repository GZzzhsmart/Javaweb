package com.ht.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class FristInterceptor implements Interceptor{

	public void destroy() {
		System.out.println("destroy");
	}

	public void init() {
		System.out.println("init");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		String actionName = invocation.getProxy().getActionName();
		String methodName = invocation.getProxy().getMethod();
		System.out.println("action="+action);
		System.out.println("actionName="+actionName);
		System.out.println("methodName="+methodName);
		//invoke函数确保程序继续往下运行
		System.out.println("before invoke");
		String result = invocation.invoke();
		System.out.println("after invoke");
		return result;
	}

}
