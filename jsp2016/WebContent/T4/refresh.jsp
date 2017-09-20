<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>

<html>
  <head>
    <title>response应用实例</title>
    
  </head>
  
  <body>
  	<%
  		//设置每1秒刷新一次
  		response.setHeader("refresh","1");
  		//获取当前时间
  		out.println(new Date().toLocaleString());
  	 %>
  </body>
</html>
