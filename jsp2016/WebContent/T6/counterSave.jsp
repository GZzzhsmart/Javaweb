<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="T6.Counter"%>
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
   
   <jsp:useBean id="counter1" class="T6.Counter" scope="request">
    	<jsp:setProperty name="counter1" property="username"/>
    </jsp:useBean>
    
    <jsp:useBean id="counter" class="T6.Counter" scope="application">
    	<jsp:setProperty name="counter" property="count"/>
    </jsp:useBean>
    
     <jsp:getProperty name="counter1" property="username"/>您好,您是第<jsp:getProperty name="counter" property="count"/>位访问本网站的客人，欢迎您！
  </body>
</html>
