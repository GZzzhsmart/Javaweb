package com.gs.serviceImpl;

import com.gs.common.Pager4EasyUI;
import com.gs.dao.TestDAO;
import com.gs.pojo.Test;
import com.gs.service.TestService;

public class TestServiceImpl implements TestService {
	
	private TestDAO testDAO;
	
	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	public Test queryById(String id) {
		return testDAO.queryById(id);
	}

	public Pager4EasyUI<Test> queryByPager(Pager4EasyUI<Test> pager) {
		return testDAO.queryByPager(pager);
	}

	public void update(Test t) {
		testDAO.update(t);
		
	}

	public void add(Test t) {
		testDAO.add(t);
	}

	public void valid(String id, String valid) {
		testDAO.valid(id, valid);
		
	}

	public int count() {
		return testDAO.count();
	}

}
