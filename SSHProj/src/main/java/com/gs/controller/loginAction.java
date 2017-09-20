package com.gs.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gs.pojo.BaseDAO;
import com.gs.pojo.Agency;
import com.gs.pojo.EncryptUtil;
import com.gs.pojo.UUIDUtil;
import com.opensymphony.xwork2.ActionSupport;



public class loginAction extends ActionSupport{

	private Agency agency;
	private BaseDAO baseDAO = new BaseDAO();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
	public Agency getAgency() {
		return agency;
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	//登录
	public String login()throws Exception{
		Agency agency = new Agency();
		agency.setAgency_leader(agency.getAgency_leader());
		agency.setAgency_pwd(agency.getAgency_pwd());
		if(this.agency.getAgency_leader()==null){
			return "success";
		}
		if((this.agency.getAgency_leader()==null) || this.agency.getAgency_leader().equals("")){
			addFieldError("agency_leader", "请输入用户名");
			return "success";
		}
		if((this.agency.getAgency_pwd()==null) || this.agency.getAgency_pwd().equals("")){
			addFieldError("agency_pwd", "请输入登录密码");
			return "success";
		}
		DetachedCriteria dc = DetachedCriteria.forClass(Agency.class);
		dc.add(Restrictions.eq("agency_leader", this.agency.getAgency_leader().trim()));
		dc.add(Restrictions.eq("agency_pwd", this.agency.getAgency_pwd().trim()));
		if(this.agency.getAgency_leader().equals(agency.getAgency_leader()) || this.agency.getAgency_pwd().equals(agency.getAgency_pwd())){
			return "login";
		}
		return "login";
	}
	
	//注册
	public String add()throws Exception{
		String agency_id = request.getParameter("agency_id");
		agency_id = UUIDUtil.uuid();
		agency.setAgency_id(agency_id);
		agency.setAgency_name(agency.getAgency_name());
		agency.setAgency_email(agency.getAgency_email());
		agency.setAgency_leader(agency.getAgency_leader());
		agency.setAgency_phone(agency.getAgency_phone());
		agency.setAgency_tel(agency.getAgency_tel());
		agency.setAgency_address(agency.getAgency_address());
		agency.setAgency_logo("images/1.png");
		agency.setAgency_intro(agency.getAgency_intro());
		agency.setCreated_time(new Date().toLocaleString());
		agency.setAgency_pwd(EncryptUtil.md5Encrypt(agency.getAgency_pwd()));
		//默认为N未审核
		agency.setChecked_status("N");
		//默认为0未激活
		agency.setAgency_status("0");
		System.out.println(agency);
		baseDAO.save(agency);
		return "add";
	}
	
	public void validateSave(){
		if((this.agency.getAgency_leader()==null) || this.agency.getAgency_leader().equals("")){
			addFieldError("agency_leader", "请输入用户名");
			return;
		}
		if((this.agency.getAgency_pwd()==null) || this.agency.getAgency_pwd().equals("")){
			addFieldError("agency_pwd", "请输入登录密码");
			return;
		}
		
	}
	
	
	//修改密码
//	public String pwd()throws Exception{
//		Agency a  = (Agency)this.base.findObjByID(Agency.class, Integer.valueOf(this.agency.getAgency_id()));
//		if (!(a.getAgency_pwd().equals(this.agency.getAgency_pwd()))) {
//			addFieldError("password", "旧密码错误");
//			return "pwd";
//		}
//		a.setAgency_pwd(this.agency.getAgency_pwd());
//		this.base.update(a);
//		addFieldError("password", "恭喜您，修改密码成功！");
//		return "pwd";
//	}
}
