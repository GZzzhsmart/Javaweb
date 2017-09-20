package com.gs.test;

import org.junit.Test;

import com.gs.bean.Course;
import com.gs.dao.CourseDAO;
import com.gs.dao.CourseDAOImpl;

import junit.framework.TestCase;

public class CourseDAOTest extends TestCase {

	private CourseDAO cDAO;
	
	@Override
	protected void setUp() throws Exception {
		cDAO = new CourseDAOImpl();
	}

	@Test
	public void testQueryById() {
		Course c = cDAO.queryById(1);
		System.out.println(c.getName());
	}
	
}
