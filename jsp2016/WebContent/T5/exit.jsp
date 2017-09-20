<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.getAttribute("username1")==null){
		response.sendRedirect("login.jsp");
	}
	//session.invalidate();
	//out.println("username="+session.getAttribute("username")+"<br/>");
%>