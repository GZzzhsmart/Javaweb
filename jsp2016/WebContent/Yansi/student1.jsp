<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="Yansi.Student"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>结果显示</title>
   
  </head>
  
  <body>
    <h1>结果显示</h1>
    <hr/>
    <%
  	  request.setCharacterEncoding("utf-8"); 
    %>
    <jsp:useBean id="student" class="Yansi.Student" scope="request">
    	<jsp:setProperty name="student" property="*"/>
    </jsp:useBean>
     姓名：<jsp:getProperty property="username" name="student"/><br/>
     电话号码：<jsp:getProperty property="phone" name="student"/><br/>
     年龄：<jsp:getProperty property="age" name="student"/><br/>
     性别：<jsp:getProperty property="sex" name="student"/><br/>
     受教育程度：<jsp:getProperty property="education" name="student"/><br/>
     <%
     	String hob="";
     	for(int i=0;i<student.getHobit().length;i++){
     		hob+= student.getHobit(i)+",";
     	}
     	//解决爱好后面的逗号问题
     	hob=hob.substring(0,hob.length()-1);
      %>
     兴趣爱好：<%=hob %><br/>
     
  </body>
</html>
