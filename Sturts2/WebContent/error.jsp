<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出错了</title>
    

  </head>
  
  <body>
    <h1 align="center">不允许重复添加</h1>
    <hr/>
    <a href="empAdd.jsp">新增员工</a>
  </body>
</html>
