<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增部门资料</title>
  </head>
  
  <body>
    <h1 align="center">新增部门资料</h1>
    <hr/>
    <s:form action="depAction!save.action" method="post">
    <s:hidden name="newDep.deptid"/>
    <s:textfield name="newDep.deptname" label="部门姓名"/>
    <s:select name="dep.deptid" list="#request.depList" listKey="deptid" listValue="deptname"  label="父部门"></s:select>
    <s:submit value=" 注 册 "> </s:submit>
    </s:form>
  </body>
</html>
