package com.java.activiti.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.activiti.dao.GroupDao;
import com.java.activiti.model.Group;
import com.java.activiti.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService{

	@Resource
	private GroupDao groupDao;
	
	public List<Group> findByUserId(String id){
		return groupDao.findByUserId(id);
	}
	/**
	 * 查询所有角色填充下拉框
	 * @return
	 */
	public List<Group> findGroup(){
		return groupDao.findGroup();
	}
	

	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public List<Group> groupPage(Map<String,Object> map){
		return groupDao.groupPage(map);
	}
	/**
	 * 统计数量
	 * @param map
	 * @return
	 */
	public int groupCount(Map<String,Object> map){
		return groupDao.groupCount(map);
	}
	
	/**
	 * 批量刪除
	 * @param list
	 * @return
	 */
	public int deleteGroup(List<String> list){
		return groupDao.deleteGroup(list);
	}
	
	/**
	 * 修改
	 * @param group
	 * @return
	 */
	public int updateGroup(Group group){
		return groupDao.updateGroup(group);
	}
	
	public int addGroup(Group group){
		return groupDao.addGroup(group);
	}
}
