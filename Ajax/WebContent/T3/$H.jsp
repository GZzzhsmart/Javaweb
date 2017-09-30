<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>$H函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
    <script type="text/javascript">
    	function test(){
    		var a={currPage:1,totalPage:10,opr:'next'};
    		alert($H(a).toQueryString());
    	}
    	function test2(){
    		//false代表>=10 && <=20
    		//true代表>=10 && <20
    		var aa = $R(10,20,true);
    		aa.each(function(value,index){
    			alert(value+"======="+index);
    		});
    	}
    	
    </script>
    
  </head>
  
  <body>
    <h1 align="center">$H函数的使用</h1>
    <hr/>
    <input type="button" value="转换" onclick="test();"><br/>
    <input type="button" value="$R函数参数" onclick="test2();">
  </body>
</html>
