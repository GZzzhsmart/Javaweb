package Test;

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
import com.ht.base.PageBean;
import com.ht.base.PageService;
import com.ht.base.PageServiceImpl;
import com.ht.base.PagingBean;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{

	PageService p = new PageServiceImpl();
	BaseDAO base = new BaseDAO();
	private int studid;
	private int page;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	//新增保存
	public String save()throws Exception{
		base.save(stud);
		return SUCCESS;
	}
	//学生列表
	public String list()throws Exception{
//		studentList = new BaseDAO().findAllStud();
//		paginglist();
		
		//使用hibernate技术实现分页，每页显示3条记录
		String hql = "from StudentVo";
		PageBean pageBean=p.getStudentVoPageBean(3, page);
		studentList = base.queryByPage(hql, pageBean.getCurrentPageOffset(3, pageBean.getCurPage(page)), 3);
		request.setAttribute("pageBean", pageBean);
		return INPUT;
	}
	//删除学生
	public String del()throws Exception{
		base.delStud(studid);
		return SUCCESS;
	}
	//修改学生信息
	public String update()throws Exception{
		stud = base.StudUpdate(studid);
		return "update";
	}
	//保存修改信息
	public String updateSave()throws Exception{
		base.studUpdateSave(stud);
		return SUCCESS;
	}
	//合法性验证
	public void validateAdd() {
		if(stud==null){
			addFieldError("studid","请输入学号");
			return;
		}
		if(stud.getStudname()==null || stud.getStudname().equals("")){
			addFieldError("studname","请输入姓名");
		}
		if(stud.getAge()<=10 || stud.getAge()>=150){
			addFieldError("age", "年龄必须是1到150之间");
		}
		if(stud.getCardid()==null || stud.getCardid().equals("")){
			addFieldError("cardno", "请输入身份证号");
			return;
		}
		if(stud.getCardid().length()!=18){
			addFieldError("cardid", "身份证号必须为18位");
		}
		if(stud.getSex()==null || stud.getSex().equals("")){
			addFieldError("sex","请输入性别");
		}
	}
	
	//分页
//	public String paginglist() throws IOException{
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		PagingBean page = new PagingBean();
//		page.setPagebarsum(base.sum("select count(*) from stud"));
//		String currentpage = request.getParameter("currentpage");
//		String handle = request.getParameter("handle");
//		if(currentpage==null || currentpage.equals("")){
//			page.setCurrentpage(1);
//		}else {
//			page.setCurrentpage(Integer.parseInt(currentpage));
//		}
//		if(handle==null || handle.equals("")){
//			page.setHandle("firstpage");
//		}else {
//			page.setHandle(handle);
//		}
//		List<StudentVo> studentList = base.studentlist(page.getPagebarsize(), page.getStarlocal());
//		request.setAttribute("pager", page);
//		request.setAttribute("studentList",studentList);
//		return SUCCESS;
//	}
}
