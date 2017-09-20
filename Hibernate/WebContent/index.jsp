<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    <style type="text/css" rel="sheetstyle" src="style/style.css"></style>
  </head>
  
  <body topmargin="0" leftmargin="0">
  <table border="0" width="100%" cellpadding="0" cellspacing="0">
  	<tr bgcolor="cyan">
  		<td width="120px">
  			<img src="images/bwkxt.png" height="50">
  		</td>
  		<td align="right">
  			<a href="javascript:void(0);">修改密码</a>||
  			<a href="javascript:void(0);">当前用户：admin</a>||
  			<a href="javascript:void(0);">安全退出</a>
  		</td>
  	</tr>
  	<tr>
  		<td valign="top">
  			<table border="1" width="100%" cellpadding="0" cellspacing="0" height="300">
  				<tr height="30"><td align="center"><a href="stuAction!list.action" target="mainFrame">学生管理</a></td></tr>
  				<tr height="30"><td align="center"><a href="depAction!init.action" target="mainFrame">新增部门</a></td></tr>
  				<tr height="30"><td align="center"><a href="depAction!list.action" target="mainFrame">部门管理</a></td></tr>
  				<tr height="30"><td align="center"><a href="empAction!init.action" target="mainFrame">新增员工</a></td></tr>
  				<tr height="30"><td align="center"><a href="empAction!list.action" target="mainFrame">员工列表</a></td></tr>
  				<tr height="30"><td align="center"><a href="empAction!listByDetach.action?pager.currentPage=1&pager.opr=first" target="mainFrame">员工列表2</a></td></tr>
  				<tr height="30"><td align="center"><a href="classAction!init.action" target="mainFrame">新增班级</a></td></tr>
  				<tr height="30"><td align="center"><a href="classAction!list.action" target="mainFrame">班级列表</a></td></tr>
  			</table>
  		</td>
  		<td>
  			<iframe name="mainFrame" height="500px" width="1100px" frameborder="0"></iframe>
  		</td>
  	</tr>
  </table>
  </body>
</html>
