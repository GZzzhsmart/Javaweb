<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="Yansi.counter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计在线的访问人数</title>
    
  </head>
  <body>
    <h1>统计在线的访问人数</h1>
    <hr/>
    <jsp:useBean id="counter1" class="Yansi.counter" scope="request">
    	<jsp:setProperty name="counter1" property="username"/>
    </jsp:useBean>
    
    <jsp:useBean id="counter" class="Yansi.counter" scope="application">
    	<jsp:setProperty name="counter" property="count"/>
    </jsp:useBean>
    
     <%=new String(counter1.getUsername().getBytes("iso-8859-1"),"utf-8") %>您好,您是第
     <jsp:getProperty name="counter" property="count"/>位访问本网站的客人，欢迎您！
  </body>
</html>
