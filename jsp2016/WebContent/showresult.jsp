<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title></title>
   
  </head>
  
  <body>
    <%
    	int num1 = Integer.parseInt(request.getParameter("num1"));
    	int num2 = Integer.parseInt(request.getParameter("num2"));
    	int sign = Integer.parseInt(request.getParameter("sign"));
    	int total=0;
    	switch(sign){
    		case 1:
    			total = num1+num2;
    			break;
    		case 2:
    			total = num1-num2;
    			break;
    		case 3:
    		 	total = num1*num2;
    		 	break;
    		 case 4:
    		 	total = num1/num2;
    		 	break;
    	}
    	out.print("结果："+total);
     %>
  </body>
</html>
