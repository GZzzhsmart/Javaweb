package com.gs.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.gs.bean.Department;
import com.gs.bean.Employee;
import com.gs.dao.DepartmentDAO;
import com.gs.dao.DepartmentDAOImpl;
import com.gs.dao.EmployeeDAO;
import com.gs.dao.EmployeeDAOImpl;

import junit.framework.TestCase;

public class DepartmentDAOTest extends TestCase {
	
	private DepartmentDAO depDAO;
	private EmployeeDAO empDAO;
	
	@Override
	protected void setUp() throws Exception {
		depDAO = new DepartmentDAOImpl();
		empDAO = new EmployeeDAOImpl();
	}
	
	@Test
	public void testQuery() {
		Department dep = depDAO.queryById(1);// 1、查部门，正常的
		System.out.println(dep.getId() + ", " + dep.getName());
		Set<Employee> emps = dep.getEmployees(); // dep.getEmployees();   Hibernate会发送SQL语句到数据库执行查询员工的操作，但是session已经被关闭了
		for (Employee e : emps) {
			System.out.println(e.getName());
		}
	}
	
	@Test
	public void testAdd() {
		Department dept = new Department();
		dept.setName("研发部");
		dept.setDes("高级软件工程师");
		Set<Employee> emps = new HashSet<Employee>();
		Employee e = new Employee();
		e.setDept(dept);
		e.setName("工程师1");
		e.setAge(25);
		Employee e1 = new Employee();
		e1.setName("工程师2");
		e1.setAge(25);
		e1.setDept(dept);
		emps.add(e);
		emps.add(e1);
		dept.setEmployees(emps);
		depDAO.add(dept);
	}
	
	@Test
	public void testQueryEmployee() {
		Employee e = empDAO.queryById(13);
		System.out.println(e.getName());
		System.out.println(e.getDept().getName());
	}
	
	@Test
	public void testDeleteDept() {
		Department dept = new Department();
		dept.setId(2);
		depDAO.delete(dept);
	}
	
	@Test
	public void testQueryByCriteria() {
		depDAO.queryByCriteria();
	}

}
