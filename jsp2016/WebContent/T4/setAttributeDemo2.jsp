<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>获取变量的值</title>
    
  </head>
  
  <body>
  	<h1>获取pageContext,request,session,application对象定义变量</h1>
  	<h1>setAttributeDemo2页面的值如下：</h1>
  		pageContext=<%=pageContext.getAttribute("pageContext") %><br/>
  		request=<%=request.getAttribute("request") %><br/>
  		session=<%=session.getAttribute("session") %><br/>
  		application=<%=application.getAttribute("application") %><br/>
  		<a href="T4/setAttributeDemo3.jsp">链接到setAttributeDemo3页面</a>
  </body>
</html>
