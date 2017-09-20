<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>实现计算器功能</title>
  
  </head>
  
  <body>
  <form name="form1" action="showresult.jsp">
  	<input type="text" name="num1">
  	<select name="sign">
  		<option value="1" selected>+</option>
  		<option value="2">-</option>
  		<option value="3">*</option>
  		<option value="4">/</option>
  	</select>
  	<input type="text" name="num2">
  	<input type="submit" value="计算">
  </form>
  </body>
</html>
