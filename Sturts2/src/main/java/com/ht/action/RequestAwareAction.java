package com.ht.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class RequestAwareAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	Map request;
	Map session;
	Map application;
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public String execute() throws Exception {
		request.put("username", "admin111111111111");
		session.put("username", "administrator22222222");
		application.put("count", 1222);
		return INPUT;
	}
}
