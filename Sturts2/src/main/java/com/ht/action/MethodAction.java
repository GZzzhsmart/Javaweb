package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class MethodAction extends ActionSupport{

	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	@Override
	public String execute() throws Exception {
		System.out.println("页面调用了execute函数");
		System.out.println("action="+action);
		return null;
	}
	
	public String add() throws Exception {
		System.out.println("页面调用了add函数");
		System.out.println("action="+action);
		return INPUT;
	}
	public String del() throws Exception {
		System.out.println("页面调用了del函数");
		System.out.println("action="+action);
		return null;
	}
	public String update() throws Exception{
		System.out.println("页面调用了update函数");
		System.out.println("action="+action);
		return SUCCESS;
	}
	public String list() throws Exception{
		System.out.println("页面调用了list函数");
		System.out.println("action="+action);
		return "list";
	}
	public String save() throws Exception{
		System.out.println("页面调用了save函数");
		System.out.println("action="+action);
		return null;
	}
	
}
