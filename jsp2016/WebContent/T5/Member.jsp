<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>Member.jsp</title>
  </head>
  <body>
  	<h2>javax.servlet.http.HttpSession - session 对象</h2>
  	<hr/>
  	<%
  		String login1 = (String)session.getAttribute("login1");
  		if(login1!=null&&login1.equals("ok")){
  			out.println("欢迎进入");
  			session.invalidate();
  		}else{
  			out.println("请先登录");
  			out.println("经过5秒之后，网页会自动返回login1.jsp");
  			
  			response.setHeader("refresh","5;url=login1.jsp");
  		}
  	 %>
  </body>
</html>
