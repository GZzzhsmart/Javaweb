package com.java.activiti.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.activiti.model.Group;
import com.java.activiti.model.PageInfo;
import com.java.activiti.model.User;
import com.java.activiti.service.GroupService;
import com.java.activiti.util.ResponseUtil;
/**
 * 角色管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/group")
public class GroupController {
		@Resource
		private GroupService groupService;
		/**
		 * 填充角色下拉框
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/findGroup")
		public String findGroup(HttpServletResponse response) throws Exception{
			List<Group> list=groupService.findGroup();
			
			JSONArray jsonArray=new JSONArray();

			JSONObject jsonObject=new JSONObject();
			jsonObject.put("trueName", "请选择...");
			//转为JSON格式的数据
			jsonArray.add(jsonObject);
			//将list转为JSON
			JSONArray rows=JSONArray.fromObject(list);
			jsonArray.addAll(rows);
			ResponseUtil.write(response, jsonArray);
			return null;
		}
		
		/**
		 * 分页查询用户
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/groupPage")
		public String groupPage(HttpServletResponse response,
				@RequestParam(value = "page", required = false) String page,
				@RequestParam(value = "rows", required = false) String rows,
				User user) throws Exception{
			Map<String,Object> groupMap=new HashMap<String, Object>();
			groupMap.put("id", user.getId());
			
			PageInfo<User> userPage = new PageInfo<User>();
			Integer pageSize=Integer.parseInt(rows);
			userPage.setPageSize(pageSize);
			
			// 第几页
			String pageIndex = page;
			if (pageIndex == null || pageIndex == "") {
				pageIndex = "1";
			}
			userPage.setPageIndex((Integer.parseInt(pageIndex) - 1)
					* pageSize);
			// 取得总页数
			int userCount=groupService.groupCount(groupMap);
			userPage.setCount(userCount);
			groupMap.put("pageIndex", userPage.getPageIndex());
			groupMap.put("pageSize", userPage.getPageSize());

			List<Group> cusDevPlanList = groupService.groupPage(groupMap);
			JSONObject json = new JSONObject();
			// 把List格式转换成JSON
			JSONArray jsonArray = JSONArray.fromObject(cusDevPlanList);
			json.put("rows", jsonArray);
			json.put("total", userCount);
			ResponseUtil.write(response, json);
			return null;
		}
		/**
		 * 修改用户
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/updateGroup")
		public String updateGroup(HttpServletResponse response,Group group) throws Exception{
			int result=groupService.updateGroup(group);
			JSONObject json=new JSONObject();
			if(result>0){
				json.put("success", true);
			}else{
				json.put("success", false);
			}
			ResponseUtil.write(response, json);
			return null;
		}
		/**
		 * 批量刪除用戶
		 * @param response
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/deleteGroup")
		public String deleteGroup(HttpServletResponse response,HttpServletRequest request) throws Exception{
			String id=request.getParameter("ids");
			JSONObject json=new JSONObject();
			List<String> list=new ArrayList<String>();
			  String[] strs = id.split(",");
		        for (String str : strs) {
		        	list.add(str);
		        }
		   try {	
				int userResult=groupService.deleteGroup(list);
				if(userResult>0){
					json.put("success", true);
				}else{
					json.put("success", false);
				}
			} catch (Exception e) {
				json.put("success", false);
				e.printStackTrace();
			}
			ResponseUtil.write(response, json);
			return null;
		}

		/**
		 * 新增用戶
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping("/groupSave")
		public String groupSave(HttpServletResponse response,Group group) throws Exception{
			int userResult=groupService.addGroup(group);
			JSONObject json=new JSONObject();
			if(userResult>0){
				json.put("success", true);
			}else{
				json.put("success", false);
			}
			ResponseUtil.write(response, json);
			return null;
		}
		
		@RequestMapping("/listAllGroups")
		public String listAllGroups(HttpServletResponse response) throws Exception{
			List<Group> list=groupService.findGroup();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JSONArray.fromObject(list);
			result.put("groupList", jsonArray);
			ResponseUtil.write(response, result);
			return null;
		}
		@RequestMapping("/findGroupByUserId")
		public String findGroupByUserId(HttpServletResponse response,String userId) throws Exception{
			List<Group> groupList=groupService.findByUserId(userId);
			StringBuffer groups=new StringBuffer();
			for(Group g:groupList){
				groups.append(g.getId()+",");
			}
			JSONObject result=new JSONObject();
			if(groups.length()>0){
				result.put("groups", groups.deleteCharAt(groups.length()-1).toString());
			}else{
				result.put("groups",groups.toString());
			}
			ResponseUtil.write(response, result);
			return null;
		}
}
