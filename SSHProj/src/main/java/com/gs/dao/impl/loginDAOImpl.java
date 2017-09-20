package com.gs.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.loginDAO;
import com.gs.pojo.Agency;

public class loginDAOImpl implements loginDAO{

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public Agency queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager4EasyUI<Agency> queryByPager(Pager4EasyUI<Agency> pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Agency t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Agency t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		
	}

	@Override
	public void valid(String id, String valid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryEmail(String agnecy_email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryPhone(String agency_phone) {
		// TODO Auto-generated method stub
		return 0;
	}

}
