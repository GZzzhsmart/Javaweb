<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增学生资料</title>
  </head>
  
  <body>
    <h1 align="center">新增学生资料</h1>
    <hr/>
    <center>
	    <s:form name="fomr1" action="studAction!updateSave.action" method="post">
	    <table width="400" border="1">
	    	<s:textfield name="stud.studid" label="学号" style="width:170px;height:30px"></s:textfield>
	    	<s:textfield name="stud.studname" label="姓名" style="width:170px;height:30px"></s:textfield>
	    	<s:textfield name="stud.age" label="年龄" style="width:170px;height:30px"></s:textfield>
	    	<s:radio name="stud.sex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value" label="性别"></s:radio>
	    	<s:textfield name="stud.cardid" label="身份证号" style="width:170px;height:30px"></s:textfield>
	    	<s:select name="stud.classid" list="#{'1':'宏图1班','2':'宏图2班','3':'宏图3班','4':'宏图4班'}" label="班级名称" style="width:170px;height:30px"></s:select><br/>
	    	<s:submit value=" 提 交 "></s:submit>
	    	</table>
	    </s:form>
    </center>
  </body>
</html>
