package com.ht.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alibaba.fastjson.JSON;
import com.ht.base.BaseDAO;
import com.ht.base.HibernateSessionFactory;
import com.ht.vo.DepVo;
import com.ht.vo.EmployeeVo;

public class DepAction {

	private BaseDAO baseDAO;
	private List<DepVo> depList;
	private DepVo newDep;
	private DepVo dep;
	private List<EmployeeVo> empData;
	public DepAction() {
		baseDAO = new BaseDAO();
	}
	public String init() throws Exception{
		load();
		return "input";
	}
	//初始化父部门下拉框
	private void load(){
		String sql = "from DepVo";
		depList = baseDAO.find(sql);
	}
	public String save() throws Exception{
		newDep.setDep(dep);
		baseDAO.saveOrUpdate(newDep);
		return "list";
	}
	public String list() throws Exception{
		load();
		return "success";
	}
	public String update() throws Exception{
		load();
		newDep = (DepVo)baseDAO.get(DepVo.class, newDep.getDeptid());
		dep = newDep.getDep();
		return "input";
	}
	public String empList() throws Exception{
		String sql = " from EmployeeVo e where e.dep.deptid="+dep.getDeptid();
		empData = baseDAO.find(sql);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		for(int i =0;i<empData.size();i++){
			empData.get(i).setDep(null);
		}
		String data = JSON.toJSONString(empData);
		System.out.println(data);
		out.println(data);
		out.flush();
		out.close();
		return null;
	}
	public static void main1(String[] args) {
		/*
		DepVo dep = new DepVo();
		dep.setDeptname("市场部");
		dep.setPid(5);
		/*
		EmployeeVo emp = new EmployeeVo();
		emp.setBirthday(new Date());
		emp.setDegree("本科");
		emp.setEmpname("小智");
		emp.setMajor("软件工程");
		emp.setMobile("17370134013");
		emp.setSchool("武汉大学");
		emp.setSex("男");
		emp.setDep(dep);
		
		EmployeeVo emp2 = new EmployeeVo();
		emp2.setBirthday(new Date());
		emp2.setDegree("本科");
		emp2.setEmpname("小芳");
		emp2.setMajor("软件工程");
		emp2.setMobile("13888888888");
		emp2.setSchool("复旦大学");
		emp2.setSex("女");
		emp2.setDep(dep);
		//为部门添加2个员工
		dep.getEmployees().add(emp);
		dep.getEmployees().add(emp2);
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(dep);
		tx.commit();
		session.close();
		*/
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		EmployeeVo emp = (EmployeeVo)session.get(EmployeeVo.class, 1);
		System.out.println("姓名="+emp.getEmpname());
		System.out.println("部门="+emp.getDep().getDeptname());
		tx.commit();
		session.close();
		System.out.println("部门="+emp.getDep().getDeptname());
		/*
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String sql = "from EmployeeVo e join fetch e.dep where e.empid=8";
		Query query = session.createQuery(sql);
		List list = query.list();
		EmployeeVo emp = (EmployeeVo)list.get(0);
		tx.commit();
		session.close();
		System.out.println("姓名="+emp.getEmpname());
		System.out.println("部门="+emp.getDep().getDeptname());
		System.out.println("登录名称="+emp.getAccount().getUsername());
		*/
	}
	
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		DepVo dep = (DepVo)session.get(DepVo.class, 1);
		System.out.println("部门名称="+dep.getDeptname());
		tx.commit();
		session.close();
		DepVo parentDep = dep.getDep();
		if(parentDep!=null){
			System.out.println("父部门名称="+dep.getDep().getDeptname());
		}
		if(dep.getChildDepts().size()>0){
			Set<DepVo> set = dep.getChildDepts();
			Iterator<DepVo> it = set.iterator();
			while(it.hasNext()){
				DepVo d = it.next();
				System.out.println("子部门编号="+d.getDeptid()+",子部门名称="+d.getDeptname()+",父部门名称="+d.getDep().getDeptname());
				Set<EmployeeVo> empSet = d.getEmployees();
				Iterator<EmployeeVo> it2 = empSet.iterator();
				while(it2.hasNext()){
					EmployeeVo emp = it2.next();
					System.out.println("empid="+emp.getEmpid()+",empname="+emp.getEmpname());
				}
			}
		}
	}

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public List<DepVo> getDepList() {
		return depList;
	}

	public void setDepList(List<DepVo> depList) {
		this.depList = depList;
	}

	public DepVo getNewDep() {
		return newDep;
	}

	public void setNewDep(DepVo newDep) {
		this.newDep = newDep;
	}

	public DepVo getDep() {
		return dep;
	}

	public void setDep(DepVo dep) {
		this.dep = dep;
	}

	public List<EmployeeVo> getEmpData() {
		return empData;
	}

	public void setEmpData(List<EmployeeVo> empData) {
		this.empData = empData;
	}
}
