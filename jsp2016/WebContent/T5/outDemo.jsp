<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>out对象的讲解e</title>
  </head>
  
  <body>
    <h1>out对象的讲解</h1>
    <hr/>
    <%
    	out.println("用out对象输出内容<br/>");
    	out.println("缓存大小："+out.getBufferSize()+"<br/>");
    	out.println("还剩下的缓冲区大小："+out.getRemaining()+"<br/>");
     %>
  </body>
</html>
