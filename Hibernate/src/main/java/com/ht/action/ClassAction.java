package com.ht.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ht.base.BaseDAO;
import com.ht.base.HibernateSessionFactory;
import com.ht.base.HibernateUtil;
import com.ht.base.PageBean;
import com.ht.base.PageService;
import com.ht.base.PageServiceImpl;
import com.ht.vo.ClassesVo;
import com.ht.vo.EmployeeVo;
import com.ht.vo.MajorVo;
import com.opensymphony.xwork2.ActionSupport;

public class ClassAction extends ActionSupport{

	BaseDAO base = new BaseDAO();
	private int page;
	private List<MajorVo> majorList;
	private ClassesVo clazz;
	private List<ClassesVo> clsList;
	PageService p = new PageServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	public List<MajorVo> getMajorList() {
		return majorList;
	}

	public void setMajorList(List<MajorVo> majorList) {
		this.majorList = majorList;
	}

	public ClassesVo getClazz() {
		return clazz;
	}

	public void setClazz(ClassesVo clazz) {
		this.clazz = clazz;
	}

	public List<ClassesVo> getClsList() {
		return clsList;
	}

	public void setClsList(List<ClassesVo> clsList) {
		this.clsList = clsList;
	}

	public void load(){
		majorList = base.find("from MajorVo");
	}
	public String init() throws Exception{
		load();
		return INPUT;
	}
	public String save() throws Exception{
		base.saveOrUpdate(clazz);
		return "list";
	}
	public String update() throws Exception{
		load();
		clazz = (ClassesVo)base.get(ClassesVo.class, clazz.getClassid());
		return INPUT;
	}
	public String list() throws Exception{
		PageBean pageBean=p.getClassesVoPageBean(3, page);
		request.setAttribute("pageBean", pageBean);
		String hql = "from ClassesVo";
		clsList = base.queryByPage(hql, pageBean.getCurrentPageOffset(3, pageBean.getCurPage(page)), 3);
		return SUCCESS;
	}
	
	public String del()throws Exception{
		base.del(clazz);
		return "list";
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public static void main(String[] args) {
		BaseDAO base = new BaseDAO();
//		ClassesVo clz = (ClassesVo)base.get(ClassesVo.class, 1);
//		System.out.println(clz.getClassname());
//		System.out.println(clz.getMajor().getMajorname());
		List<MajorVo> majorList = base.find("from MajorVo c join fetch c.classes");
//		List<MajorVo> majorList = base.find("from MajorVo");
		for(int i=0;i<majorList.size();i++){
			MajorVo major = majorList.get(i);
			System.out.println("id="+major.getMajorid()+",name="+major.getMajorname());
			Set<ClassesVo> set = major.getClasses();
			Iterator<ClassesVo> it = set.iterator();
			while(it.hasNext()){
				ClassesVo clszz = it.next();
				System.out.println("班级编号="+clszz.getClassid()+",班级名称="+clszz.getClassname());
				
			}
		}
	}
}
