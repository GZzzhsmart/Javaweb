package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.bean.User;
import com.service.UserService;
import com.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 166587521195770571L;
	
	private HttpServletRequest request; // 相当于Servlet中的HttpServletRequest对象，用于接收页面的请求
	
	private int total;
	private List<User> rows;
	
	private int page; // 从easyui获取第几页
	
	private UserService userService;
	
	public UserAction() {
		userService = new UserServiceImpl();
	}
	
	public int getTotal() {
		return total;
	}
	
	public List<User> getRows() {
		return rows;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public String execute() {
		//假设已经通过service调用了dao并返回了user列表 
		int pageSize = Integer.valueOf(request.getParameter("rows"));
		rows = userService.queryByPager(page, pageSize);
		total = userService.count();
		return SUCCESS;
	}

	/**
	 * 此方法的request对象会通过struts的上下文传递进来，所以可以直接赋值给本类的HttpServletRequest对象
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
