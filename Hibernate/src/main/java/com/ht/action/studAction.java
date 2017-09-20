package com.ht.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Test.BaseDAO;
import com.ht.base.HibernateUtil;
import com.ht.base.PagingBean;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class studAction extends ActionSupport{

	BaseDAO base = new BaseDAO();
	private int studid;
	private StudentVo stud;
	private List<StudentVo> studentList;
	private int currentpage;
	private String handle;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public StudentVo getStud() {
		return stud;
	}
	public void setStud(StudentVo stud) {
		this.stud = stud;
	}
	public List<StudentVo> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<StudentVo> studentList) {
		this.studentList = studentList;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	//新增保存
	public String save()throws Exception{
		new BaseDAO().save(stud);
		return SUCCESS;
	}
	//学生列表
	public String list()throws Exception{
		studentList = new BaseDAO().findAllStud();
		paginglist();
		return INPUT;
	}
	//删除学生资料
	public String del()throws Exception{
		new BaseDAO().delStud(studid);
		return SUCCESS;
	}
	//修改学生信息
	public String update()throws Exception{
		stud = new BaseDAO().StudUpdate(studid);
		return "update";
	}
	public String updateSave()throws Exception{
		new BaseDAO().studUpdateSave(stud);
		return SUCCESS;
	}
	
	//分页
	public String paginglist() throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		PagingBean page = new PagingBean();
		page.setPagebarsum(base.sum("select count(*) from stud"));
		String currentpage = request.getParameter("currentpage");
		String handle = request.getParameter("handle");
		if(currentpage==null || currentpage.equals("")){
			page.setCurrentpage(1);
		}else {
			page.setCurrentpage(Integer.parseInt(currentpage));
		}
		if(handle==null || handle.equals("")){
			page.setHandle("firstpage");
		}else {
			page.setHandle(handle);
		}
		List<StudentVo> studentList = base.studentlist(page.getPagebarsize(), page.getStarlocal());
		request.setAttribute("pager", page);
		request.setAttribute("studentList",studentList);
		return SUCCESS;
	}
	
}
