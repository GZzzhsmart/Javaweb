<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>统计网站的在线人数</title>
  </head>
  
  <body>
  <h1>统计网站的在线人数</h1>
  <hr/>
  	<form action="Yansi/counterSave.jsp" method="get" name="form1">
  		<input type="text" name="username">
  		<input type="submit" value="进入系统">
  	</form>
  </body>
</html>
