package com.gs.dao.impl;

import javax.annotation.Resource;

import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.TestDAO;
import com.gs.pojo.Test;

@SuppressWarnings("unused")
public class TestDAOImpl implements TestDAO {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Test queryById(String id) {
		return null;
	}

	public Pager4EasyUI<Test> queryByPager(Pager4EasyUI<Test> pager) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Test t) {
		// TODO Auto-generated method stub
		
	}

	public void add(Test t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
	}

	public void valid(String id, String valid) {
		// TODO Auto-generated method stub
		
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
