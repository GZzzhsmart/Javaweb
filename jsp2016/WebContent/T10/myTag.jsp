<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/demotag" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>调用自定义标签</title>
    
  </head>
  
  <body>
    <h1 >调用自定义标签</h1>
    <hr/>
    <s:helloworld/>
    <s:helloworld/>
    <h1 >调用继承TagSupport类的标签</h1>
    <hr/>
    <s:font>调用继承TagSupport类的标签</s:font>
    <h1 align="center">循环标签</h1>
    <hr/>
    <s:forEach border="1" count="8" bgcolor="yellow">
    	<tr>
    		<td>我爱你</td>
    		<td>520</td>
    	</tr>
    </s:forEach>
  </body>
</html>
