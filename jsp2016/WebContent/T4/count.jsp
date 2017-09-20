<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>统计网站的访问人数</title>
    
    </head>
  
  <body>
    <h1>统计网站的访问人数</h1>
    <hr/>
    <%
    	//服务器启动后第一次访问该网页
    	int count=0;
    	if(application.getAttribute("count")==null){
    		application.setAttribute("count",1);
    	}else{
    		count = Integer.parseInt(application.getAttribute("count").toString());
    		count++;
    		application.setAttribute("count",count);
    	}
     %>
     网站当前的访问人数是：<%=count %>
     <hr color="red"/>
     <h3>网站访问人数</h3>
     <%!int count=0; %>
     <%=count++ %>
     <br>
     <%=new java.util.Date().toLocaleString() %>
  </body>
</html>
