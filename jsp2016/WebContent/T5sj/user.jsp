<%@ page language="java" contentType="text/html;charset=utf-8"%>
<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>user.jsp</title>
  </head>
  
  <body>
    <%
    	String strname = request.getParameter("username");
    	String strword = request.getParameter("password");
    	Cookie namecookie = new Cookie("name",strname);
    	//设置有效期为10分钟,单位为秒
    	namecookie.setMaxAge(10*60);
    	Cookie wordcookie = new Cookie("word",strword);
    	//设置有效期为10分钟,单位为秒
    	wordcookie.setMaxAge(10*60);
    	response.addCookie(namecookie);
    	response.addCookie(wordcookie);
    	response.sendRedirect("response.jsp");
    	
     %>
  </body>
</html>
