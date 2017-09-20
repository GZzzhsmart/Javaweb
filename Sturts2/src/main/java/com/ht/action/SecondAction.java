package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;

public class SecondAction extends ActionSupport{

	private String secondname;

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("secondname="+secondname);
		return SUCCESS;
	}
}
