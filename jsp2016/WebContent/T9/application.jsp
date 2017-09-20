<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'application.jsp' starting page</title>

  </head>
  
  <body>
    	<h1 align="center">ServletContext监听器测试</h1>
    	<hr/>
    	<%
    		//创建一个变量
    		application.setAttribute("count","1");
    		//修改变量的值
    		application.setAttribute("count","2");
    		//删除变量
    		application.removeAttribute("count");
    		
    	 %>
  </body>
</html>
