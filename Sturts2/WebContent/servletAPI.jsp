<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>与servletAPI的交互</title>
    

  </head>
  
  <body>
    <h1 align="center">与servletAPI的交互</h1>
    <hr/>
     获取request变量username的值:${requestScope.username}<br/>
    获取request变量username的值:${username}<br/>
    不同范围的变量如果有同名的情况必须指明要取值的变量范围(pageScope,requestScope,sessionScope,applicationScope<br/>
    获取session变量username的值(sessionScope.username):${sessionScope.username}<br/>
    获取application变量count的值:${applicationScope.count}<br/>
    获取application变量count的值:${count}<br/>
  </body>
</html>
