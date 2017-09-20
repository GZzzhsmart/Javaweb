package com.gs.test;

import java.util.Set;

import org.junit.Test;

import com.gs.bean.Course1;
import com.gs.bean.Score1;
import com.gs.bean.Student1;
import com.gs.dao.Course1DAO;
import com.gs.dao.Course1DAOImpl;
import com.gs.dao.Student1DAO;
import com.gs.dao.Student1DAOImpl;

import junit.framework.TestCase;

public class StudentTest1 extends TestCase {

	private Student1DAO sDAO;
	private Course1DAO cDAO;
	
	@Override
	protected void setUp() throws Exception {
		sDAO = new Student1DAOImpl();
		cDAO = new Course1DAOImpl();
	}

	@Test
	public void testQueryById() {
		Student1 stu = sDAO.queryById(2);
		System.out.println(stu.getName());
		Set<Score1> s = stu.getScores();
		for (Score1 ss : s) {
			System.out.println(ss.getScore());
			System.out.println(ss.getCourse().getName());
		}
	}
	
	@Test
	public void testQueryByIdCourse() {
		Course1 c = cDAO.queryById(1);
		System.out.println(c.getName());
		Set<Score1> s = c.getScores();
		for (Score1 ss : s) {
			System.out.println(ss.getScore());
			System.out.println(ss.getStu().getName());
		}
	}
}
