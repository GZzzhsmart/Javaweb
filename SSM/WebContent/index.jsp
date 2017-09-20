<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <!-- 引入jQuery文件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
	// 控制onsubmit提交的方法，方法名是vform()
		function vform(){
			//获取下面的id值
			var ln = $("#loginname").val();
			var lp = $("#loginpass").val();
			//判断上面的变量，如果为空字符串不能提交
			if(ln == ""){
				alert("请输入登录名！");
				return false;
			}
			if(lp == ""){
				alert("请输入密码！");
				return false;
			}
			//除以上结果的可以提交，返回true
			return true;
		}
	</script>
  
  <body>
    <div>晨魅---练习ssm框架整合！</div>
   <hr>
   <!-- 用onsubmit调用上面的方法 -->
   <form action="uc/login" method="post" onsubmit="return vform()">
   	<!-- 用po类，这个name值可以随意起，不受mybatis配置文件影响了 -->
   		<div>用户名：<input type="text" id="loginname" name="loginname"></div>
   		<div style="margin-left:16px">密码：<input type="password" id="loginpass" name="loginpass"></div>  		
   		<div><input type="submit" value="登录"></div>
   </form>
  </body>
</html>
