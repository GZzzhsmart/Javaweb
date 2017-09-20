package com.gs.dao;

import com.gs.bean.User;

public interface UserDAO {
	
	public User add(User user);
	
	public User queryById(int id);

	public void delete(User user);
	
	public void update(User user);
	
}
