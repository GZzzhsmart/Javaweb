<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>request对象获取系统环境参数的值</title>
    
	
  </head>
  
  <body>
  	<h1>request对象获取系统环境参数的值</h1>
  	<hr/>
  	项目名称=<%=request.getContextPath() %><br/>
  	通信协议=<%=request.getScheme() %><br/>
  	服务器名称=<%=request.getServerName() %><br/>
  	服务器端口=<%=request.getServerPort() %><br/>
  	basePath=<%=basePath %><br/>
  	客户端主机=<%=request.getRemoteHost() %><br/>
  	客户端IP=<%=request.getRemoteAddr() %><br/>
  	客户端端口=<%=request.getRemotePort() %><br/>
    本地主机=<%=request.getLocalAddr() %><br/>
    本地端口=<%=request.getLocalPort() %><br/>
    本地主机=<%=request.getLocalName() %><br/>
    方法=<%=request.getMethod() %><br/>
    mime类型=<%=request.getContentType() %><br/>
    字符集=<%=request.getCharacterEncoding() %><br/>
    路径信息=<%=request.getPathInfo() %><br/>
    真实路径=<%=request.getRealPath("/") %><br/>
    SessionId=<%=request.getRequestedSessionId() %><br/>
    地址=<%=request.getRequestURL() %><br/>
    相对地址=<%=request.getServletPath() %><br/>
  </body>
</html>
