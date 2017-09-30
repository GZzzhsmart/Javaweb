<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ajax.Updater函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
	<script type="text/javascript">
		function send(){
			var url = "${pageContext.request.contextPath}/requestServlet";
			var params = "username="+$F('username');
			alert(params);
			url = url+"?"+params;
			var ajax = Ajax.Updater(
			{success:'msg'},
			url,
			{
				method:'POST',
				parameters:params,
				onFailure:testError
			});
		}
		//onComplete需要调用的函数
		function testError(data){
			$('msg').innerText = "出错了，错误状态是："+data.responseText;
		}
	</script>
  </head>
  
  <body>
    <h1 align="center">Ajax.Updater函数的使用</h1>
    <hr/>
    <div id="msg">服务器返回的数据显示在该div中</div>
    <input type="text" name="username" id="username" value="admin"/><br/>
    <input type="button" value="取值" onclick="send();"/>
  </body>
</html>
