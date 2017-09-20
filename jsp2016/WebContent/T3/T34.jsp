<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>错误处理</title>
    
	

  </head>
  
  <body>
   <h1>当前页面出现错误，跳转到error.jsp页面进行处理</h1>
   <hr/>
  </body>
</html>
