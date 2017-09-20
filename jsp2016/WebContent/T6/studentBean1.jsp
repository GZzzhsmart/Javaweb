<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>javabean的使用二</title>
  </head>
  
  <body>
    <h1 align="center">javabean的使用二</h1>
    <hr/>
    <jsp:useBean id="stud" class="T6.Student" scope="page">
    	<jsp:setProperty name="stud" property="studid" value="1002"/>
    	<jsp:setProperty name="stud" property="studName" value="小丽"/>
    	<jsp:setProperty name="stud" property="age" value="16"/>
    </jsp:useBean>
   	<jsp:setProperty name="stud" property="sex" value="女"/>
   	<jsp:setProperty name="stud" property="className" value="宏图201601"/>
    
     学号：<jsp:getProperty property="studid" name="stud"/><br/>
     姓名：<jsp:getProperty property="studName" name="stud"/><br/>
     年龄：<jsp:getProperty property="age" name="stud"/><br/>
     性别：<jsp:getProperty property="sex" name="stud"/><br/>
     班级：<%=stud.getClassName() %><br/>
     兴趣爱好：<br/>
     婚姻状况：<jsp:getProperty property="marry" name="stud"/><br/>
    
  </body>
</html>
