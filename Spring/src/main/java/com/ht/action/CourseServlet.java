package com.ht.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ht.base.IBaseDAO;
import com.ht.base.WebApplicationContextUtil;
import com.ht.vo.CourseVo;

public class CourseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IBaseDAO baseDAO = (IBaseDAO)WebApplicationContextUtil.createService(request, "baseDAO");
		String courseid = request.getParameter("courseid");
		CourseVo c = new CourseVo();
		c.setCourseid(Integer.parseInt(courseid));
		baseDAO.del(c);
		System.out.println("删除成功！");
		
	}

}
