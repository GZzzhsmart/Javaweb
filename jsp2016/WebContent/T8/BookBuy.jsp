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
    
    <title>购买</title>
    

  </head>
  
  <body>
	<form name="form1" action="<%=basePath %>BookServlet?action=buySave"  method="post">
    	<h1 align="center"><font color="red">胡歌书籍批发市场</font></h1>
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
    			<td width="120" align="right">价格：</td>
    			<td><input type="text" name="jiage" style="width:150" value="<%=boid.getJiage()%>"></td>
    		</tr>
    		<tr>
    			<td width="120" align="right">支付金额：</td>
    			<td><input type="text" name="zhifu" style="width:150" onclick="alert('如果余额不够，将会回到支付界面！')"></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center"><input type="submit" value="  支  付  ">
    			<a href="<%=basePath %>BookServlet?action=list">退出支付</a></td>
    		</tr>
    		
    	</table>
    </form> 	
  </body>
</html>
