<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册信息</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.username.value==""){
    			alert("请输入用户名称");
    			form1.username.focus();
    			return false;
    		}
    		var age = form1.age.value;
			if(age==""){
				alert("请输入年龄");
				form1.age.focus();
				return false;
			}
			if(isNaN(age)){
				alert("请输入0~9之间的数字");
				form1.age.focus();
				return false;
			}
			if(parseInt(age)<0 || parseInt(age)>150){
				alert("年龄必须在0~150之间");
				form1.age.focus();
				return false;
			}
			if(form1.sex.value==""){
				alert("请选择性别");
			}
			if(form1.password.value==""){
				alert("请输入登录密码");
				form1.password.focus();
				return false;
			}
			if(form1.password.value!=form1.cfgpwd.value){
				alert("输入的密码与重置密码不一致");
				form1.cfgpwd.focus();
				return false;
			}
			return true;
    	}
    </script>
	

  </head>
  
  <body>
    <h1 align="center">用户注册信息</h1>
    <form action="./loginServlet" name="form1" method="post" onsubmit="return check();">
   	<table  align="center" border="1" width="400" height="300">
   		
   		<tr>
   			<td align="center">昵&nbsp;&nbsp;称：</td><td><input type="text" name="username"></td>
   		</tr>
   		<tr>
   			<td align="center">密&nbsp;&nbsp;码：</td><td><input type="password" name="password"><br></td>
   		</tr>
   		<tr>
   			<td align="center">确认密码：</td><td><input type="password" name="cfgpwd"><br></td>
   		</tr>
   		<tr>
   			<td align="center">性&nbsp;&nbsp;别：</td><td><input type="radio" name="sex" value="男">男<input type="radio" name="num5" value="女">女<br></td>
   		</tr>
   		<tr>
   			<td align="center">年&nbsp;&nbsp;龄：</td><td><input type="text" name="age"><br></td>
   		</tr>
   		<tr>
   			<td align="center">爱&nbsp;&nbsp;好：</td><td>
   			<input type="checkbox" name="hobit" value="旅游">旅游
   			<input type="checkbox" name="hobit" value="摄影">摄影
   			<input type="checkbox" name="hobit" value="上网">上网<br/>
   			<input type="checkbox" name="hobit" value="体育">体育
   			<input type="checkbox" name="hobit" value="音乐">音乐
   			<input type="checkbox" name="hobit" value="电脑">电脑<br></td>
   		</tr>
   		<tr>
   			<td align="center">地&nbsp;&nbsp;区：</td><td><select name="place"><option value="赣州">赣州</option>
   			<option value="广州">吉安</option><option value="泰和">泰和</option>
   			<option value="珠海">珠海</option><option value="天河">天河</option>
   			</select></td>
   		</tr>
   		<tr>
   			<td align="center" colspan="2"><input type="submit" name="submit" value="注册">&nbsp;<input type="reset" name="num9" value="取消"></td>
   		</tr>
   	</table>
   	</form>
  </body>
</html>
