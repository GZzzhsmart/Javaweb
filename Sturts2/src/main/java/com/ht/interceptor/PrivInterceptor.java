package com.ht.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取类名称
		String methodName = invocation.getProxy().getMethod();
		//获取方法名称
		String className = invocation.getAction().getClass().getName();
		System.out.println("className="+className);
		System.out.println("methodName="+methodName);
		//允许执行的函数
		if(className!=null && className.equals("com.ht.action.UserAction")){
			if(methodName.equals("init") || methodName.equals("list") || methodName.equals("add")){
				String result = invocation.invoke();
				return result;
			}else{
				//重定向到privError.jsp页面
//				response.sendRedirect("privError.jsp");
				return "error";
			}
		}
		//获取下一步要执行的result
		return null;
	}

}
