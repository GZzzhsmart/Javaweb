package com.ht.base;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//实现了IBaseDAO接口，同时继承HibernateDaoSupport数据库操作类
public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDAO {

	
	public void del(Object obj) {
		getHibernateTemplate().delete(obj);
	}

	public void save(Object obj) {
		getHibernateTemplate().save(obj);
	}
	public Object get(Class clzss,Serializable id){
		Object obj = getHibernateTemplate().get(clzss, id);
		return obj;
	}

}
