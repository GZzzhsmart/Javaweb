package com.ht.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ServletContextAction extends ActionSupport{

	HttpServletRequest request;
	HttpSession session;
	ServletContext application;
	HttpServletResponse response;
	@Override
	public String execute() throws Exception {
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = ServletActionContext.getServletContext();
		response = ServletActionContext.getResponse();
		request.setAttribute("username", "admin3333");
		session.setAttribute("username", "administrator444");
		application.setAttribute("count", 1819);
		return INPUT;
	}
}
