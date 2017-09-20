<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>set标签的使用</title>
    
  </head>
  
  <body>
    <h1>set和remove标签的用法</h1>
	<c:set  scope="page" var="number">
		<c:out value="${1+1}"/>
	</c:set>    
	<c:set scope="request" var="number">
		<%=3 %>
	</c:set>
	<c:set scope="session" var="number">
		4
	</c:set>
	初始化设置
	<table border="1" width="30%">
		<tr>
			<th>pageScope.number</th>
			<td><c:out value="${pageScope.number}" default="No Data"/></td>
		</tr>
		<tr>
			<th>requestScope.number</th>
			<td><c:out value="${requestScope.number}" default="No Data"/></td>
		</tr>
		<tr>
			<th>sessionScope.number</th>
			<td><c:out value="${sessionScope.number}" default="No Data"/></td>
		</tr>
	</table><br/>
	
	<c:out value='<c:remove var="number" scope="page"/>之后'/>
	<c:remove var="number" scope="page"/>
	<table border="1" width="30%">
		<tr>
			<th>pageScope.number</th>
			<td><c:out value="${pageScope.number}" default="No Data"/></td>
		</tr>
		<tr>
			<th>requestScope.number</th>
			<td><c:out value="${requestScope.number}" default="No Data"/></td>
		</tr>
		<tr>
			<th>sessionScope.number</th>
			<td><c:out value="${sessionScope.number}" default="No Data"/></td>
		</tr>
	</table><br/>
	
	<c:out value='<c:remove var="number"/>之后'/>
	<c:remove var="number"/>
	<table border="1" width="30%">
		<tr>
			<th>pageScope.number</th>
			<td><c:out value="${pageScope.number}" default="No Data"/></td>
		</tr>
		<tr>
			<th>requestScope.number</th>
			<td><c:out value="${requestScope.number}" default="No Data"/></td>
		</tr>
		<tr>
			<th>sessionScope.number</th>
			<td><c:out value="${sessionScope.number}" default="No Data"/></td>
		</tr>
	</table>
  </body>
</html>
			