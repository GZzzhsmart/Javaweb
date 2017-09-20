package com.gs.service;

import com.gs.common.bean.Pager4EasyUI;

public interface BaseService<PK, T> {
	public T queryById(PK id);
	
	public Pager4EasyUI<T> queryByPager(Pager4EasyUI<T> pager);
	
	public void update(T t);
	
	public void add(T t);
	
	
	public void validById(PK id, String valid);
	
	public int count();
}
