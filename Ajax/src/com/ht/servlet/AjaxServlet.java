package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T1.StudentVo;

@SuppressWarnings({ "unused", "serial" })
public class AjaxServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(action.equals("check")){
			String studid = toStr(request.getParameter("studid"));
			System.out.println(studid);
			//ģ����ݿ�������ѧ��1001���ڣ�����Ͳ�����
			if(studid.equals("1001")){
				out.print("fail");
			}else {
				out.print("succ");
			}
		}else if(action.equals("save")){
			String studid = toStr(request.getParameter("studid"));
			String studname = toStr(request.getParameter("studname"));
			String age = request.getParameter("age");
			String hobit = toStr(request.getParameter("hobit"));
			String sex = toStr(request.getParameter("sex"));
			String classid = request.getParameter("classid");
			System.out.println("学号="+studid+";姓名="+studname+";年龄="+age+";爱好="+hobit+";性别="+sex+";班级༶="+classid);
			out.print("ok");
		}
		out.flush();
		out.close();
	}

	private String toStr(String str){
		try {
			str = new String(str.getBytes("iso-8859-1"),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
