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
    
    <title>新增班级资料</title>
  </head>
  
  <body>
    <h1 align="center">新增班级资料</h1>
    <hr/>
    <s:form action="classAction!save.action" method="post">
    <s:hidden name="clazz.classid"/>
    <s:select name="clazz.majorid" list="#request.majorList" listKey="majorid" listValue="majorname"  label="专业名称"></s:select>
    <s:textfield name="clazz.classname" label="班级名称"/>
    <s:submit value=" 注 册 "> </s:submit>
    </s:form>
  </body>
</html>
