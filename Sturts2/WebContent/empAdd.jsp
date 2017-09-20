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
    
    <title>新增职员资料</title>
  </head>
  
  <body>
    <h1 align="center">新增职员资料</h1>
    <hr/>
    <s:fielderror/>
    <s:form name="form1" action="empAction!add.action" method="post">
    	<s:token/>
    	<s:textfield name="emp.empNo" label="员工编号"/>
    	<s:textfield name="emp.empName" label="员工姓名"/>
    	<s:textfield name="emp.age" label="员工年龄"/>
    	<s:textfield name="emp.jobDate" label="入职日期"/>
    	<s:textfield name="emp.cardNo" label="身份证号"/>
    	<s:textfield name="emp.email" label="邮箱地址"/>
    	<s:textarea name="emp.remark" label="个人说明" cols="50" rows="5"></s:textarea>
    	<s:submit value="新增"></s:submit>
    </s:form>
  </body>
</html>
