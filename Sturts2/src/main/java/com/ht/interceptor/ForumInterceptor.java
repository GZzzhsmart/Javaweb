package com.ht.interceptor;

import com.ht.action.ContentAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ForumInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object object = invocation.getAction();
		String method = invocation.getProxy().getMethod();
		//判断object变量是不是ContentAction类的实例
		if (object instanceof ContentAction) {
			if(method.equals("del")){
				return Action.ERROR;
			}
			ContentAction contentAction = (ContentAction) object;
			contentAction.setTopic(contentAction.getTopic().replaceAll("冰毒", "***"));
			contentAction.setContent(contentAction.getContent().replaceAll("冰毒", "***"));
			
		}
		String result = invocation.invoke();
		return result;
	}

}
