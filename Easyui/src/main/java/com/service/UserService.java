package com.service;

import java.util.List;

import com.bean.User;

public interface UserService {

	public List<User> queryByPager(int page, int pageSize);
	
	public int count();
	
}
