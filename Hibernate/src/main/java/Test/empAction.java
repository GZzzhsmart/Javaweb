package Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.ht.action.studAction;
import com.ht.base.BaseDAO;
import com.ht.base.HibernateSessionFactory;
import com.ht.base.HibernateUtil;
import com.ht.base.PageBean;
import com.ht.base.PageService;
import com.ht.base.PageServiceImpl;
import com.ht.vo.AccountVo;
import com.ht.vo.DepVo;
import com.ht.vo.EmployeeVo;
import com.ht.vo.StudentVo;
import com.opensymphony.xwork2.ActionSupport;

public class empAction extends ActionSupport{

	private EmployeeVo emp;
	private int empid;
	private List<EmployeeVo> empList;
	private List<DepVo> depList;
	private AccountVo acc;
	private BaseDAO base;
	private DepVo dep;
	private int page;
	PageService p = new PageServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	public empAction() {
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
	
	//修改
	public String update() throws Exception{
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
}
