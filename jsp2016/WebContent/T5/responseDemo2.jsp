<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>response对象详解</title>
  </head>
  
  <body>
  	<h1>response对象详解</h1>
  	<hr/>
  	<%!
  		int cnt=0;
  	 %>
  	 <%
  	 //设置网页每隔五秒刷新一次
  	 	response.setIntHeader("refresh",5);
  	  %>
  	  cnt=<%=cnt++ %>
  </body>
</html>
