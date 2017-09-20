<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
  
  </head>
  
  <body>
   <form action="./loginServlet2" name="login" method="post">
   	<p> 姓名：<input type="text" name="name" size="20"></p>
   	<p> 密码：<input type="password" name="password" size="20"></p>
   	
   	<input type="submit" value="提交">
   	<input type="reset" value="清除">
   </form>
  </body>
</html>
