package com.java.activiti.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.activiti.model.Group;
import com.java.activiti.model.Leave;
import com.java.activiti.model.MemberShip;
import com.java.activiti.model.MyTask;
import com.java.activiti.model.PageInfo;
import com.java.activiti.model.User;
import com.java.activiti.service.LeaveService;
import com.java.activiti.util.DateJsonValueProcessor;
import com.java.activiti.util.ResponseUtil;

/**
 * 历史流程批注管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/task")
public class TaskController {

	// 引入activiti自带的Service接口
	@Resource
	private TaskService taskService;
	
	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private RuntimeService runtimeService;
	
	@Resource
	private FormService formService;
	
	@Resource
	private LeaveService leaveService;
	
	@Resource
	private HistoryService historyService;

	
	/**
	 * 查询历史流程批注
	 * 
	 * @param response
	 * @param processInstanceId
	 *            流程ID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/listHistoryCommentWithProcessInstanceId")
	public String listHistoryCommentWithProcessInstanceId(
			HttpServletResponse response, String processInstanceId) throws Exception {
		if (processInstanceId == null) {
			return null;
		}
		List<Comment> commentList = taskService
				.getProcessInstanceComments(processInstanceId);
		// 改变顺序，按原顺序的反向顺序返回list
		Collections.reverse(commentList); //集合元素反转
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
			//时间格式转换
				new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(commentList, jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 重定向审核处理页面
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/redirectPage")
	public String redirectPage(String taskId,HttpServletResponse response)throws Exception{
		TaskFormData formData=formService.getTaskFormData(taskId);
		String url=formData.getFormKey();
		System.out.println("*********************"+url);
		JSONObject result=new JSONObject();
		result.put("url", url);
		ResponseUtil.write(response, result);
		return null;
	}
	

	/**
	 * 待办流程分页查询
	 * @param response
	 * @param page 当前页数
	 * @param rows 每页显示页数
	 * @param s_name 流程名称
	 * @param userId 流程ID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/taskPage")
	public String taskPage(HttpServletResponse response,String page,String rows,String s_name,String userId) throws Exception{
		if(s_name==null){
			s_name="";
		}
		PageInfo pageInfo=new PageInfo();
		Integer pageSize=Integer.parseInt(rows);
		pageInfo.setPageSize(pageSize);
		if(page==null||page.equals("")){
			page="1";
		}
		pageInfo.setPageIndex((Integer.parseInt(page)-1)*pageInfo.getPageSize());
		// 获取总记录数
		System.out.println("用户ID："+userId+"\n"+"名称:"+s_name);
		long total=taskService.createTaskQuery()
				.taskCandidateGroup(userId)
				.taskNameLike("%"+s_name+"%")
				.count(); // 获取总记录数
		//有想法的话，可以去数据库观察  ACT_RU_TASK 的变化
		List<Task> taskList=taskService.createTaskQuery()
				 // 根据用户id查询
				.taskCandidateGroup(userId)
				// 根据任务名称查询
				.taskNameLike("%"+s_name+"%") 
				// 返回带分页的结果集合
				.listPage(pageInfo.getPageIndex(), pageInfo.getPageSize()); 
		//这里需要使用一个工具类来转换一下主要是转成JSON格式
		List<MyTask> MyTaskList=new ArrayList<MyTask>();
		for(Task t:taskList){
			MyTask myTask=new MyTask();
			myTask.setId(t.getId());
			myTask.setName(t.getName());
			myTask.setCreateTime(t.getCreateTime());
			MyTaskList.add(myTask);
		}
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(MyTaskList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 查询当前流程图
	 * @return
	 */
	@RequestMapping("/showCurrentView")
	public String showCurrentView(HttpServletResponse response,String taskId){
		//视图
		ModelAndView mav=new ModelAndView();
		
		Task task=taskService.createTaskQuery() // 创建任务查询
				.taskId(taskId) // 根据任务id查询
				.singleResult(); 
		 // 获取流程定义id
		String processDefinitionId=task.getProcessDefinitionId();
		ProcessDefinition processDefinition=repositoryService.createProcessDefinitionQuery() // 创建流程定义查询
				// 根据流程定义id查询
				.processDefinitionId(processDefinitionId) 
				.singleResult(); 
		// 部署id
		mav.addObject("deploymentId",processDefinition.getDeploymentId()); 
		mav.addObject("diagramResourceName", processDefinition.getDiagramResourceName()); // 图片资源文件名称
		
	    ProcessDefinitionEntity	processDefinitionEntity=(ProcessDefinitionEntity) 
	    		repositoryService.getProcessDefinition(processDefinitionId); 
	    // 获取流程实例id
	    String processInstanceId=task.getProcessInstanceId(); 
	    // 根据流程实例id获取流程实例
	    ProcessInstance pi=runtimeService.createProcessInstanceQuery() 
	    		.processInstanceId(processInstanceId)
	    		.singleResult();
	    
	    // 根据活动id获取活动实例
	    ActivityImpl activityImpl=processDefinitionEntity.findActivity(pi.getActivityId()); 
	    //整理好View视图返回到显示页面
	    mav.addObject("x", activityImpl.getX()); // x坐标
	    mav.addObject("y", activityImpl.getY()); // y坐标
	    mav.addObject("width", activityImpl.getWidth()); // 宽度
	    mav.addObject("height", activityImpl.getHeight()); // 高度
		mav.setViewName("page/currentView");
		return null;
	}
	/**
	 * 查询历史批注
	 * @param response
	 * @param taskId 流程ID  
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/listHistoryComment")
	public String listHistoryComment(HttpServletResponse response,String taskId) throws Exception{
		if(taskId==null){
			taskId="";
		}
		HistoricTaskInstance hti=historyService.createHistoricTaskInstanceQuery()
				.taskId(taskId)
				.singleResult();
		JsonConfig jsonConfig=new JsonConfig();
		JSONObject result=new JSONObject();
		List<Comment> commentList=null;
		if(hti!=null){
		    commentList=taskService.getProcessInstanceComments(hti.getProcessInstanceId()); 
			// 集合元素反转
			Collections.reverse(commentList); 
			
			//日期格式转换
			jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		}
		JSONArray jsonArray=JSONArray.fromObject(commentList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 审批
	 * @param taskId 任务id
	 * @param leaveDays 请假天数
	 * @param comment 批注信息
	 * @param state 审核状态 1 通过 2 驳回
	 * @param response
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/audit_bz")
	public String audit_bz(String taskId,Integer leaveDays,String comment,Integer state,HttpServletResponse response,HttpSession session)throws Exception{
		//首先根据ID查询任务
		Task task=taskService.createTaskQuery() // 创建任务查询
		        .taskId(taskId) // 根据任务id查询
		        .singleResult();
		Map<String,Object> variables=new HashMap<String,Object>();
		//取得角色用户登入的session对象
		MemberShip currentMemberShip=(MemberShip) session.getAttribute("currentMemberShip");
		//取出用户，角色信息
		User currentUser=currentMemberShip.getUser();
		Group currentGroup=currentMemberShip.getGroup();
		if(currentGroup.getName().equals("总裁")||currentGroup.getName().equals("副总裁")){
			if(state==1){
				String leaveId=(String) taskService.getVariable(taskId, "leaveId");
				Leave leave=leaveService.findById(leaveId);
				leave.setState("审核通过");
				// 更新审核信息
				leaveService.updateLeave(leave); 
				variables.put("msg", "通过");
			}else{
				String leaveId=(String) taskService.getVariable(taskId, "leaveId");
				Leave leave=leaveService.findById(leaveId);
				leave.setState("审核未通过");
				// 更新审核信息
				leaveService.updateLeave(leave); 
				variables.put("msg", "未通过");
			}
		}
		if(state==1){
			variables.put("msg", "通过");
		}else{
			String leaveId=(String) taskService.getVariable(taskId, "leaveId");
			Leave leave=leaveService.findById(leaveId);
			leave.setState("审核未通过");
			// 更新审核信息
			leaveService.updateLeave(leave); 
			variables.put("msg", "未通过");
		}
		// 设置流程变量
		variables.put("dasy", leaveDays); 
		 // 获取流程实例id
		String processInstanceId=task.getProcessInstanceId();
		// 设置用户id
		Authentication.setAuthenticatedUserId(currentUser.getFirstName()+currentUser.getLastName()+"["+currentGroup.getName()+"]"); 
		// 添加批注信息
		taskService.addComment(taskId, processInstanceId, comment); 
		// 完成任务
		taskService.complete(taskId, variables); 
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 查詢流程正常走完的历史流程表 :  act_hi_actinst
	 * @param response
	 * @param rows
	 * @param page
	 * @param s_name  
	 * @param groupId
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/finishedList")
	public String finishedList(HttpServletResponse response,String rows,String page,String s_name,String groupId) throws Exception{
		//为什么要这样呢？因为程序首次运行进入后台时，
		//s_name必定是等于null的，如果直接这样填写进查询语句中就会出现  % null %这样就会导致查询结果有误
		if(s_name==null){
			s_name="";
		}
		PageInfo pageInfo=new PageInfo();
		Integer pageSize=Integer.parseInt(rows);
		pageInfo.setPageSize(pageSize);
		if(page==null||page.equals("")){
			page="1";
		}
		pageInfo.setPageIndex((Integer.parseInt(page)-1)*pageSize);
											//创建流程历史实例查询
		List<HistoricTaskInstance> histList=historyService.createHistoricTaskInstanceQuery()
				.taskCandidateGroup(groupId)//根据角色名称查询
				.taskNameLike("%"+s_name+"%")
				.listPage(pageInfo.getPageIndex(), pageInfo.getPageSize());
		
		long histCount=historyService.createHistoricTaskInstanceQuery()
				.taskCandidateGroup(groupId)
				.taskNameLike("%"+s_name+"%")
				.count();
		List<MyTask> taskList=new ArrayList<MyTask>();
		//这里递出没有用的字段，免得给前端页面做成加载压力
		for(HistoricTaskInstance hti:histList){
			MyTask myTask=new MyTask();
			myTask.setId(hti.getId());
			myTask.setName(hti.getName());
			myTask.setCreateTime(hti.getCreateTime());
			myTask.setEndTime(hti.getEndTime());
			taskList.add(myTask);
		}
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(taskList,jsonConfig);
		result.put("rows", jsonArray);
		result.put("total",histCount );
		ResponseUtil.write(response, result);
		return null;
	}
	/**
	 * 根据任务id查询流程实例的具体执行过程
	 * @param taskId
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listAction")
	public String listAction(String taskId,HttpServletResponse response)throws Exception{
		HistoricTaskInstance hti=historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
		String processInstanceId=hti.getProcessInstanceId(); // 获取流程实例id
		List<HistoricActivityInstance> haiList=historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId).list();
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(haiList,jsonConfig);
		result.put("rows", jsonArray);
		ResponseUtil.write(response, result);
		return null;
	}
}
