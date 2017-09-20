package com.ht.base;

import java.util.List;

public interface IBase {

	public void add(Object obj);
	public void update(Object obj);
	public void del(Object obj);
	public List list(PageObject pager);
}
