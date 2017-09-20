package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class Login2Action extends ActionSupport{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String login() throws Exception{
		msg = "运行login函数成功";
		return SUCCESS;
	}
	public String method1() throws Exception{
		msg = "运行method1函数成功";
		return SUCCESS;
	}
	public String method2() throws Exception{
		msg = "运行method2函数成功";
		return SUCCESS;
	}
	public String method3() throws Exception{
		msg = "运行method3函数成功";
		return SUCCESS;
	}
	public String method4() throws Exception{
		msg = "运行method4函数成功";
		return SUCCESS;
	}
	public String method5() throws Exception{
		msg = "运行method5函数成功";
		return SUCCESS;
	}
	
}
