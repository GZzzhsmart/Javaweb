package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{

	private String username;
	private String password;
	public Login() {
		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		if(username.equals("struts2")){
			return "loginsuccess";
		}else{
			return "loginfailure";
		}
	}
}
