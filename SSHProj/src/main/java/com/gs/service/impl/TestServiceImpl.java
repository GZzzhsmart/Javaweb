package com.gs.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.TestDAO;
import com.gs.pojo.Test;
import com.gs.service.TestService;
@Service
@Transactional
public class TestServiceImpl implements TestService {
	@Resource
	private TestDAO testDAO;
	
	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	
	public Test queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pager4EasyUI<Test> queryByPager(Pager4EasyUI<Test> pager) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Test t) {
		// TODO Auto-generated method stub
		
	}

	public void add(Test t) {
		testDAO.add(t);
	}

	public void valid(String id, String valid) {
		// TODO Auto-generated method stub
		
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
