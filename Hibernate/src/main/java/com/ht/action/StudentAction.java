package com.ht.action;

import com.ht.base.BaseDAO;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	private BaseDAO baseDAO;
	private StudentVo stud;
	public StudentAction() {
		baseDAO = new BaseDAO();
	}
	public StudentVo getStud() {
		return stud;
	}
	public void setStud(StudentVo stud) {
		this.stud = stud;
	}
	public String save() throws Exception{
		//新增或者修改
		baseDAO.saveOrUpdate(stud);
		return SUCCESS;
	}
	//获取要修改的记录
	public String get() throws Exception{
		stud = (StudentVo)baseDAO.get(StudentVo.class, stud.getStudid());
		return INPUT;
	}
	//删除
	public String del() throws Exception{
		baseDAO.del(stud);
		return SUCCESS;
	}
}
