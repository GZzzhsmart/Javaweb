package com.gs.service;

import com.gs.bean.ProductType;
import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.ProductTypeDAO;
import com.gs.dao.ProductTypeDAOImpl;

public class ProductTypeServiceImpl implements ProductTypeService {

	private ProductTypeDAO productTypeDAO;
	
	public ProductTypeServiceImpl() {
		productTypeDAO = new ProductTypeDAOImpl();
	}
	
	@Override
	public ProductType queryById(Integer id) {
		return productTypeDAO.queryById(id);
	}

	@Override
	public Pager4EasyUI<ProductType> queryByPager(Pager4EasyUI<ProductType> pager) {
		pager = productTypeDAO.queryByPager(pager);
		return pager;
	}

	@Override
	public void update(ProductType t) {
		productTypeDAO.update(t);
	}

	@Override
	public void add(ProductType t) {
		productTypeDAO.add(t);
	}

	@Override
	public void validById(Integer id, String valid) {
		productTypeDAO.validById(id, valid);
	}

	@Override
	public int count() {
		return productTypeDAO.count();
	}


}
