package com.gs.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gs.bean.User;

public class UserDAOImpl extends BaseDAO implements UserDAO {
	
	@Override
	public User add(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return user;
	}
	
	@Override
	public User queryById(int id) {
		Session session = sessionFactory.openSession();
		User u = (User) session.get(User.class, id);
		session.close();
		return u;
	}

	@Override
	public void delete(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();
		session.close();
	}
	
	@Override
	public void update(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
	}
	
}
