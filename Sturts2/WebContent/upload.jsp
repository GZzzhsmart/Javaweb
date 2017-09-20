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
    
    <title>上传文件</title>
  </head>
  <body>
    <h1 align="center">文件上传</h1>
    <hr/>
    <s:form method="post" name="form1" action="fileUpload.action" enctype="multipart/form-data">
    	<s:textfield name="title" label="标题"></s:textfield>
    	<s:file name="upload" label="请选择文件"></s:file>
    	<s:submit value="上传"></s:submit>
    </s:form>
    <img src="upload/${targetfilename}"/>
  </body>
</html>
