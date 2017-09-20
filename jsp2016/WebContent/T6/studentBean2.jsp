<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="T6.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>javabean的使用三</title>
  </head>
  
  <body>
    <h1 align="center">javabean的使用三</h1>
    <hr/>
    <%
    request.setCharacterEncoding("utf-8"); 
    %>
    <jsp:useBean id="stud" class="T6.Student" scope="request">
    	<jsp:setProperty name="stud" property="*"/>
    </jsp:useBean>
   <%stud.setStudid(Integer.parseInt(request.getParameter("Studid"))); %>
    
     学号：<jsp:getProperty property="studid" name="stud"/><br/>
     姓名：<jsp:getProperty property="studName" name="stud"/><br/>
     年龄：<jsp:getProperty property="age" name="stud"/><br/>
     性别：<jsp:getProperty property="sex" name="stud"/><br/>
     班级：<%=stud.getClassName() %><br/>
     <%
     	String hob="";
     	for(int i=0;i<stud.getHobit().length;i++){
     		hob+= stud.getHobit(i)+",";
     	}
     	//解决爱好后面的逗号问题
     	hob=hob.substring(0,hob.length()-1);
      %>
     兴趣爱好：<%=hob %><br/>
     婚姻状况：<jsp:getProperty property="marry" name="stud"/><br/>
    
  </body>
</html>
