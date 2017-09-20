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
<h1 align="center">${section.sectionName}</h1>
<div id="a1"></div>
<script type="text/javascript" src="${pageContext.request.contextPath }/bwkplayer/bwkplayer/ckplayer/ckplayer.js" charset="utf-8"></script>
<script type="text/javascript">
	var flashvars={
		p:0,
		e:1,
		i:''
		};
	var video=['video/201701160313069773.avi'];
	var support=['all'];
	CKobject.embedHTML5('a1','ckplayer_a1',600,400,video,flashvars,support);
</script>
</body>
</html>
