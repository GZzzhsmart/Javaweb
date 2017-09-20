package com.ht.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MethodInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg) throws Exception {
		String action = arg.getProxy().getActionName();
		String method = arg.getProxy().getMethod();
		long start = System.currentTimeMillis();
		String result = arg.invoke();
		long end = System.currentTimeMillis();
		System.out.println("拦截器"+action+"执行"+method+"后，共花费时间："+(end-start)+"毫秒");
		return Action.LOGIN;
	}

}
