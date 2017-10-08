package com.java.activiti.dao;

import java.util.List;
import java.util.Map;

import com.java.activiti.model.Leave;

/**
 * 业务管理
 * @author Administrator
 *
 */
public interface LeaveDao {
		public List<Leave> leavePage(Map<String,Object> map);
		
		public int leaveCount(Map<String,Object> map);
		
		public int addLeave(Leave leave);
		
		public Leave findById(String id);
		
		public int updateLeave(Leave leave);
		
		public Leave getLeaveByTaskId(String processInstanceId);
}
