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
    
    <title>c:choose标签的使用</title>

  </head>
  
  <body>
  	<h1>choose标签的使用</h1>
  	<hr/>
  	<c:forEach var="index" begin="0" end="4">
  		# ${index }
  		<c:choose>
  			<c:when test="${index==1}">
  				one!<br/>
  			</c:when>
  			<c:when test="${index==4}">
  				four!<br/>
  			</c:when>
  			<c:when test="${index==3}">
  				three!<br/>
  			</c:when>
  			<c:otherwise>
  				Huh!<br/>
  			</c:otherwise>
  		</c:choose>
  	</c:forEach>
  </body>
</html>
