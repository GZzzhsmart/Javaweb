<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    <title>PageContext.jsp</title>
  </head>
  
  <body>
  	<h2>在pageContext中取得不同范围内定义的属性值的用法</h2>
  	<%
  		pageContext.setAttribute("number","2");
  		request.setAttribute("number","3");
  		session.setAttribute("number","4");
  		application.setAttribute("number","5");
  	 %>
  	 分别通过各自的隐含对象进行初始设置
	<table border="1" width="30%">
	<tr>
	  <th>pageScope.number</th>
	  <td><%= pageContext.getAttribute("number")%></td>
	</tr>
	<tr>
	  <th>requestScope.number</th>
	  <td><%= request.getAttribute("number")%></td>
	</tr>
	<tr>
	  <th>sessionScope.number</th>
	  <td><%= session.getAttribute("number")%></td>
	</tr>
	<tr>
	  <th>applicationScope.number</th>
	  <td><%= application.getAttribute("number")%></td>
	</tr>
	</table></br>
  	 <%
  	 	pageContext.setAttribute("number1","2",pageContext.PAGE_SCOPE);
  	 	pageContext.setAttribute("number2","3",pageContext.REQUEST_SCOPE);
  	 	pageContext.setAttribute("number3","4",pageContext.SESSION_SCOPE);
  	 	pageContext.setAttribute("number4","5",pageContext.APPLICATION_SCOPE);
  	  %>
  	  通过pageContext隐含对象为不同范围的对象进行初始设置
  	  <tr>
		  <th>pageScope.number</th>
		  <td><%= pageContext.getAttribute("number1",pageContext.PAGE_SCOPE)%></td>
	  </tr>
	  <tr>
	  	<th>requestScope.number</th>
	  	<td><%=pageContext.getAttribute("number2",pageContext.REQUEST_SCOPE) %></td>
	  </tr>
	  <tr>
	  	<th>sessionScope.number</th>
	  	<td><%=pageContext.getAttribute("number3",pageContext.SESSION_SCOPE) %></td>
	  </tr>
	  <tr>
	  	<th>applicationScope.number</th>
	  	<td><%=pageContext.getAttribute("number4",pageContext.APPLICATION_SCOPE) %></td>
	  </tr>
  </body>
</html>
