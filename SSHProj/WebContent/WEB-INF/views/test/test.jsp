<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>Insert title here</title>
</head>
<body>
	<form action="<%=path %>/test/add" method="post">
		<input type="text" name="test.name" />
		<input type="submit" />
	</form>
</body>
</html>