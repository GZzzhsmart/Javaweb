<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	out.print("欢迎你："+new String(request.getParameter("say").getBytes("iso-8859-1"),"utf-8"));
	
%>

