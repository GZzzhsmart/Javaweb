package com.service;

import java.util.List;

import com.bean.User;
import com.base.UserDAO;
import com.base.UserDAOImpl;

public class UserServiceImpl implements UserService {

private UserDAO userDAO;
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	public List<User> queryByPager(int page, int pageSize) {
		return userDAO.queryByPager(page, pageSize);
	}

	public int count() {
		return userDAO.count();
	}

}
