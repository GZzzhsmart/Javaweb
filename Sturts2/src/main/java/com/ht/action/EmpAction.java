package com.ht.action;

import com.ht.vo.EmpVo;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport{

	/*
	 * token标签的使用步骤:
	 * 1.在需要控制的页面加入<s:token/>标签
	 * 2.必须在struts.xml文件的action配置中增加2个拦截器
	 * 	<interceptor-ref name="defaultStack"></interceptor-ref>
		<interceptor-ref name="token"></interceptor-ref>
	   3.必须增加一个result，同时指明出错的页面
	   <result name="invalid.token">error.jsp</result>
	 * 
	 * */
	private EmpVo emp;

	public EmpVo getEmp() {
		return emp;
	}

	public void setEmp(EmpVo emp) {
		this.emp = emp;
	}
	public String add() throws Exception{
		
		return INPUT;
	}
}
