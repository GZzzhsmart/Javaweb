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
    
    <title>文件下载</title>
  </head>
  
  <body>
    <h1 align="center">文件下载</h1>
    <hr/>
    <s:iterator value="#request.fileList" var="d">
    	<img src="upload/${d}" width="300">
    	<a href="upload/${d}">直接下载</a>&nbsp;&nbsp;
    	<a href="downloadAction!down.action?filename=${d}">下载</a><br/>
    </s:iterator>
  </body>
</html>
