<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jquery中post函数的用法</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("#btnPost").bind("click",function(){
    			var url="${pageContext.request.contextPath}/postServlet";
    			$.post(
    				url,
    				{
    					"studid":"1001",
    					"studname":"张三",
    					"sex":"男",
    					"classname":"宏图201601班"
    				},
    				receData,
    				"text"
    			);
    		});
    	});
    	function receData(data){
    		alert(data);
    	}
    </script>
  </head>
  
  <body>
   <h1 align="center">jquery中post函数的用法</h1>
   <hr/>
   <input type="button" id="btnPost" value="post提交数据">
  </body>
</html>
