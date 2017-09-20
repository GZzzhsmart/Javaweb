<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    	//获取参数
    	String username=request.getParameter("username");
    	System.out.println("username="+username);
    	out.println(username);
    	session.setAttribute("username",username);
     %>
     <a href="exit.jsp">安全退出</a>