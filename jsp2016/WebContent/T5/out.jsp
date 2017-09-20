<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>out隐含对象</title>
  </head>
  
  <body>
  	<h1>out隐含对象</h1>
  	<hr/>
  	<%
  		int buffersize = out.getBufferSize();//获取总的内存
  		int available = out.getRemaining();//获取空余的内存
  		int used = buffersize-available;
  	 %>
  	 初始化信息值：<br/>
  	 
  	 buffersize=<%=buffersize %>byte<br/>
  	 available=<%=available %>byte<br/>
  	 used=<%=used %>byte<br/>
  </body>
</html>
