package com.ht.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import com.ht.base.BaseDAO;
import com.ht.base.HibernateSessionFactory;
import com.ht.base.HibernateUtil;
import com.ht.base.PageBean;
import com.ht.base.PageObject;
import com.ht.base.PageService;
import com.ht.base.PageServiceImpl;
import com.ht.vo.AccountVo;
import com.ht.vo.DepVo;
import com.ht.vo.EmployeeVo;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport{

	private EmployeeVo emp;
	private int empid;
	private List<EmployeeVo> empList;
	private List<DepVo> depList;
	private AccountVo acc;
	private BaseDAO base;
	private DepVo dep;
	private int page;
	private String sdate;
	private String edate;
	private PageObject pager = new PageObject();
	PageService p = new PageServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	public EmployeeAction() {
		base = new BaseDAO();
	}
	//新增
	public String init() throws Exception{
		String sql = "from DepVo";
		depList = base.find(sql);
		return "update";
	}
	public String saveOrUpdate()throws Exception{
		emp.setDep(dep);
		acc.setEmployee(emp);
		base.saveOrUpdate(emp);
		base.saveOrUpdate(acc);
		return SUCCESS;
	}
	//删除
	public String del()throws Exception{
		acc = new AccountVo();
		acc.setEmpid(emp.getEmpid());
		acc.setEmployee(emp);
		emp.setAccount(acc);
		base.del(emp);
		return SUCCESS;
	}
	
	//员工列表
	public String list()throws Exception{
		PageBean pageBean=p.getEmployeeVoPageBean(3, page);
		String hql = "from EmployeeVo e where 1=1";
		if(emp!=null && !emp.getEmpname().equals("")){
			hql += " and e.empname='"+emp.getEmpname() +"'";
		}
		empList = base.queryByPage(hql, pageBean.getCurrentPageOffset(3, pageBean.getCurPage(page)), 3);
		request.setAttribute("pageBean", pageBean);
		return INPUT;
	}
	
	//离线查询
	public String listByDetach() throws Exception{
		//定义DetachedCriteria
		DetachedCriteria dc = DetachedCriteria.forClass(EmployeeVo.class);
		dc.createAlias("account", "acc");
		if(emp!=null){
			if(emp.getEmpname()!=null && !emp.getEmpname().equals("")){
				//模糊查询
				dc.add(Restrictions.like("empname", emp.getEmpname(),MatchMode.ANYWHERE));
			}
			if(acc.getUsername()!=null && !acc.getUsername().equals("")){
				//关联account表的查询条件
				dc.add(Restrictions.eq("acc.username", acc.getUsername()));

			}
			if(sdate!=null && edate!=null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d1 = sdf.parse(sdate);
				Date d2 = sdf.parse(edate);
				dc.add(Restrictions.between("birthday", d1, d2));
				System.out.println(sdate);
				System.out.println(edate);
			}
		}
//		empList = baseDAO.findByDetach(dc);
		//执行聚合函数
		dc.setProjection(Projections.rowCount());
		int cnt = base.getCount(dc);
		pager.setRecordCount(cnt);
		if(pager.getOpr().equals("first")){ //首页
			pager.setCurrentPage(1);
		}else if(pager.getOpr().equals("last")){//末页
			pager.setCurrentPage(pager.getPageCount());
		}else if(pager.getOpr().equals("piror")){//上一页
			if(pager.getCurrentPage()>1){
				pager.setCurrentPage(pager.getCurrentPage()-1);
			}else {
				pager.setCurrentPage(1);
			}
		}else if(pager.getOpr().equals("next")){ //下一页
			if(pager.getCurrentPage()<pager.getPageCount()){
				pager.setCurrentPage(pager.getCurrentPage()+1);
			}else{
				pager.setCurrentPage(pager.getPageCount());
			}
		}else{
			pager.setCurrentPage(1);
		}
		pager.setOpr(pager.getOpr());
		//取消Projection，查询明细
		dc.setProjection(null);
		//分页处理
		int startpos = (pager.getCurrentPage()-1)*pager.getPageSize();
		empList = base.findPageByDetach(dc, startpos, pager.getPageSize());
		return LOGIN;
	}
	//修改
	public String get() throws Exception{
		emp = (EmployeeVo)base.get(EmployeeVo.class, emp.getEmpid());
		acc = emp.getAccount();
		dep = emp.getDep();
		String sql = "from DepVo";
		depList = base.find(sql);
		return "update";
	}
	
	public EmployeeVo getEmp() {
		return emp;
	}
	public void setEmp(EmployeeVo emp) {
		this.emp = emp;
	}
	public AccountVo getAcc() {
		return acc;
	}
	public void setAcc(AccountVo acc) {
		this.acc = acc;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public BaseDAO getBase() {
		return base;
	}
	public void setBase(BaseDAO base) {
		this.base = base;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public List<EmployeeVo> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmployeeVo> empList) {
		this.empList = empList;
	}
	public PageService getP() {
		return p;
	}
	public void setP(PageService p) {
		this.p = p;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public DepVo getDep() {
		return dep;
	}
	public void setDep(DepVo dep) {
		this.dep = dep;
	}
	public List<DepVo> getDepList() {
		return depList;
	}
	public void setDepList(List<DepVo> depList) {
		this.depList = depList;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public PageObject getPager() {
		return pager;
	}
	public void setPager(PageObject pager) {
		this.pager = pager;
	}
	
	
}
