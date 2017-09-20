package com.ht.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class PreparedAction extends ActionSupport implements Preparable{

	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void prepare() throws Exception {
		System.out.println("prepare函数：msg="+msg);
	}

	@Override
	public String execute() throws Exception {
		System.out.println("execute函数：msg="+msg);
		return null;
	}
	
}
