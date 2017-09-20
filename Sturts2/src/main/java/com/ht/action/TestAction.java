package com.ht.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	private static final long serialVersionUID=1L;
	//map类型的request
	private Map<String, Object>request;
	//map类型的session
	private Map<String, Object>session;
	//map类型的application
	private Map<String, Object>application;
	public TestAction() {
		//获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		//获取map类型的request
		request = (Map<String, Object>)context.get("request");
		//获取map类型的session
		session = context.getSession();
		//获取map类型的application
		application = context.getApplication();
	}
	
	//请求处理方法
	@Override
	public String execute() throws Exception {
		String info = "宏图软件";
		//向request添加信息
		request.put("info", info);
		//向session添加信息
		session.put("info", info);
		//向application添加信息
		application.put("info", info);
		//成功返回
		return SUCCESS;
	}
}
