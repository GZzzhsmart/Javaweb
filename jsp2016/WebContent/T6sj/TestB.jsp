<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="T6.TestBean"%>
<html>
  <head>
    <title>TestB.jsp</title>
  </head>
  <body bgcolor="#ffffff">
  <jsp:useBean id="TestBean" class="T6.TestBean" scope="request">
  	<jsp:setProperty name="TestBean" property="*"/>
  </jsp:useBean>
	<form action="" method="post">
  		<%=TestBean.hello() %>
  	</form>
  </body>
</html>
