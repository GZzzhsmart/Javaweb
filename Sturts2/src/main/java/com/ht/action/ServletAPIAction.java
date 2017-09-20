package com.ht.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/*
 * 方式一、与Servlet解耦合的非IOC方式
 * 		context=ActionContext.getContext();
		request=(Map) context.get("request");
		session=context.getSession();
		application=context.getApplication();
方式二、与Servlet解耦合的IOC方式
实现RequestAware,SessionAware,ApplicationAware接口
方式三、与Servlet耦合的非IOC方式
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = ServletActionContext.getServletContext();
方式四、与Servlet耦合的IOC方式
实现ServletRequestAware,ServletContextAware接口
 * 
 * */
public class ServletAPIAction extends ActionSupport{

	Map request;
	Map session;
	Map application;
	
	@Override
	public String execute() throws Exception {
		ActionContext context = ActionContext.getContext();
		//获取request对象
		request = (Map)context.get("request");
		//获取session对象
		session = context.getSession();
		//获取application对象
		application = context.getApplication();
		request.put("username", "admin");
		session.put("username", "administrator");
		application.put("count", 1);
		return INPUT;
	}
}
