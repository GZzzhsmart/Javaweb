<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="refresh" content="1">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <script type="text/javascript">
	  	function s(){
	  		//获取当前页面的高度
			var c = window.document.body.scrollHeight;
			//设置滚动条的位置
			window.scroll(0,c); 
		}
  </script>
  </head>
  
  <body  onload="s();">
  	<%if(session.getAttribute("nickname")!=null){ %>
    	<%=application.getAttribute(session.getAttribute("nickname").toString())%>
    <%} %>
  </body>
</html>
