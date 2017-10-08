package com.java.activiti.service;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.User;

public interface UserService {
	
	public User findById(String userId);
	/**
	 * 登入
	 * @return
	 */
	public User userLogin(User user);
	
	/**'
	 * 分页查询用户
	 * @param map
	 * @return
	 */
	public List<User> userPage(Map<String, Object> map);
	
	public int userCount(Map<String, Object> map);
	
	/**
	 * 批量删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(List<String> id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
}
