<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DWR类库使用</title>
    <script type="text/javascript" src="dwr/engine.js"></script>
    <script type="text/javascript" src="dwr/util.js"></script>
    <script type="text/javascript" src="dwr/interface/helloService.js"></script>
    <script type="text/javascript">
    	function testDwr(){
    		var username = document.getElementById("username").value;
    		helloService.sayHello(username,callback);
    		alert(username);
    	}
    	function testDwr1(){
    		var username = document.getElementById("username").value;
    		helloService.sayHello1(username,callback);
    		alert(username);
    	}
    	function testDwr2(){
    		var username = document.getElementById("username").value;
    		helloService.sayHello2(username,callback);
    		alert(username);
    	}
    	function testDwr3(){
    		var username = document.getElementById("username").value;
    		helloService.sayHello3(username,callback);
    		alert(username);
    	}
    	//回调函数
    	function callback(data){
    		document.getElementById("msg").innerHTML=data;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">DWR类库使用</h1>
    <hr/>
    <div id="msg">显示服务器端传给客户端的值</div>
    <input type="text" name="username" id="username" value="张三">
    <input type="button" value="测试1" onclick="testDwr();">
    <input type="button" value="测试2" onclick="testDwr1();">
    <input type="button" value="测试3" onclick="testDwr2();">
    <input type="button" value="测试4" onclick="testDwr3();">
  </body>
</html>
