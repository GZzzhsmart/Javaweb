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
    
    <title>新增学生信息</title>

  </head>
  
  <body>
    <h1 align="center">学生信息管理</h1>
    <hr/>
    <s:form name="form1" action="studAction.action?order=add" method="post">
   		<table border="1" width="400" align="center">
	     <s:textfield  name="stud.sno" label="学号" style="width:170px"/><br/>
	     <s:textfield name="stud.studentname" label="姓名" style="width:170px"/><br/>
	     <s:textfield name="stud.sage" label="年龄" style="width:170px"/><br/>
		<s:select name="stud.ssex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" label="性别" style="width:170px"/>
		<s:textfield name="stud.shobit" label="爱好" style="width:170px"/><br/>
		<s:textfield name="stud.szhuanye" label="专业" style="width:170px"/><br/>
		<s:select name="stud.classid" list="#{'1':'宏图201601班','2':'宏图201602班','3':'宏图201603班','4':'宏图201604班'}" listKey="key" listValue="value" label="班级" style="width:170px"/>
		<s:select name="stud.nationid" list="#{'1':'汉族','2':'傣族','3':'少数民族','4':'其他民族'}" listKey="key" listValue="value" label="民族" style="width:170px"/>
	   	<s:submit value="新增"/>
	   </table>
   	</s:form>
  </body>
</html>
