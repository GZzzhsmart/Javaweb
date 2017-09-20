package com.gs.service;

import com.gs.bean.Product;
import com.gs.common.bean.Pager4EasyUI;

public interface ProductService {
	
	public Product add(Product product);
	public Pager4EasyUI<Product> queryAll(Pager4EasyUI<Product> pager);
	public Product queryById(int id);
	public void update(Product product);
	public void delete(Product product);
	
	public int count();

}
