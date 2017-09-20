<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>民族列表</title>
  </head>
  
  <body>
    <h1 align="center">民族列表</h1>
    <hr/>
    <center>
    	<table border="1" cellpadding="3" cellspacing="1">
    		<tr>
    			<td>民族编号</td>
    			<td>民族名称</td>
    		</tr>
    		<s:iterator value="#request.nationList" var="d">
	    		<tr>
	    			<td>${d.nationid }</td>
	    			<td>${d.nationName }</td>
	    		</tr>    		
    		</s:iterator>
    	</table>
    	<h1>标准标签库forEach标签</h1>
    	<hr/>
    	<table border="1" cellpadding="3" cellspacing="1">
    		<tr>
    			<td>民族编号</td>
    			<td>民族名称</td>
    		</tr>
    		<c:forEach items="${nationList}" var="d">
	    		<tr>
	    			<td>${d.nationid }</td>
	    			<td>${d.nationName }</td>
	    		</tr>    
	    	</c:forEach>		
    	</table>
    </center>
    <s:form action="nationAction!save.action">
   	<s:select list="#request.nationList" name="nationid" listKey="nationid" listValue="nationName"></s:select><br/>
    <s:checkboxlist list="#request.nationMap" name="nationid1" key="key" value="value"></s:checkboxlist>
    <s:radio list="#request.nationList"  name="nationid2" listKey="nationid" listValue="nationName"></s:radio>
    <s:radio list="#request.sex"  name="sex" key="value" value="value"></s:radio>
    <s:hidden name="action" value="1"></s:hidden>
    <s:file name="file1"></s:file>
    <s:textarea name="remark" cols="80" rows="10"></s:textarea>
    <s:submit></s:submit>
    </s:form>
  </body>
</html>
