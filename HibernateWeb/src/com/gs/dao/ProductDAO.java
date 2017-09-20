package com.gs.dao;

import com.gs.bean.Product;
import com.gs.common.bean.Pager4EasyUI;

public interface ProductDAO {
	
	public Product add(Product product);
	public Product queryById(int id);
	public Pager4EasyUI<Product> queryAll(Pager4EasyUI<Product> pager);
	public void update(Product product);
	public void delete(Product product);
	
	public int count();
}
