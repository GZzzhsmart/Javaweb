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
    <s:fielderror></s:fielderror>
    <s:form name="form1" action="studAction1!add.action" method="post">
    	<s:hidden name="action" value="add"/>
    	学&nbsp;号:<s:textfield name="stud.studid"/><br/>
    	姓&nbsp;名:<s:textfield name="stud.studname"/><br/>
    	年&nbsp;龄:<s:textfield name="stud.age"/><br/>
    	身份证:<s:textfield name="stud.cardno"/><br/>
    	爱&nbsp;好：<s:checkboxlist name="hobit"list="#{'篮球':'篮球','足球':'足球','乒乓球':'乒乓球','排球':'排球'}" listKey="key" listValue="value"/><br/>
    	性&nbsp;别:<s:radio name="stud.sex" list="#{'男':'男','女':'女'}" listKey="key" listValue="value"></s:radio><br/>
    	民&nbsp;族:<s:select name="stud.nationid" list="#request.nationList" listKey="nationid" listValue="nationName" style="width:155px"/><br/>
    	班&nbsp;级:<s:select name="stud.classid" list="#request.classList" listKey="classid" listValue="classname" style="width:155px"/><br/>
    	<s:submit value="新增"></s:submit>
    </s:form>
    
     <a href="studAction1!del.action?stud.studid=1001">删除</a>
  </body>
</html>
