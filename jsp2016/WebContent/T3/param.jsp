<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.Date" %>


<html>
  <head>
  </head>
  
  <body>
  <hr color="cyan"/>
    <%
    	Date date = new Date();
    	out.println("现在时间是："+date.toLocaleString());
    	int n = Integer.parseInt(request.getParameter("count"));
    	for(int i=0;i<n;i++){
    		out.println("<br> 欢迎您来到QQ浏览器！");
    	}
     %>
  </body>
</html>
