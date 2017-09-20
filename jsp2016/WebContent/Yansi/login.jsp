<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
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
    <h1>登录界面</h1>
    <hr/>
    <form action="<%=basePath %>/Yansi/checkLogin.jsp" name="form1" method="post" onsubmit="return check()">
    	<table align="center" border="1" width="500">
    		<tr>
    			<td align="right">用户名称：</td>
    			<td><input type="text" name="username"></td>
    		</tr>
    		<tr>
    			<td align="right">登录密码：</td>
    			<td><input type="password" name="password"></td>
    		</tr>
    		<tr>
	    		<td align="center" colspan="2">
	    			<input type="submit" name="btnLogin" value=" 登 录 ">
	    			<input type="reset" name="reset" value="清 空">
	    		</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
