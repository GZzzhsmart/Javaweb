package com.cn.hnust.service;

import javax.ws.rs.DELETE;

import com.cn.hnust.pojo.User;
import com.cn.hnust.pojo.UserinfoPO;

public interface IUserService {
	public User selectByPrimaryKey(Integer id);
	public void delete(Integer id);
}
