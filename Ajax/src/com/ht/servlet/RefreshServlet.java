package com.ht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RefreshServlet extends HttpServlet {
	
	HashMap<String, String> map = new HashMap<String, String>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		map.put("1", "<member>����</member><member>����</member>");
		map.put("2", "<member>����</member><member>С��</member>");
		map.put("3", "<member>����</member><member>СС</member>");
		map.put("4", "<member>��С��</member><member>������</member><member>��С��</member>");
		int depid=1;
		//����application����
		ServletContext application = getServletContext();
		if(application.getAttribute("depid")==null){
			application.setAttribute("depid","1");
		}
		depid = Integer.parseInt(application.getAttribute("depid").toString());
		
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='utf-8' ?>");
		sb.append("<members>");
		sb.append(map.get(depid+""));
		sb.append("</members>");
		depid++;
		if(depid>4)
			depid=1;
		application.setAttribute("depid",depid);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sb);
		out.flush();
		out.close();
	}

}
