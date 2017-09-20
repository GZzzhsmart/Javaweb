<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>check1.jsp</title>
  </head>
  <body>
  	<%
  		//乱码处理
  		request.setCharacterEncoding("utf-8");
  		response.setContentType("text/html;charset=utf-8");
		session.setAttribute("username",request.getParameter("username"));
		ArrayList list3 = new ArrayList();  	
		if(application.getAttribute("list3")==null){
			list3.add(request.getParameter("username"));
			application.setAttribute("list3",list3);
			//重定向
			response.sendRedirect("show.jsp");
		}else{
			list3=(ArrayList)application.getAttribute("list3");
			list3.add(request.getParameter("username"));
			application.setAttribute("list3",list3);
			response.sendRedirect("show.jsp");
		}
  	 %>
  </body>
</html>
