package com.ht.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class ContextDemoAction extends ActionSupport implements ServletRequestAware,ServletContextAware{

	HttpServletRequest request;
	HttpSession session;
	ServletContext application;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	public void setServletContext(ServletContext application) {
		this.application = application;
	}
	
	@Override
	public String execute() throws Exception {
		request.setAttribute("username", "admin8888");
		session.setAttribute("username", "administrator888");
		application.setAttribute("count", 888);
		return INPUT;
	}
}
