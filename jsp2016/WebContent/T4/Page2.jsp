<%@ page contentType="text/html;charset=utf-8"%>


<html>
  <head>
    
    <title>Page2.jsp</title>
    

  </head>
  
  <body>
  	<%
  		String name = (String)application.getAttribute("name");
  		String password = (String)application.getAttribute("password");
  		out.println("name="+name);
  		out.println("password="+password);
  	 %>
  </body>
</html>
