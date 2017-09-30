<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>$函数的使用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
    <script type="text/javascript">
	    function test1(){
			var d = $('mydiv');
			alert(d.innerText);
		}
		function test2(){
			var divs = $('mydiv','myotherdiv');
			for(i=0; i<divs.length; i++){
				alert(divs[i].innerText);
			}
		}
	
		function test3(){
			var d= $('mydiv');
			var divs = $(d,'myotherdiv');
			for(i=0; i<divs.length; i++){
				alert(divs[i].innerText);
			}
		}
    </script>
  </head>
  
  <body>
  	<h1 align="center">$函数的使用</h1>
  	<hr/>
  	<div id="mydiv">
		<p>
			this is a paragraph
		</p>
	</div>
	<div id="myotherdiv">
		<p>
			this is another paragraph
		</p>
	</div>
	<input type="button" value=test1 onclick="test1();">
	<br>
	<input type="button" value=test2 onclick="test2();">
	<br>
	<input type="button" value=test3 onclick="test3();">
	<br>
  </body>
</html>
