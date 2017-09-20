package com.gs.dao;

import org.hibernate.Session;

import com.gs.bean.Course1;

public class Course1DAOImpl extends BaseDAO implements Course1DAO {

	@Override
	public Course1 queryById(int id) {
		Session session = sessionFactory.openSession();
		Course1 c = (Course1) session.get(Course1.class, id);
		// session.close();
		return c;
	}

}
