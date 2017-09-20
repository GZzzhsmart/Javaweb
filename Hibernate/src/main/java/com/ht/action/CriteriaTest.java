package com.ht.action;

import java.util.List;

import com.ht.base.BaseDAO;
import com.ht.vo.EmployeeVo;
import com.ht.vo.StudentVo;

public class CriteriaTest {

	/**
	 * QBC查询
	 * */
	public void QBC1(){
		BaseDAO base = new BaseDAO();
		//查询员工资料
		List list = base.find(EmployeeVo.class);
		for (Object object : list) {
			EmployeeVo emp = (EmployeeVo)object;
			System.out.println("empid="+emp.getEmpid()+",empname="+emp.getEmpname()+",school="+emp.getSchool());
		}
	}
	
	public void QBC2(){
		BaseDAO base = new BaseDAO();
		//查询学生资料
		List list = base.find(StudentVo.class);
		for (Object object : list) {
			StudentVo s = (StudentVo)object;
			System.out.println("studid="+s.getStudid()+",studname="+s.getStudname()+",age="+s.getAge());
		}
	}
	
	public void QBC3(){
		BaseDAO base = new BaseDAO();
		//查询员工资料
		List list = base.find();
		for (Object object : list) {
			EmployeeVo emp = (EmployeeVo)object;
			System.out.println("empid="+emp.getEmpid()+",empname="+emp.getEmpname()+",school="+emp.getSchool());
		}
	}
	public static void main(String[] args) {
		CriteriaTest test = new CriteriaTest();
//		test.QBC1();
//		test.QBC2();
		test.QBC3();
	}
}
