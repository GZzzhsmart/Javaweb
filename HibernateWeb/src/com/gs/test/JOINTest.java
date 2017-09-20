package com.gs.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.gs.bean.Score1;
import com.gs.bean.Student1;
import com.gs.dao.BaseDAO;

public class JOINTest extends BaseDAO {
	
	@SuppressWarnings({"unchecked" })
	public void testJOIN() {
		Session session = sessionFactory.openSession();
		// 如果使用这种情况，则多方最好不要再关联到其他的一方
		Query query = session.createQuery("from Student1 stu join stu.scores");
		List<Object[]> list = query.list();
		if (list.size() > 0) {
			for (Object[] objArray : list) {
				Student1 stu = (Student1) objArray[0];
				Score1 s = (Score1) objArray[1];
				System.out.println(stu.getName() + ", " + s.getScore() + ", " + s.getId());
			}
		}
		session.close(); 
	}
	
	public static void main(String[] args) {
		JOINTest jt = new JOINTest();
		jt.testJOIN();
	}

}
