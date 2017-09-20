<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增员工资料</title>
  </head>
  
  <body>
    <h1 align="center">新增员工资料</h1>
    <hr/>
    <s:form action="empAction!saveOrUpdate.action" method="post">
    	<table align="center" border="0">
    		<s:hidden name="emp.empid"></s:hidden>
    		<s:hidden name="acc.empid"></s:hidden>
    		<s:textfield name="emp.empname" label="员工姓名" id="empname"></s:textfield>
    		<s:select name="dep.deptid"  list="#request.depList" listValue="deptname" listKey="deptid"  label="所属部门"/>
    		<s:radio name="emp.sex"  list="#{'男':'男','女':'女'}" listKey="key" listValue="value" value="'男'" label="性别"></s:radio>
    		<s:textfield name="emp.birthday"  label="出生日期"></s:textfield>
    		<s:textfield name="emp.school"  label="毕业学校"></s:textfield>
    		<s:textfield name="emp.major"  label="所学专业"></s:textfield>
    		<s:textfield name="emp.degree"  label="学历"></s:textfield>
    		<s:textfield name="emp.mobile"  label="手机号码"></s:textfield>
    		<s:textfield name="acc.username"  label="登录账号"></s:textfield>
    		<s:textfield name="acc.passwd"  label="登录密码"></s:textfield>
    		<s:textfield name="acc.passwd1"  label="确认密码"></s:textfield>
    		<s:radio name="acc.status"  list="#{'启用':'启用','禁用':'禁用'}" listKey="key" listValue="value" label="状态"></s:radio>
	    	<s:submit align="center" value=" 保 存 "> </s:submit>
	    </table>
    </s:form>
  </body>
</html>
