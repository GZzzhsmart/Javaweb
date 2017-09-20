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
    
    <title>标准标签库的使用</title>
  </head>
  
  <body>
  	<h1 align="center">标准标签库的使用</h1>
  	<hr/>
  	<h3>c:set标签定义变量</h3>
  	<c:set var="test" value="${requestScope.qqcode}"></c:set>
  	<c:out value="${test}" default="未定义"></c:out><br/>
  	<c:set var="isok" value="true"></c:set>
  	${applicationScope.qqcode }<br/>
  	
  	<c:if test="${isok=='true'}">
  		<c:out value="isok等于true"></c:out>
  	</c:if>
  	<c:if test="${isok!='true'}">	
  		<c:out value="isok不等于true"></c:out>
  	</c:if>
  	
  	<h1>forEach循环语句</h1>
  	<hr/>
  	<table border="0">
  	<c:forEach begin="1" end="9" step="1" var="dd" varStatus="st">
  		<c:if test="${dd mod 2 == 0}">
  			<tr bgcolor="cyan">
  		</c:if>
  		<c:if test="${dd mod 2 == 1}">
			<tr bgcolor="yellow">
  		</c:if>
  		<c:forEach begin="1" end="${dd}" var="ddd">
  			<td>${ddd}*${dd }=${ddd*dd }&nbsp;&nbsp;&nbsp;&nbsp;</td>
  		</c:forEach>
  	</c:forEach>
  </body>
</html>
