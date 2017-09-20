<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="Yansi.Calulate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>计算器</title>
  </head>
 <jsp:useBean id="jisuan" class="T6.Jisuanqi">
  	<jsp:setProperty name="jisuan"property="*"/>
  </jsp:useBean>
  <%
  	double result = jisuan.result(jisuan.getNum1(),jisuan.getNum2(),jisuan.getSign());
  	out.println(result);
  %>
  <body>
  	<form action="Yansi/calulate.jsp" name="form1" method="post">
  		<input type="text" name="num1">
  			<select name="sign">
  				<option value="1">+</option>
  				<option value="2">-</option>
  				<option value="3">*</option>
  				<option value="4">/</option>
  			</select>
  		<input type="text" name="num2">
  		<input type="submit" value="计算">
  	</form>
  </body>
</html>
