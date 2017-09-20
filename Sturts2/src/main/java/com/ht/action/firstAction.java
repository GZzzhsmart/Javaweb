package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class firstAction extends ActionSupport{

	private String firstname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("firstname="+firstname);
		return SUCCESS;
	}
}
