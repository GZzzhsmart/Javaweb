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
    
    <title>学生资料管理</title>
  </head>
  
  <body>
    <h1 align="center">学生资料管理</h1>
    <hr/>
    <s:form name="form1" method="post" action="studentAction!save.action">
    	<s:textfield name="stud.studid" label="学生学号" style="width:170px"/>
    	<s:textfield name="stud.studname" label="学生姓名" style="width:170px"/>
    	<s:textfield name="stud.age" label="学生年龄" style="width:170px"/>
    	<s:select name="stud.sex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" label="学生性别" style="width:170px"/>
    	<s:textfield name="stud.cardid" label="身份证号" style="width:170px"/>
    	<s:select name="stud.classid" list="#{'1':'宏图201601班','2':'宏图201602班','3':'宏图201603班','4':'宏图201604班'}" listKey="key" listValue="value" label="所在班级" style="width:170px"/>
    	<s:submit value="  保 存  "></s:submit>
    </s:form>
  </body>
</html>
