<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>$F函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
    <script type="text/javascript">
    	function test(){
    		alert($F("userName"));
    		//之前的方法
    		alert(document.getElementById("userName").value);
    		var options = $("nation").getElementsByTagName("option");
    		//把值转换为数组
    		var nodes = $A(options);
    		//用each函数循环读取
    		nodes.each(function(node){
    			alert(node.nodeName+"======"+node.innerHTML);
    		});
    	}
    </script>
  </head>
  
  <body>
     <h1 align="center">$F函数的使用</h1>
     <input type="input" name="user" id="userName" value="张三"/>
     <select name="nation" id="nation">
     	<option value="1">汉族</option>
     	<option value="2">少数民族</option>
     	<option value="3">其他民族</option>
     </select>
     <input type="button" value="取值" onclick="test();"/>
  </body>
</html>
