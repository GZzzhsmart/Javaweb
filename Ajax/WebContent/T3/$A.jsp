<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>$A函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
    <script type="text/javascript">
    	function showOptions(){
    		var someNodeList = $('lstEmployees').getElementsByTagName('option');
    		var nodes = $A(someNodeList);
    		nodes.each(function(node){
    			alert(node.nodeName+": "+node.innerHTML);
    		});
    	}
    </script>

  </head>
  
  <body>
    <h1 align="center">$A函数的使用</h1>
    <hr/>
    <select id="lstEmployees" size="10">
		<option value="5">Buchanan, Steven</option>
		<option value="8">Callahan, Laura</option>
		<option value="1">Davolio, Nancy</option>
	</select>
	<input type="button" value="Show the options" onclick="showOptions();">
  </body>
</html>
