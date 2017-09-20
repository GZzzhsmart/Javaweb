package com.ht.base;

import java.io.Serializable;

public interface IBaseDAO {

	void save(Object obj);
	void del(Object obj);
	Object get(Class clzss,Serializable id);
}
