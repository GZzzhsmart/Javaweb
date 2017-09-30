package com.gs.dao;

import com.gs.common.Pager4EasyUI;

public interface BaseDAO<PK, T> {
	
	public T queryById(PK id);
	
	public Pager4EasyUI<T> queryByPager(Pager4EasyUI<T> pager);
	
	public void update(T t);
	
	public void add(T t);
	
	public void valid(PK id, String valid);
	
	public int count();

}
