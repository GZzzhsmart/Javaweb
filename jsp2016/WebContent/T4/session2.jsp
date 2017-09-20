<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
  <head>
   
    
    <title>My JSP 'session2.jsp' starting page</title>
    
	

  </head>
  
  <body>
    <%
    	String username = (String)session.getAttribute("username");
    	String password = (String)session.getAttribute("password");
    	out.println("username="+username);
    	out.println("password="+password);
     %>
  </body>
</html>
