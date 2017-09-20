package com.base;

import java.util.List;

import com.bean.User;

public interface UserDAO {
	
	public List<User> queryByPager(int page, int pageSize);
	
	public int count();

}
