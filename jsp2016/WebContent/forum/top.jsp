<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body leftmargin="0" topmargin="0" bgcolor="cyan">
  	<center>
  	<a href="" id="url" target="_blank"><img id="adpic" src="" border="0" width="1000" height="95"></a>
	</center>
  </body>
  <script type="text/javascript">
  	//定义数组
	var adpic = [
	["images/banner.jpg","http://www.sina.com.cn"],
	["images/banner1.jpg","http://www.qq.com"],
	["images/banner2.jpg","http://www.baidu.com"],
	["images/banner3.jpg","http://www.cctv.com.cn"],
	["images/banner4.jpg","http://www.csdn.net"]];
	var index=0;
  	function initad(){
		index = index % 5;
		var imgaddr = adpic[index][0];
		var url = adpic[index][1];
		var imgid = document.getElementById("adpic");
		var linkurl = document.getElementById("url");
		imgid.src=imgaddr;
		linkurl.href=url;
		index++;
		setTimeout("initad();",1000);
	}
	initad();
  </script>
 
</html>
