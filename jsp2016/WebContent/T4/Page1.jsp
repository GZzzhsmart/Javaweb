<%@ page contentType="text/html;charset=utf-8"%>


<html>
  <head>
    
    <title>Page1.jsp</title>
    
  </head>
  
  <body>
  	<%
  		application.setAttribute("name","nick");
  		application.setAttribute("password","brower");
  	 %>
  	 <jsp:forward page="Page2.jsp"/>
  </body>
</html>
