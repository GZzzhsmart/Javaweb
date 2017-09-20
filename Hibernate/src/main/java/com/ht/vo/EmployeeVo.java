package com.ht.vo;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVo implements Serializable{

	private int empid;
	private String empname;
	private int depid;
	private String sex;
	private Date birthday;
	private String school;
	private String major;
	private String degree;
	private String mobile;
	private String username;
	private String passwd;
	private String status;
	//定义一个AccountVo的变量，以便设置一对一的关系
	private AccountVo account;
	//配置多对一
	private DepVo dep;
	
	public EmployeeVo() {
		
	}
	public EmployeeVo(int empid,String empname,String school){
		this.empid = empid;
		this.empname = empname;
		this.school = school;
	}
	public EmployeeVo(int empid,String empname,String school,String major){
		this.empid = empid;
		this.empname = empname;
		this.school = school;
		this.major = major;
	}
	public DepVo getDep() {
		return dep;
	}
	public void setDep(DepVo dep) {
		this.dep = dep;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public AccountVo getAccount() {
		return account;
	}
	public void setAccount(AccountVo account) {
		this.account = account;
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
	
}
