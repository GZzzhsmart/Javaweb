<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="T8.TushuVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改书籍</title>
  </head>
  
  <body>
     <form name="form1" action="<%=basePath %>BookServlet?action=updateSave"  method="post">
    	<h1 align="center"><font color="red">修改书籍</font></h1>
    	<%
    		TushuVo boid=(TushuVo)request.getAttribute("boid");
    	%>
    	<input type="hidden" name="book" value="<%=boid.getBookid()%>">
    	<table align="center" width="360" border="0" cellspacing="1" cellpadding="1" bgcolor="cyan">
    	
    		<tr>
    			<td width="120" align="right">作者：</td>
    			<td><input type="text" name="zuozhe" style="width:150" value="<%= boid.getBookzuozhe() %>"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">标题：</td>
    			<td><input type="text" name="biaoti" style="width:150" value="<%= boid.getBiaoti() %>"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">出版社：</td>
    			<td><input type="text" name="chuban" style="width:150" value="<%= boid.getChuban() %>"></td>
    		</tr> 
    		<tr>
    			<td width="120" align="right">出版时间：</td>
    			<td><input type="text" name="shijian" style="width:150" value="<%= boid.getShijian()%>"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">价格：</td>
    			<td><input type="text" name="jiage" style="width:150" value="<%= boid.getJiage() %>"></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center"><input type="submit" value="  修  改  ">
    			<input type="reset" value="  清  空  "></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
