package com.gs.dao;


import org.hibernate.Session;

import com.gs.bean.Student1;

public class Student1DAOImpl extends BaseDAO implements Student1DAO {

	@Override
	public Student1 queryById(int id) {
		Session session = sessionFactory.openSession();
		Student1 stu = (Student1) session.get(Student1.class, id);
		// session.close();
		return null;
	}

}
