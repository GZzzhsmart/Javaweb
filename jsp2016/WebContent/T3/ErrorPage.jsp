<%@ page contentType="text/html;charset=utf-8" errorPage="error.jsp"%>

<html>
  <head>
   <title>ErrorPage.jsp</title>
 
  </head>
  
  <body>
    <h2>errorPage的范例程序</h2>
    <%!
    	private double toDouble(String value){
    		return(Double.valueOf(value).doubleValue());
    	}
     %>
     <%
     	double num1 = toDouble(request.getParameter("num1"));
     	double num2 = toDouble(request.getParameter("num2"));
      %>
      您传入的两个数字为：<%=num1 %>和<%=num2 %><br>
      两个数字相加为：<%=(num1+num2) %>
  </body>
</html>
