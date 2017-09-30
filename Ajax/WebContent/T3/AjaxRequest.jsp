<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ajax.request函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/prototype.js"></script>
	<script type="text/javascript">
		function send(){
			var url="${pageContext.request.contextPath}/requestServlet";
			var params="username="+$F('username');
			alert(params);
			url = url +"?" + params;
			var ajax = new Ajax.Request(
			url,
			{
				method:'POST',
				parameters:params,
				onComplete:test
			});
		}
		//onComplete需要调用的函数
		function test(data){
			alert(data.responseText);
		}
	</script>

  </head>
  
  <body>
    <h1 align="center">Ajax.request函数的使用</h1>
    <hr/>
    <input type="text" name="username"id="username" value="admin"/><br/>
    <input type="button" value="发送" onclick="send();"> 
  </body>
</html>
