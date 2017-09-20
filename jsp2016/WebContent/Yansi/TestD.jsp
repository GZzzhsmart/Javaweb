<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="Yansi.TestBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>TestD.jsp</title>
  </head>
  <jsp:useBean id="TestBean" class="Yansi.TestBean" scope="request">
  	<jsp:setProperty name="TestBean" property="*"/>
  </jsp:useBean>
  <body bgcolor="#ffffff">
  	<form action="" method="post">
  		<%=TestBean.hello() %>
  	</form>
  </body>
</html>
