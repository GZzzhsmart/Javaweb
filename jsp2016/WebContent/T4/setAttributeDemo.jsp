<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>定义变量</title>
    
    </head>
  
  <body>
  	<h1>pageContext,request,session,application对象定义变量</h1>
  	<hr/>
  	<%
  		pageContext.setAttribute("pageContext","pageContext");
  		request.setAttribute("request","request");
  		session.setAttribute("session","session");
  		application.setAttribute("application","application");
  		
  	 %>
  	 <jsp:forward page="setAttributeDemo2.jsp"/>
  	 <h1>变量的值如下：</h1>
  	 pageContext=<%=pageContext.getAttribute("pageContext") %><br/>
  	 request=<%=request.getAttribute("request") %><br/>
  	 session=<%=session.getAttribute("session") %><br/>
  	 application=<%=application.getAttribute("application") %><br/>
  </body>
</html>
