<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>url重写</title>
  </head>
  
  <body bgcolor="#ffffff">
  	<h1 align="center">url重写</h1>
  	<hr/>
  	<a href="second.jsp?test='这是从上一个页面传递过来的信息'">下一页</a>
  </body>
</html>
