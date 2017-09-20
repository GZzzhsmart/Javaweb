<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>拦截器执行结果</title>
    
  </head>
  
  <body>
    <h1 align="center">拦截器执行结果</h1>
    <hr/>
    <font size="4" color="red"><b>${msg }</b></font>
  </body>
</html>
