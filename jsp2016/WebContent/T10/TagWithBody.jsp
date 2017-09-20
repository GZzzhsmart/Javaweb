<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="Body" uri="/demotag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Tag With Body</title>
    
  </head>
  
  <body>
    <h1>Tag With Body</h1>
  
    <hr>
    <Body:TagWithBody counts="5">
    	现在时间是：<%=new java.util.Date() %><br/>
    </Body:TagWithBody>
  </body>
 	 </hr>
</html>
