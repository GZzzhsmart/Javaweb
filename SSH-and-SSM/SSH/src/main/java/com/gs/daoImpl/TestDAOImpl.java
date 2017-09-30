package com.gs.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gs.common.Pager4EasyUI;
import com.gs.dao.TestDAO;
import com.gs.pojo.Test;
import org.hibernate.query.Query;

import java.util.List;

public class TestDAOImpl implements TestDAO {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Test queryById(String id) {
		Session session = sessionFactory.openSession();
		Test test = (Test)session.get(Test.class,id);
		return test;
	}

	public Pager4EasyUI<Test> queryByPager(Pager4EasyUI<Test> pager) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Test t) {
		Session session = sessionFactory.openSession();
		session.update(t);
	}

	public void add(Test t) {
		Session session = sessionFactory.openSession();
		session.save(t);
	}

	public void valid(String id, String valid) {
		// TODO Auto-generated method stub
		
	}

	public int count() {
		Session session = sessionFactory.openSession();
		Query query = session.createNativeQuery("select count(*) from t_test");
		List list = query.list();
		int cnt = Integer.parseInt(list.get(0).toString());
		return cnt;
	}

}
