package com.java.activiti.service;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Group;

public interface GroupService {

	public List<Group> findByUserId(String id);
	/**
	 * 查询所有角色填充下拉框
	 * @return
	 */
	public List<Group> findGroup();

	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public List<Group> groupPage(Map<String,Object> map);
	/**
	 * 统计数量
	 * @param map
	 * @return
	 */
	public int groupCount(Map<String,Object> map);
	
	/**
	 * 批量刪除
	 * @param list
	 * @return
	 */
	public int deleteGroup(List<String> list);
	
	/**
	 * 修改
	 * @param group
	 * @return
	 */
	public int updateGroup(Group group);
	
	public int addGroup(Group group);
}
