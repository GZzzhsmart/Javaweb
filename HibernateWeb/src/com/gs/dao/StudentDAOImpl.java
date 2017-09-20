package com.gs.dao;

import org.hibernate.Session;

import com.gs.bean.Student;

public class StudentDAOImpl extends BaseDAO implements StudentDAO {

	@Override
	public Student queryById(int id) {
		Session session = sessionFactory.openSession();
		Student stu = (Student) session.get(Student.class, id);
		session.close();
		return stu;
	}

}
