package com.java.activiti.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.activiti.model.Leave;
import com.java.activiti.model.PageInfo;
import com.java.activiti.model.User;
import com.java.activiti.service.LeaveService;
import com.java.activiti.util.DateJsonValueProcessor;
import com.java.activiti.util.ResponseUtil;

/**
 * 业务处理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {

	@Resource
	private LeaveService leaveService;
	@Resource
	private RuntimeService runtimeService;
	@Resource
	private TaskService taskService;
	/**
	 * 分页查询业务
	 * @param response
	 * @param rows
	 * @param page
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/leavePage")
	public String leavePage(HttpServletResponse response, String rows,
			String page, String userId) throws Exception {
		PageInfo<Leave> leavePage = new PageInfo<Leave>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		Integer pageSize = Integer.parseInt(rows);
		leavePage.setPageSize(pageSize);
		if (page == null || page.equals("")) {
			page = "1";
		}
		leavePage.setPageIndex((Integer.parseInt(page) - 1) * pageSize);
		map.put("pageIndex", leavePage.getPageIndex());
		map.put("pageSize", leavePage.getPageSize());
		int leaveCount = leaveService.leaveCount(map);
		List<Leave> leaveList = leaveService.leavePage(map);
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(leaveList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", leaveCount);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加请假单
	 * @param leave
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(Leave leave,HttpServletResponse response,String userId)throws Exception{
		System.out.println("这里面是什么鬼："+userId);
		User user=new User();
		user.setId(userId);
		int resultTotal=0;
		leave.setLeaveDate(new Date());
		//添加用户对象
		leave.setUser(user);
		resultTotal=leaveService.addLeave(leave);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 提交請假流程申請
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/startApply")
	public String startApply(HttpServletResponse response,String leaveId) throws Exception{
		Map<String,Object> variables=new HashMap<String,Object>();
		variables.put("leaveId", leaveId);
		// 启动流程
		ProcessInstance pi= runtimeService.startProcessInstanceByKey("activitiemployeeProcess",variables); 
		// 根据流程实例Id查询任务
		Task task=taskService.createTaskQuery().processInstanceId(pi.getProcessInstanceId()).singleResult(); 
		 // 完成 学生填写请假单任务		
		taskService.complete(task.getId()); 
		Leave leave=leaveService.findById(leaveId);
		//修改状态
		leave.setState("审核中");
		leave.setProcessInstanceId(pi.getProcessInstanceId());
		 // 修改请假单状态
		leaveService.updateLeave(leave);
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 查询流程信息
	 * @param response
	 * @param taskId  流程实例ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getLeaveByTaskId")
	public String getLeaveByTaskId(HttpServletResponse response,String taskId) throws Exception{
		//先根据流程ID查询
		Task task=taskService.createTaskQuery().taskId(taskId).singleResult(); 
		Leave leave=leaveService.getLeaveByTaskId(task.getProcessInstanceId());
		JSONObject result=new JSONObject();
		result.put("leave", JSONObject.fromObject(leave));
		ResponseUtil.write(response, result);
		return null;
	}
}
