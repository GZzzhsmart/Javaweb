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
    
    <title><s:text name="label.addemp.title"/></title>
  </head>
  
  <body>
    <h1 align="center"><s:text name="label.addemp.title"/> </h1>
    <hr/>
    <s:form name="form1" action="empAction!add.action" method="post">
    	<s:token/>
    	<s:textfield name="emp.empNo" key="label.empNo"/>
    	<s:textfield name="emp.empName" key="label.empName"/>
    	<s:textfield name="emp.age" key="label.age"/>
    	<s:textfield name="emp.jobDate" key="label.jobDate"/>
    	<s:textfield name="emp.cardNo" key="label.cardNo"/>
    	<s:textfield name="emp.email" key="label.email"/>
    	<s:textarea name="emp.remark" key="label.remark" cols="50" rows="5"></s:textarea>
    	<s:submit value="新增"></s:submit>
    </s:form>
  </body>
</html>
