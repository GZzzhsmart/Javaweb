<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录失败页面</title>
    

  </head>
  
  <body>
  	<%
  		String name = request.getParameter("name");
  		
  		out.println(name+"登录失败，用户名或密码错误!");
  	 %>
  </body>
</html>
