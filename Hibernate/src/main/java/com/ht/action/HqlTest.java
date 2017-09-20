package com.ht.action;

import java.util.List;

import com.ht.base.BaseDAO;
import com.ht.vo.DepVo;
import com.ht.vo.EmployeeVo;
import com.ht.vo.StudentVo;

public class HqlTest {

	/**
	 * Hql查询
	 * */
	public void Hql1(){
		//查询员工资料
//		String sql ="from EmployeeVo";
//		String sql ="from EmployeeVo e where e.empname='李四'";
//		String sql ="from EmployeeVo e where e.empname=?";
//		String sql ="from EmployeeVo e where e.sex=? and e.empname=?";
		//设置参数名称，与顺序无关
//		String sql ="from EmployeeVo e where e.sex=:psex and e.empname=:pname";
		String sql = "from EmployeeVo";
		BaseDAO base = new BaseDAO();
		List<EmployeeVo> list = base.find(sql);
//		List<EmployeeVo> list = base.find(sql,"男","李四");
		System.out.println("size="+list.size());
		for (EmployeeVo emp : list) {
			System.out.println("姓名="+emp.getEmpname());
			if(emp.getAccount()!=null)
				System.out.println("登录账号="+emp.getAccount().getUsername());
			System.out.println("所属部门="+emp.getDep().getDeptname());
		}
	}
	
	public void Hql2(){
		String sql ="from EmployeeVo e where e.sex=:psex and e.empname=:pname";
		BaseDAO base = new BaseDAO();
		List<EmployeeVo> list = base.find(sql,"男","李四");
		System.out.println("size="+list.size());
		for (EmployeeVo emp : list) {
			System.out.println("姓名="+emp.getEmpname());
			if(emp.getAccount()!=null)
				System.out.println("登录账号="+emp.getAccount().getUsername());
			System.out.println("所属部门="+emp.getDep().getDeptname());
		}
	}
	
	public void Hql3(){
		String sql ="select empid,empname,school,major from EmployeeVo e where e.sex=:psex and e.empname=:pname";
		BaseDAO base = new BaseDAO();
		List list = base.find(sql,"男","李四");
		System.out.println("size="+list.size());
		for (Object emp : list) {
			Object[] objs = (Object[])emp;
			System.out.println("empid="+objs[0]+",empname="+objs[1]+",school="+objs[2]+",major="+objs[3]);
		}
	}
	
	//通过构造函数取值
	public void Hql4(){
		String sql = "select new EmployeeVo(empid,empname,school,major) from EmployeeVo e where e.sex=:psex and e.empname=:pname";
		BaseDAO base = new BaseDAO();
		List<EmployeeVo> list = base.find(sql,"男","张三");
		System.out.println("size="+list.size());
		for (EmployeeVo emp : list) {
			System.out.println("empid="+emp.getEmpid()+",empname="+emp.getEmpname()+",school="+emp.getSchool());
		}
	}
	
	public void Hql5(){
		String sql = "from EmployeeVo e join fetch e.dep d where d.deptid=2 ";
		BaseDAO base = new BaseDAO();
		List<EmployeeVo> list = base.find(sql);
		System.out.println("size="+list.size());
		for (EmployeeVo emp : list) {
			System.out.println("empid="+emp.getEmpid()+",empname="+emp.getEmpname()+",school="+emp.getSchool());
		}
	}
	
	public void Hql6(){
		String sql = "from EmployeeVo e join e.dep d where d.deptid=2";
		BaseDAO base = new BaseDAO();
		List list = base.find(sql);
		System.out.println("size="+list.size());
		for (Object obj : list) {
			Object[] objs = (Object[])obj;
			EmployeeVo emp =(EmployeeVo)objs[0];
			DepVo d =(DepVo)objs[1];
			System.out.println("empid="+emp.getEmpid()+",empname="+emp.getEmpname()+",school="+emp.getSchool());
		}
	}
	
	//用聚合函数做统计
	public void Hql7(){
//		String sql = "select count(e.empid) from EmployeeVo e join e.dep d where d.deptid=2";
//		String sql ="select count(s.studid) from StudentVo s";
//		String sql ="select max(s.age) from StudentVo s";
		String sql ="select min(s.age),avg(s.age),count(s.studid) from StudentVo s";
		BaseDAO base = new BaseDAO();
		List list = base.find(sql);
		Object [] arr = (Object[])list.get(0);
		System.out.println("最小年龄："+arr[0]);
		System.out.println("平均年龄："+arr[1]);
		System.out.println("学生人数："+arr[2]);
		System.out.println("ok");
	}
	
	//子查询
	public void Hql8(){
		String sql = "from StudentVo s where s.age>(select avg(s1.age) from StudentVo s1)";
		BaseDAO base = new BaseDAO();
		List<StudentVo> list = base.find(sql);
		System.out.println("size="+list.size());
		for (StudentVo s : list) {
			System.out.println("studid="+s.getStudid()+",studname="+s.getStudname()+",age="+s.getAge());
		}
	}
	
	public static void main(String[] args) {
		HqlTest test = new HqlTest();
//		test.Hql1();
//		test.Hql2();
//		test.Hql3();
//		test.Hql4();
//		test.Hql5();
//		test.Hql6();
//		test.Hql7();
		test.Hql8();
	}
}
