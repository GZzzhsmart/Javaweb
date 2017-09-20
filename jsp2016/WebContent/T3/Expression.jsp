<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Date" %>
<html>
  <head>
    
    <title>Expression.jsp</title>
  
  </head>
  
  <body bgcolor="#ffffff">
  	<center>
  		<%!Date date = new Date(); %>
  		<%!int a,b,c; %>
  		<%a=12;b=a;c=a+b; %>
  		<font color="blue">
  			<%=date.toString() %>
  		</font>\u00A0<br>
  		<b>a=<%= a %></b><br>
  		<b>b=<%= b %></b><br>
  		<b>c=<%= c %></b><br>
  	</center>
  </body>
</html>
