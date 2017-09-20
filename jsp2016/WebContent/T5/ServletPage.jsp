<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>连接数据库</title>
    
  </head>
  
  <body>
   <h1 align="center">连接数据库</h1>
   <hr/>
   <%
   		String driver = config.getInitParameter("driver");
   		String url = config.getInitParameter("url");
   		String username = config.getInitParameter("username");
   		String password = config.getInitParameter("password");
   		Class.forName(driver);
   		Connection conn = DriverManager.getConnection(url,username,password);
   		if(!conn.isClosed()){
   			out.println("数据库连接成功；<br/>");
   		}
    %>
    数据库驱动：<%=driver%><br/>
    连接字符串：<%=url%><br/>
    用户名称：<%=username%><br/>
    登录密码：<%=password%><br/>
    <%
    	session.setAttribute("driver",driver);
    	application.setAttribute("url",url);
    
     %>
     <a href="./TestServlet">进入TestServlet</a>
  </body>
</html>
