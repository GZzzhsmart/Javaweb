<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>login1.jsp</title>
  </head>
  <body>
  	<h2>javax.servlet.http.HttpSession - session 对象</h2> 
  	<form action="login1.jsp" method="post" name="form1">
  		login name:<input type="text" name="username"><br/>
  		login password:<input type="password" name="password"><br/>
  		<input type="submit" value="send"><br/>
  	</form>
  	<%
  		if(request.getParameter("username")!=null && request.getParameter("password")!=null){
  			String username = request.getParameter("username");
  			String password = request.getParameter("password");
  			
  			if(username.equals("admin")&&password.equals("1234")){
  				session.setAttribute("login1","ok");
  				response.sendRedirect("Member.jsp");
  			}else{
  				out.println("登录错误，请输入正确的名称");
  			}
  		}
  	 %>
  </body>
</html>
