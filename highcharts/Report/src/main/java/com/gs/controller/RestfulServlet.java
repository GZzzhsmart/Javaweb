package com.gs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gs.common.WebUtil;


@WebServlet(name = "RestfulServlet", urlPatterns = "/rest/*")
public class RestfulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // 获取的uri是从/ + conetxtPath + /rest，不包含查询字符串
		String method = WebUtil.getReqMethod(req);
		if (method.equals("add")) {
			add(req, resp);
		} else if (method.equals("update")) {
			update(req, resp);
		} else if (method.equals("remove")) {
			remove(req, resp);
		} else if (method.equals("pager")) {
			pager(req, resp);
		}
	}
	
	private void pager(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub　待办任务
		
	}

	private void remove(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) {
		// TODO 做更新操作
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO 做添加操作
	}
	
	
     

}
