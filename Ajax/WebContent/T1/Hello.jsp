<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var httpRequest = null;
		function createXMLHttpRequest(){
			try{
				httpRequest = new XMLHttpRequest();
			}catch(e){
				try{
					httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){
					try{
						httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
					}catch(e){
						alert("创建对象出错！");
					}
				}
			}
		}
		//发送函数
		function sendinfo(obj){
			//获取输入字段的内容
			var paramValue = obj.say.value;
			//使用Ajax发送请求到服务器
			createXMLHttpRequest();
			if(!httpRequest) return false;
			httpRequest.onreadystatechange = displayinfo;
			alert(paramValue);
			var url = "/Ajax/T1/helloplayinfo.jsp?say="+paramValue;
			httpRequest.open("get",url,false);
			httpRequest.send(null);
			return true;
		}
		//处理状态改变的事件处理器
		function displayinfo(){
			var msgdiv = document.getElementById("msg");
			//表示响应已经完成
			if(httpRequest.readyState==4 && httpRequest.status==200){
				msgdiv.innerHTML = httpRequest.responseText;
			}else{
				msgdiv.innerHTML="出现异常"+httpRequest.statusText;
			}
		}
	</script>
  </head>
  
  <body>
    <h1>XMLHttpRequest对象的创建和使用</h1>
    <hr/>
    <form>
    	输入内容：<input type="text" name="say" value=""/>
    	<input type="button" name="send" value="发送到服务器" onclick="return sendinfo(this.form);"/>
    </form>
    <br/>
    <div id="msg">[在此显示浏览器的内容]</div>
  </body>
</html>
