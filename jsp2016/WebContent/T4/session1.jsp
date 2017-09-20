<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    <title>My JSP 'session1.jsp' starting page</title>
    
	
  </head>
  
  <body>
  	<%
  		session.setAttribute("username","nick");
  		session.setAttribute("password","brower");
  	 %>
  	 <jsp:forward page="session2.jsp"/>
  </body>
</html>
