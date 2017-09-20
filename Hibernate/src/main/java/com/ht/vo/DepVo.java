package com.ht.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DepVo implements Serializable{

	private int deptid;
	private String deptname;
	private int pid;
	//多对一
	private  DepVo dep;
	//一对多
	private Set<DepVo> childDepts = new HashSet<DepVo>();
	//配置一对多
	private Set<EmployeeVo> employees = new HashSet<EmployeeVo>();
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Set<EmployeeVo> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<EmployeeVo> employees) {
		this.employees = employees;
	}
	public DepVo getDep() {
		return dep;
	}
	public void setDep(DepVo dep) {
		this.dep = dep;
	}
	public Set<DepVo> getChildDepts() {
		return childDepts;
	}
	public void setChildDepts(Set<DepVo> childDepts) {
		this.childDepts = childDepts;
	}
}
