<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>函数的应用</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
    <script type="text/javascript">
    	function getValue(){
    		alert($("div1").innerText);
    		//以前取值的写法进行比较
    		alert(document.getElementById('div1').innerHTML);
    		var ids = $("div2","p1","p2");
    		for( var i=0;i<ids.length;i++){
    			alert(ids[i].innerText);
    		}
    	}
    </script>
	
  </head>
  
  <body>
    <h1 align="center">函数的应用</h1>
    <hr/>
    <div id="div1">div1</div>
    <div id="div2">div2</div>
    <p id="p1">p1的值</p>
    <p id="p2">p2的值</p>
    <hr/>
    <input type="button" value="取值" onclick="getValue();"/>
  </body>
</html>
