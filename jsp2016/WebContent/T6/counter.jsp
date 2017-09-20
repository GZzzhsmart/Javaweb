<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计访问人数</title>
  </head>
  
  <body>
    <h1 align="center">统计访问人数</h1>
    <hr/>
    <form name="form1" action="T6/counterSave.jsp" method="get">
    	<input type="text" name="username">
    	<input type="submit" value="进入系统">
    </form>
  </body>
</html>
