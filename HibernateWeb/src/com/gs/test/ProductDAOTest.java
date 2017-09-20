package com.gs.test;


import org.junit.Test;

import com.gs.bean.Product;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.ProductDAO;
import com.gs.dao.ProductDAOImpl;

import junit.framework.TestCase;

public class ProductDAOTest extends TestCase {
	
	private ProductDAO dao;
	
	@Override
	protected void setUp() throws Exception {
		dao = new ProductDAOImpl();
	}

	@Test
	public void testAdd() {
		Product product = new Product();
		product.setTitle("test 1");
		product.setPrice(10.5);
		product.setDes("des");
		dao.add(product);
	}
	
	@Test
	public void testQueryById() {
		Product p = dao.queryById(1);
		if (p != null) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testDelete() {
		Product p = new Product();
		p.setId(4);
		dao.delete(p);
	}
	
	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setId(5);
		p.setTitle("5");
		p.setPrice(100);
		p.setDes("55555");
		dao.update(p);
	}
	
	@Test
	public void testQueryAll() {
		Pager4EasyUI<Product> pager = new Pager4EasyUI<>();
		pager.setPageNo(3);
		pager.setPageSize(2);
		pager = dao.queryAll(pager);
		pager.setTotal(dao.count());
		if (pager.getRows() != null) {
			for (Product p : pager.getRows()) {
				System.out.println(p);
			}
		}
	}
	
	@Test
	public void testQueryByIdHQL() {
		Product p = dao.queryById(5);
		System.out.println(p);
	}
	
}
