<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>第一个动态页面</title>
    
  </head>
  
  <body>
   <%  out.print("<p style='color:red;font-size:16pt;'>你好，世界！"); 
    java.util.Date date = new java.util.Date();
	out.print(date.toLocaleString());
	out.print("</p>");
%>
  </body>
</html>
