<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>$R函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
    <script type="text/javascript">
    	function test(){
    		var range = $R(10,20,false);
    		range.each( function(value,index){
    			alert(value);
    		});
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">$R函数的使用</h1>
    <hr/>
    <input type="button" value="Sample Count" onclick="test();"/>
  </body>
</html>
