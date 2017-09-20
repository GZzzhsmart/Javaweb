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
    
    <title>foreach.jsp</title>
  </head>
  
  <body>
  	<h1>begin end step 的用法</h1>
  	<hr/>
  	<%
  		String atts[] = new String[5];
  		atts[0]="hello";
  		atts[1]="this";
  		atts[2]="is";
  		atts[3]="a";
  		atts[4]="pen.";
  		request.setAttribute("atts",atts);
  	%>
  	
  	<c:forEach items="${atts}" var="items" begin="1" end="4" step="2">
  		${items }&nbsp;
  	</c:forEach>
  	
  	<h1>fortokens的用法</h1>
  	<hr/>
  	
  	拆分前：H-e-l-l-o
  	
  	拆分后：
  	
  	<c:forTokens var="token" items="H-e-l-l-o" delims="-">
  		<c:out value="${token}"/>
  	</c:forTokens>
  </body>
</html>
