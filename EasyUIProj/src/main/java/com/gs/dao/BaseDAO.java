package com.gs.dao;

import com.gs.common.bean.Pager4EasyUI;

/**
 * 使用泛型声明BaseDAO可接收任何类型的数据
 * @author Administrator
 *
 * @param <PK> 用于描述T对象所对应的表的主键类型
 * @param <T> 用于T对象
 */
public interface BaseDAO<PK, T> {
	
	public T queryById(PK id);
	
	public Pager4EasyUI<T> queryByPager(Pager4EasyUI<T> pager);
	
	public void update(T t);
	
	public void add(T t);
	
	public void validById(PK id, String valid);
	
	public int count();

}
