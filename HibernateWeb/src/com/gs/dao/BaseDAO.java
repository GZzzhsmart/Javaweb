package com.gs.dao;

import org.hibernate.SessionFactory;

import com.gs.util.HibernateUtil;

public class BaseDAO {
	
	protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

}
