<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		var xmlhttp;
		//创建XMLHttpRequest对象
		function createXMLHttpRequest(){
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");				
				}catch(e){
					try{
						return new XMLHttpRequest();
					}catch(e){
						alert("创建XMLHTTPRequest对象失败");
					}
				}
			}
			alert("ok");
			alert(xmlhttp);
		}
		//创建发送函数
		function send(method,url,param,ascy){
			//1.创建xmlhttprequest对象
			xmlhttp = createXMLHttpRequest();
			//2.绑定事件
			xmlhttp.onreadystatechange=recedata;
			//3.打开
			url = url +"?"+param;
			xmlhttp.open(method,url,ascy);
			//4.发送
			if(method=="get" || method=="GET"){
				xmlhttp.send(null);
			}else if(method=="post"|| method=="POST"){//post
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
				xmlhttp.send(param);
			}
		}
		//接收数据
		function recedata(){
			if(xmlhttp.status==200){
				if(xmlhttp.readyState==4){
					//responseText：服务器发送给客户端的数据
					alert(xmlhttp.responseText);
				}else{
					alert("出错了："+xmlhttp.statusText);
				}
			}
		}
		//测试函数
		function test(){
			var url = "${pageContext.request.contextPath}/deal.jsp";
			var param = "num=10";
			send("post",url,param,true);
		}
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
    <input type="button" value="测试Ajax" onclick="test();"/>
  </body>
</html>
