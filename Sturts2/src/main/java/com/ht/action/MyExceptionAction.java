package com.ht.action;

import com.ht.vo.EmpVo;
import com.opensymphony.xwork2.ActionSupport;

public class MyExceptionAction extends ActionSupport{

	private EmpVo emp;

	public EmpVo getEmp() {
		return emp;
	}

	public void setEmp(EmpVo emp) {
		this.emp = emp;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("empno="+emp.getEmpNo());
		return LOGIN;
	}
}
