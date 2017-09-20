<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
</head>
<body>
	<a href="<%=path%>/login.jsp">返回</a>
	<h1 align="center">恭喜你，登录成功</h1>
</body>
</html>