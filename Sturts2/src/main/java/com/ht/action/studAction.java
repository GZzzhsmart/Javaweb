package com.ht.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.ht.base.BaseDAO;
import com.ht.base.PagingBean;
import com.ht.base.SqlSentenceimp;
import com.ht.vo.ClassesVo;
import com.ht.vo.NationVo;
import com.ht.vo.SVo;
import com.ht.vo.StudVo;
import com.opensymphony.xwork2.ActionSupport;

public class studAction extends ActionSupport{

	SqlSentenceimp sql = new SqlSentenceimp();
	private String order;
	private SVo stud;
	private List<ClassesVo> classList;
	private List<NationVo> nationList;
	private List<SVo> studentList;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public SVo getStud() {
		return stud;
	}
	public void setStud(SVo stud) {
		this.stud = stud;
	}
	public List<ClassesVo> getClassList() {
		return classList;
	}
	public void setClassList(List<ClassesVo> classList) {
		this.classList = classList;
	}
	public List<NationVo> getNationList() {
		return nationList;
	}
	public void setNationList(List<NationVo> nationList) {
		this.nationList = nationList;
	}
	public List<SVo> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<SVo> studentList) {
		this.studentList = studentList;
	}
	@Override
	public String execute() throws Exception {
		init();
		if (order.equals("delete")) {
			sql.delstudent(request.getParameter("sno"));
		}else if (order.equals("update")) {
			stud = sql.findstudent(request.getParameter("sno"));
			return INPUT;
		}else if (order.equals("add")) {
			SVo st = sql.findstudent(stud.getSno()+"");
			if(st.getSno()!=0){
				sql.updatestudent(stud);
				stud=null;
			}else {
				sql.addstud(stud);
				stud=null;
			}
			return LOGIN;
		}
		paginglist();
		return LOGIN;
	}
	public void init() {
		nationList = new ArrayList<NationVo>();
		nationList = sql.nationlist();
		classList = new ArrayList<ClassesVo>();
		classList = sql.classlist();
	}
	public void list(){
		this.studentList=sql.studentlist();
	}
	
	public void paginglist() throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		PagingBean page = new PagingBean();
		page.setPagebarsum(sql.sum("select count(*) from student"));
		String currenpage = request.getParameter("currenpage");
		String handle = request.getParameter("handle");
		if(currenpage==null || currenpage.equals("")){
			page.setCurrentpage(1);
		}else {
			page.setCurrentpage(Integer.parseInt(currenpage));
		}
		if(handle==null || handle.equals("")){
			page.setHandle("firstpage");
		}else {
			page.setHandle(handle);
		}
		request.setAttribute("pager", page);
		studentList = sql.studentlist(page.getPagebarsize(), page.getStarlocal());
//		String  data = JSON.toJSONString(studentList);
//		out.print(data);
		request.setAttribute("studentList",studentList);
	}
}
