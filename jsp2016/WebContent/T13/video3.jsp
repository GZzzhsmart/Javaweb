<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>BWK播放器</title>
</head>
<body>
<h1 align="center">tomcat的安装与配置</h1>
	<hr/>
	<object id="MediaPlayer" classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" width="600" height="600" standby="Loading Windows Media Player components…" 
	type="application/x-oleobject" codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=6,4,7,1112">
	<param name="FileName" value="<%=basePath%>/video/201701160313069773.avi">  
	<param name="AutoStart" value="true">                 
	<param name="ShowControls" value="true">        
	<param name="BufferingTime" value="2">
	<param name="ShowStatusBar" value="false">     
	<param name="AutoSize" value="true">
	<param name="InvokeURLs" value="false">
	<param name="AnimationatStart" value="false">
	<param name="TransparentatStart" value="false"> 
	<param name="Loop" value="1">
	</object>
</body>
</html>
