<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>session对象讲解</title>
    
    </head>
  
  <body>
    <h1>session对象讲解</h1>
    <hr/>
    <%
    	session.setAttribute("username","admin");
    	out.println("username是否为新变量="+session.isNew()+"<br/>");
    	out.println("session的最大不活动有效期："+session.getMaxInactiveInterval()/60+"分钟<br/>");
    	out.println("username="+session.getAttribute("username")+"<br/>");
    	
    	session.setAttribute("username","administrator");
    	out.println("username="+session.getAttribute("username")+"<br/>");
    	out.println("username是否为新变量="+session.isNew()+"<br/>");
    	
     %>
     <a href="T5/exit.jsp">安全退出</a>
  </body>
</html>
