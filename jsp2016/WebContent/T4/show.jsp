<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>show.jsp</title>
    </head>
  <body>
    <%=session.getAttribute("username") %>您好，欢迎您登录！<br/>
    <h1 align="center">登录列表</h1>
    <hr/>
    <%
    	ArrayList list3 = (ArrayList)application.getAttribute("list3");
    	for(int i=0;i<list3.size();i++){
    		out.println(list3.get(i)+"你是第"+(i+1)+"个用户");
    		out.println("<br/>");
    	}
     %>
    
  </body>
</html>
