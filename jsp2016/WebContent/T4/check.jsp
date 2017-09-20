<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<html>
  <head>
    
    <title>check.jsp</title>
    
  </head>
  
  <body>
    <h2>javax.servlet.http.HttpServletRequest接口所提供的方法</h2>
    <%	request.setCharacterEncoding("utf-8");%>
    getParameter("username"): <%=request.getParameter("username") %><br>
    getParameter("password"): <%=request.getParameter("password") %><br>
    getAttribute("username"): <%=request.getAttribute("username") %><br>
    getAttribute("password"): <%=request.getAttribute("password") %><br><br>
  </body>
</html>
