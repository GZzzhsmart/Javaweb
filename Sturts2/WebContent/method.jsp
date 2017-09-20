<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>函数的运用</title>
    
	
  </head>
  
  <body>
    <h1 align="center">函数的运用</h1>
    <hr/>
    <a href="${pageContext.request.contextPath}/methodAction.action?action=execute">调用execute函数</a><br/>
    <a href="${pageContext.request.contextPath}/methodAction1.action?action=add">调用add函数</a><br/>
    <a href="${pageContext.request.contextPath}/methodAction!del.action?action=del">调用del函数</a><br/>
    <a href="${pageContext.request.contextPath}/methodAction2.action?action=update">调用update函数</a><br/>
    <a href="${pageContext.request.contextPath}/methodAction!save.action?action=save">调用save函数</a><br/>
    <a href="${pageContext.request.contextPath}/methodAction3.action?action=list">调用list函数</a><br/>
  </body>
</html>
