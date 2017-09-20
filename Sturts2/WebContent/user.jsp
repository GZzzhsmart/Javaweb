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
    
    <title>演示拦截器权限控制</title>
  </head>
  
  <body>
    <h1 align="center">演示拦截器权限控制</h1>
    <hr/>
    <a href="userAction!init.action">执行init函数</a><br/>
    <a href="userAction!add.action">执行add函数</a><br/>
    <a href="userAction!update.action">执行update函数</a><br/>
    <a href="userAction!list.action">执行list函数</a><br/>
    <a href="userAction!del.action">执行del函数</a><br/>
    <a href="userAction!save.action">执行save函数</a><br/>
    <a href="userAction!login.action">执行login函数</a><br/>
  </body>
</html>
