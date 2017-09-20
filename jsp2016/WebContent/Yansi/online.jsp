<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计在线人数</title>
    
	
  </head>
  
  <body onunload="javascript:alert('ok');" >
    <h1 align="center">统计在线人数</h1>
    <hr/>
    <h2 align="center">
    当前在线人数是:<%=application.getAttribute("count") %>
    </h2>
    <hr>
    <a href="Yansi/exit.jsp">安全退出</a>
    <table>
    
    </table>
  </body>
</html>
