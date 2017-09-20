<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <s:form name="form1" action="studAction1.action" method="post">
    	<s:hidden name="action" value="add"/>
    	学&nbsp;号:<input type="text" name="studid"/><br/>
    	姓&nbsp;名:<s:textfield name="studname"/><br/>
    	年&nbsp;龄:<s:textfield name="age"/><br/>
    	身份证:<s:textfield name="cardno"/><br/>
    	性&nbsp;别:<s:radio name="sex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value"></s:radio><br/>
    	民&nbsp;族:<s:select name="nationid" list="#request.nationList" listKey="nationid" listValue="nationName" style="width:155px"/><br/>
    	班&nbsp;级:<s:select name="classid" list="#request.classList" listKey="classid" listValue="classname" style="width:155px"/><br/>
    	<s:submit value="新增"></s:submit>
    </s:form>
  </body>
</html>
