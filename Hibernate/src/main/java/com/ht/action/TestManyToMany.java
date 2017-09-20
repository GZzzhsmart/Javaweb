package com.ht.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.ht.base.BaseDAO;
import com.ht.vo.CourseVo;
import com.ht.vo.StudentVo;

public class TestManyToMany {

	public void add(){
		BaseDAO base = new BaseDAO();
		//取学生的数据
		StudentVo s = (StudentVo)base.get(StudentVo.class, 1001);
		//查询所有课程资料
		DetachedCriteria dc = DetachedCriteria.forClass(CourseVo.class);
		dc.addOrder(Order.asc("courseid"));
		List<CourseVo> courseList = base.findByDetach(dc);
		for (CourseVo courseVo : courseList) {
			s.getCourseSet().add(courseVo);
		}
		base.saveOrUpdate(s);
		System.out.println("ok");
	}
	
	public void search(){
		BaseDAO base = new BaseDAO();
		//取学生数据
		StudentVo s = (StudentVo)base.get(StudentVo.class, 1001);
		System.out.println("学生："+s.getStudname()+"选课情况如下：");
		Set<CourseVo> set = s.getCourseSet();
		Iterator<CourseVo> it = set.iterator();
		while(it.hasNext()){
			CourseVo c = it.next();
			System.out.println(c.getCoursename());
		}
	}
	
	public static void main(String[] args) {
		TestManyToMany test = new TestManyToMany();
//		test.add();
		test.search();
	}
}
