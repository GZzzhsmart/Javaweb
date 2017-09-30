<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	System.out.println("num="+num);
	out.println("收到num的值为："+num);
	out.flush();
%>

