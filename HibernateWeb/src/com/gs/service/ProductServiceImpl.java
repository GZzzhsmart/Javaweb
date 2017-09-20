package com.gs.service;

import com.gs.bean.Product;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.ProductDAO;
import com.gs.dao.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDAO productDAO;
	
	public ProductServiceImpl() {
		productDAO = new ProductDAOImpl();
	}
	
	@Override
	public Product add(Product product) {
		return productDAO.add(product);
	}

	@Override
	public Pager4EasyUI<Product> queryAll(Pager4EasyUI<Product> pager) {
		return productDAO.queryAll(pager);
	}

	@Override
	public Product queryById(int id) {
		return productDAO.queryById(id);
	}

	@Override
	public void update(Product product) {
		productDAO.update(product);
	}

	@Override
	public void delete(Product product) {
		productDAO.delete(product);
	}

	@Override
	public int count() {
		return productDAO.count();
	}

}
