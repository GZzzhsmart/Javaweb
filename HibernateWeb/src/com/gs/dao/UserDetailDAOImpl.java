package com.gs.dao;

import org.hibernate.Session;

import com.gs.bean.UserDetail;

public class UserDetailDAOImpl extends BaseDAO implements UserDetailDAO {

	@Override
	public UserDetail queryById(int id) {
		Session session = sessionFactory.openSession();
		UserDetail ud = (UserDetail) session.get(UserDetail.class, id);
		session.close();
		return ud;
	}

}
