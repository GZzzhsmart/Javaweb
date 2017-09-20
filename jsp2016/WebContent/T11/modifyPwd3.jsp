<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.oldpwd.value==""){
    			alert("请输入旧密码");
    			form1.oldpwd.focus();
    			return false;
    		}
    		if(form1.newPassword.value==""){
    			alert("请输入新密码");
    			form1.newPassword.focus();
    			return false;
    		}
    		if(form1.newPassword.value != form1.cfgpwd.value){
    			alert("新密码与确认密码不一致,请重新输入");
    			form1.cfgpwd.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">修改密码</h1>
    <hr/>
    <h2 align="center"><font color='red'>${msg }</font></h2>
    <form name="form1" action="<%=basePath%>usersServlet?action=modifyPwd3" method="post" onsubmit="return check();">
    	<input type="hidden" name="userid" value="${param.userid}">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="500" bgcolor="yellow">
		<tr height="40">
			<td align="right">请输入旧密码：</td>
			<td>
				<input type="password" name="oldpwd" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">请输入新密码：</td>
			<td>
				<input type="password" name="newPassword" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">请输入确认密码：</td>
			<td>
				<input type="password" name="cfgpwd" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
