<%@ page language="java"contentType="text/html;charset=utf-8"%>

  	<%
  		String name = request.getParameter("username");
  		
  		out.println(name+"登录成功");
  	 %>