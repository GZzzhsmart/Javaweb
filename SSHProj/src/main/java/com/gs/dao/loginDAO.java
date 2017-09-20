package com.gs.dao;

import com.gs.pojo.Agency;

public interface loginDAO extends BaseDAO<String, Agency> {

	 //验证邮箱
	 public int queryEmail(String agnecy_email);
	 //验证手机号
	 public int queryPhone(String agency_phone);
}
