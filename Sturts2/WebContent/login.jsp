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
    
    <title>系统登录</title>

  </head>
  
  <body>
    <h1 align="center">系统登录</h1>
    <hr/>
    <s:fielderror/>
    <s:form action="loginAction.action" method="post" name="form1">
    	用户名称：<s:textfield name="username"/><br/><br/>
    	登录密码：<s:password name="password"/><br/><br/> 
    	<input type="submit" value="登录">
    </s:form>
  </body>
</html>
