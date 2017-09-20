<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录成功</title>

  </head>
  
  <body>
    <h1 align="center">登录成功</h1>
    <hr/>
    <!-- request范围内info的值 -->
    <font color="red"><%=request.getAttribute("info") %></font><br/>
    <!-- session范围内的info值 -->
    <font color="red"><%=session.getAttribute("info") %></font><br/>
    <!-- application范围内的info值 -->
    <font color="red"><%=application.getAttribute("info") %></font><br/>
  </body>
</html>
