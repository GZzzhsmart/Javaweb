<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    
    <title>软件使用意见反馈结果</title>
    
	
  </head>
  
  <body>
   <h1 align="center">软件使用意见反馈结果</h1>
   <hr/>
   <%
   		
    	request.setCharacterEncoding("utf-8");
    	out.println("姓名："+request.getParameter("username") +"<br/>");
    	out.println("E_mail:"+request.getParameter("email") +"<br/>");
    	out.println("电话："+request.getParameter("phone") +"<br/>");
    	out.println("软件："+request.getParameter("soft") +"<br/>");
    	out.println("操作系统："+request.getParameter("os") +"<br/>");
    	out.println("问题描述："+request.getParameter("remark") +"<br/>");
    
    %>
  </body>
</html>
