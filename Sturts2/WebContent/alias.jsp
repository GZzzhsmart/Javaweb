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
    
    <title>别名拦截器</title>
    
  </head>
  
  <body>
    <h1 align="center">别名拦截器</h1>
    <hr/>
    <s:form action="firstAction.action" method="post">
    	名称：<s:textfield name="firstname"/>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
