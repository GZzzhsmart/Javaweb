<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册成功</title>
  </head>
  
  <body>
    <h1 align="center">恭喜你注册成功，你的信息如下：</h1>
    <hr/>
    学生学号：<s:property value="stud.studid"/><br/>
    学生姓名：<s:property value="stud.studname"/><br/>
    学生年龄：<s:property value="stud.age"/><br/>
	学生性别：${stud.sex }<br/>
	身份证号：${stud.cardid }<br/>
	所在班级：${stud.classid }<br/>
	<a href="studentAction!get.action?stud.studid=${stud.studid}">修改</a><br/>
	<a href="studentAction!del.action?stud.studid=${stud.studid}" onclick="return confirm('删除确定');">删除</a><br/>
  </body>
</html>
