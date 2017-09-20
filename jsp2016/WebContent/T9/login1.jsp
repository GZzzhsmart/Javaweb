<%@ page contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>login</title>
</head>
<body bgcolor="#ffffff">
<h1>登录页面</h1>
<%
	if (request.getAttribute("isLogin").equals("ok")){
	   session.setAttribute("isLogin","ok");
	   response.sendRedirect("index.jsp");
	}else{
	   %>
	   
	   <form  action="<%=basePath %>/T9/index.jsp" method="post" >
	   用户名：<input type="text" name="username">
	   <br>密&nbsp;&nbsp;码：<input type="password" name="password">
	   <br><input type="submit" name="submit" value="登录">
	   </form>
	   <%
  	}
  %>
</body>
</html>
