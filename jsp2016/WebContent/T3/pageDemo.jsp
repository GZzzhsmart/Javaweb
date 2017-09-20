<%@ page language="java" pageEncoding="GB2312" errorPage="error.jsp"%>
<%@ page import="java.util.Date" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  
    <title>page的指令使用</title>
 
  </head>
  
  <body>
    <h1><br></h1><h1>page指令的使用</h1>
    <hr/>
    	当前时间是：<%=new Date().toLocaleString() %>
    	<%=20/0 %>
  </body>
</html>
