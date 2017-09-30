package com.gs.dao;

import java.util.List;

import com.gs.bean.Product;

public interface ProductDAO {
	
	public Product add(Product product);
	public Product queryById(int id);
	public List<Product> queryAll();
	public void update(Product product);
	public void delete(Product product);
}
