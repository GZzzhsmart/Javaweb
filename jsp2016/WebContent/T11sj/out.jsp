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
    
    <title>测试你使用的JSTL网页</title>
    
  </head>
  
  <body>
    <h1>用c:out测试你使用的JSTL网页</h1>
    <hr/>
    <c:out value="欢迎测试使用的JSTL网页"/>
    <br>你是使用的浏览器是：
    <c:out value="${header['User-Agent']}"/>
    <c:set var="a" value="Hello Huge!"/><br>
    <c:out value="Hello World!"/><br>
    <c:out value="${a}"/><br>
    
    <hr/>
    <c:if test="${param.username=='admin'}" var="condition" scope="page">
    	您好：admin先生
    </c:if><br/>
    执行结果是：${condition }
  </body>
</html>
