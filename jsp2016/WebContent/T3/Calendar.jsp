<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<html>
  <head>
    
    <title>Calendar.jsp</title>
    
	
  </head>
  
  <body bgcolor="#ffffff">
    <%
    	Date date = new Date();
    	out.println("现在时间是："+date.toLocaleString());
    	if(Calendar.getInstance().get(Calendar.AM_PM)==Calendar.AM){
     %>
     早上好！
     <%
     	}else{
      %>
      下午好！
      <%
      	}
       %>
  </body>
</html>
