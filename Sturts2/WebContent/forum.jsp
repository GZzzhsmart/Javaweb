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
    
    <title>拦截器拦截文章内容</title>
    
  </head>
  
  <body>
    <h1 align="center">拦截器拦截文章内容</h1>
    <hr/>
    <s:form name="form1" action="contentAction!save.action" method="post">
    	<s:textfield name="topic" label="标题" style="width:600px"/>
    	<s:textarea name="content" style="width:600px;height:200px"></s:textarea>
    	<s:submit value="提交"></s:submit>
    </s:form>
    <a href="contentAction!del.action">删除</a>
  </body>
</html>
