package com.gs.test;

import org.junit.Test;

import com.gs.bean.Course;
import com.gs.bean.Student;
import com.gs.dao.ScoreDAO;
import com.gs.dao.ScoreDAOImpl;
import com.gs.dao.StudentDAO;
import com.gs.dao.StudentDAOImpl;

import junit.framework.TestCase;

public class StudentDAOTest extends TestCase {

	private StudentDAO stuDAO;
	private ScoreDAO sDAO;
	
	@Override
	protected void setUp() throws Exception {
		stuDAO = new StudentDAOImpl();
		sDAO = new ScoreDAOImpl();
	}

	@Test
	public void testQueryById() {
		Student stu = stuDAO.queryById(1);
		System.out.println(stu.getName());
		for (Course c : stu.getCourses()) {
			System.out.println(c.getName());
			System.out.println(sDAO.query(1, c.getId()).getScore());
		}
	}
	
}
