package com.gs.dao;

import org.hibernate.Session;

import com.gs.bean.Employee;

public class EmployeeDAOImpl extends BaseDAO 	implements EmployeeDAO {

	@Override
	public Employee queryById(int id) {
		Session session = sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, id);
		session.close();
		return emp;
	}

}
