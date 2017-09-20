<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>系统登录</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.username.value==""){
    			alert("请输入用户名称");
    			form1.username.focus();
    			return false;
    		}
    		if(form1.password.value==""){
    			alert("请输入登录密码");
    			form1.password.focus();
    			return false;
    		}
    		return true;
    	}
    
    </script>
  </head>
  
  <body>
    <h1 align="center">系统登录</h1>
    <hr/>
    <form action="./secondServlet" name="form1" onsubmit="return check();" method="post">
    	<table align="center" border="1" width="500">
    		<tr>
    			<td align="right">用户名称：</td>
    			<td><input type="text" name="username" value="admin" /></td>
    		</tr>
    		<tr>
    			<td align="right">登录密码：</td>
    			<td><input type="password" name="password" value="1234"/></td>
    		</tr>
    		<tr>
    			<td  colspan="2" align="center"><input type="submit" value="  登 录  "/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
