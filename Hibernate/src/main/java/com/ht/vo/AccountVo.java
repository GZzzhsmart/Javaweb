package com.ht.vo;

import java.io.Serializable;

public class AccountVo implements Serializable{

	private int empid;
	private String username;
	private String passwd;
	private String status;
	//定义一个EmployeeVo的变量，以便设置一对一的关系
	private EmployeeVo employee;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmployeeVo getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeVo employee) {
		this.employee = employee;
	}
}
