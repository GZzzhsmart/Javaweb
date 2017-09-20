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
    <h1 align="center">权限控制</h1>
    <hr/>
    <font size="4" color="red"><b>对不起，你没有执行该操作的权限</b></font>
  </body>
</html>
