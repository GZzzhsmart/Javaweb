package com.gs.dao;

import org.hibernate.Session;

import com.gs.bean.Course;

public class CourseDAOImpl extends BaseDAO implements CourseDAO {

	@Override
	public Course queryById(int id) {
		Session session = sessionFactory.openSession();
		Course c = (Course) session.get(Course.class, id);
		session.close();
		return c;
	}

}
