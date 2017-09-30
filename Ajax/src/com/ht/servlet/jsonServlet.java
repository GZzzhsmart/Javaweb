package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ht.bean.StudentVo;

@SuppressWarnings("serial")
public class jsonServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "{\"message\":\"JSON��ʽ���\"}";
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}
	public void doPost2(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String str = "{";
		//���ݼ������
		str+="\"stud\":[";
		str += "{\"studid\":\"1001\",\"studname\":\"����\",\"age\":\"20\"},";
		str += "{\"studid\":\"1002\",\"studname\":\"����\",\"age\":\"22\"},";
		str += "{\"studid\":\"1003\",\"studname\":\"С��\",\"age\":\"23\"}";
		str += "]";
		str += "}";
		System.out.println(str);
		out.println(str);
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentVo s1 = new StudentVo(1,"1001","����","��ͼ201601��");
		StudentVo s2 = new StudentVo(2,"1002","С��","��ͼ201601��");
		StudentVo s3 = new StudentVo(3,"1003","��С��","��ͼ201601��");
		StudentVo s4 = new StudentVo(4,"1004","�����","��ͼ201601��");
		
		List<StudentVo> studentList = new ArrayList<StudentVo>();
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		String data = JSON.toJSONString(studentList);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println(data);
		out.println(data);
		out.flush();
		out.close();
	}

}
