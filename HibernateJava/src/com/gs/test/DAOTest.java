package com.gs.test;


import java.util.List;

import org.junit.Test;

import com.gs.bean.Product;
import com.gs.dao.ProductDAO;
import com.gs.dao.ProductDAOImpl;

import junit.framework.TestCase;

public class DAOTest extends TestCase {
	
	private ProductDAO dao;
	
	@Override
	protected void setUp() throws Exception {
		dao = new ProductDAOImpl();
	}

	public void testAdd() {
		Product product = new Product();
		product.setTitle("test 1");
		product.setPrice(10.5);
		product.setDes("des");
		dao.add(product);
	}
	
	public void testQueryById() {
		Product p = dao.queryById(1);
		if (p != null) {
			System.out.println(p);
		}
	}
	
	public void testDelete() {
		Product p = new Product();
		p.setId(4);
		dao.delete(p);
	}
	
	public void testUpdate() {
		Product p = new Product();
		p.setId(5);
		p.setTitle("5");
		p.setPrice(100);
		p.setDes("55555");
		dao.update(p);
	}
	
	public void testQueryAll() {
		List<Product> products = dao.queryAll();
		for (Product p : products) {
			System.out.println(p);
		}
	}
	
	public void testQueryByIdHQL() {
		Product p = dao.queryById(5);
		System.out.println(p);
	}
	

}
