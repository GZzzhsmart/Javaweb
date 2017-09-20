<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
	
  </head>
  
  <body>
    <h1 align="center">用户登录</h1>
    <hr/>
    <form action="login.action" method="post">
    用户名：<input type="text" name="username"/>
    密  码：<input type="password" name="password"/>
    <input type="submit" value="登录"/>
    </form>
  </body>
</html>
