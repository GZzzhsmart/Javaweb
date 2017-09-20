<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    <title>response对象讲解</title>
  </head>
  
  <body>
  	<h1>response对象讲解</h1>
  	<hr/>
  	<%!
    	int cnt=0;
     %>
     <%
     	//设置网页每隔5秒钟刷新一次
     	//response.setIntHeader("refresh",5);
     	//等待5秒钟以后重定向到指定的页面
     	response.setHeader("refresh","5;url=http://www.baidu.com");
      %>
  		cnt=<%=cnt++ %>
  </body>
</html>
