<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>验证密码</title>
    <script type="text/javascript">
    	function check(obj){
		//文本框为空
		if(obj.username.value==""){
			alert("请输入用户名称");
			//设置焦点
			obj.username.focus();
			return false;
		}
		if(obj.password.value==""){
			alert("请输入登录密码");
			obj.password.focus();
			return false;
		}
		return true;
	}
	function checkuser(object){
		if(object.value==""){
			alert("请输入用户名称");
		}
	}
	function checkpass(object){
		if(object.value==""){
			alert("请输入登录密码");
		}
	}
	function cg(){
		alert("提交成功");
	}
    </script>
  </head>
  
  <body>
    <h1>用户登录</h1>
  <hr/>
  <form name="form1" method="post" onsubmit="return check(this);" action="#">
  用户名称：<input type="text" name="username" onblur="checkuser(this);"><br/>
  登录密码：<input type="text" name="password" onblur="checkpass(this);"><br/>
  <input type="submit" value="提 交" onclick="cg();">
  </body>
</html>
