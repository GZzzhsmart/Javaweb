<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>
next
</title>
</head>
<body bgcolor="#ffffff">
<h1>
接收到的信息如下：
</h1>
<%
String userid=request.getParameter("userid");
String username=request.getParameter("username");
String password=request.getParameter("password");
out.println("userid:"+userid+"<br>");
out.println("username:"+username+"<br>");
out.println("password:"+password);

%>
</body>
</html>
