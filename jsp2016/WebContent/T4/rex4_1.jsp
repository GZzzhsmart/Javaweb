<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" %>
<%
	request.setCharacterEncoding("utf-8");
	String str1 = request.getParameter("myString");
	String str2 = request.getParameter("b1");
	out.println("你输入的字符串是：");
	out.println(str1+"<br>");
	out.println("按钮显示的是：");
	out.println(str2+"<br>");
%>