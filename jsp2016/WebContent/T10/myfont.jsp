<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="myfont" uri="/demotag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="refresh" content="5">
    <title>在jsp中调用myfont标签</title>
	
  </head>
  现在时间是：<%=new java.util.Date()%>
  <body>
    <h2><font face="宋体" color="green">在jsp中调用myfont标签</font></h2>
    <hr/>
    <myfont:Myfont color="red" fontSize="2" bgcolor="#cococo">
    	四十三年，烽火扬州路
    </myfont:Myfont><br/>
	<myfont:Myfont color="blue">
		可堪回首，佛狸祠下
	</myfont:Myfont><br/>
	<myfont:Myfont color="cyan" border="3" bgcolor="red">
		一片神鸦社鼓
	</myfont:Myfont><br/>
	<myfont:Myfont color="yellow" fontSize="5" bgcolor="#cococo">
		凭谁问，廉颇老矣
	</myfont:Myfont><br/>
	<myfont:Myfont color="green" border="7" bgcolor="#123456" fontSize="6">
		尚能饭否？
	</myfont:Myfont><br/>
  </body>
</html>
