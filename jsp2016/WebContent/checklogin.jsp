<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>登录</title>
    
  </head>
  
  <body>
    <%
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	if(username.equals("name")&&password.equals("1111")){
    		out.print("<p> 欢迎,"+username+"</p>");
    	}else{
    		out.print("<p>登录失败!用户名或密码不对!</p>");
    	}
     %>
  </body>
</html>
