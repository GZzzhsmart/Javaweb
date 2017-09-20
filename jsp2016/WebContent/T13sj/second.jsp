<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>介绍信息</title>
  </head>
  
  <body bgcolor="#ffffff">
    <h1>介绍信息</h1>
    <%
    	String test = request.getParameter("test");
    	if(test!=null){
    		//中文处理
    		byte[] bt = test.getBytes("ISO-8859-1");
    		String str = new String(bt,"utf-8");
    		test=str;
    	}
    	out.println(test);
     %>
  </body>
</html>
