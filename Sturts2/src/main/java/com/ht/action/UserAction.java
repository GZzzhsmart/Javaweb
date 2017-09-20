package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String login() throws Exception{
		msg = "执行login函数成功";
		return SUCCESS;
	}
	public String add() throws Exception{
		msg="执行add函数成功！";
		return SUCCESS;
	}
	public String del() throws Exception{
		msg="执行del函数成功！";
		return SUCCESS;
	}
	public String update() throws Exception{
		msg="执行update函数成功！";
		return SUCCESS;
	}
	public String list() throws Exception{
		msg="执行list函数成功！";
		return SUCCESS;
	}
	public String init() throws Exception{
		msg="执行init函数成功！";
		return SUCCESS;
	}
	public String save() throws Exception{
		msg="执行save函数成功！";
		return SUCCESS;
	}
}
