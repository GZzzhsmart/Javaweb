package com.gs.service.impl;

import javax.annotation.Resource;

import com.gs.common.bean.Pager4EasyUI;
import com.gs.dao.loginDAO;
import com.gs.pojo.Agency;
import com.gs.service.loginService;

public class loginServiceImpl implements loginService{

	@Resource
	private loginDAO loginDAO;
	@Override
	public Agency queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager4EasyUI<Agency> queryByPager(Pager4EasyUI<Agency> pager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Agency t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Agency t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valid(String id, String valid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryEmail(String agnecy_email) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryPhone(String agency_phone) {
		// TODO Auto-generated method stub
		return 0;
	}

}
