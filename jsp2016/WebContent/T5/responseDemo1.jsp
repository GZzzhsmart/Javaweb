<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>response对象详解</title>
    	<meta http-equiv="refresh" content="5">
    
  </head>
  
  <body>
  	<h1>response对象详解</h1>
  	<hr/>
  	<%!
  		int cnt=0;
  	 %>
  	 cnt=<%=cnt++ %>
  </body>
</html>
