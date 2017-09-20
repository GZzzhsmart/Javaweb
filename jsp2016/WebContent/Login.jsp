<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录界面</title>
   
  </head>
   <script type="text/javascript">
	function validateForm(){
	  	var username = loginform.username.value;
		var password = loginform.password.value;
		if(username==""){
			alert("请输入用户名称");
		}
		if(password==""){
			alert("请输入登录密码");
		}
		if(username.length>5){
			alert("用户名不能大于5个字符");
		}
		if(password.length>5){
			alert("密码不能大于5个字符");
		}
		if(isNaN(password)){
			alert("不能输入字母，请输入0~9之间的数字");
			loginform.password.focus();
			return false;
		}
	}
  </script>
  <body>
   <form name="loginform" action="checklogin.jsp" method="post" >
   <table  border="0" width="240px"  cellpadding="1" cellspacing="1" bgcolor="#F9BCFE">
   		<tr>
            <td colspan="3" align="center" bgcolor="#B709BB">用户登录</td>
        </tr>
	  <tr>
        <td>用户名</td>
            <td><input type="text" name="username" value="" size="20"/></td>
            <td><span style="color:red;">*</span></td>
      </tr>
        <tr>
            <td>密&nbsp;&nbsp;码</td>
            <td><input type="password" name="password" value="" size="20"/></td>
            <td><span style="color:red;">*</span></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" name="submit" value="登录" onclick="validateForm()"></td>
            <td>&nbsp;</td>
        </tr>
   </table>
	</form>
  </body>
</html>
