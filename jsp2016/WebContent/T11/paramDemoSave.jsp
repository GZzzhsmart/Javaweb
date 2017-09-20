<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>获取参数</title>
  </head>
  
  <body>
  	<h1>老方法获取参数</h1>
  	<hr/>
  	用户名称：<%=request.getParameter("username") %><br/>
  	年龄：<%=request.getParameter("age") %><br/>
  	性别：<%=request.getParameter("sex") %><br/>
  	民族：<%=request.getParameter("nation") %><br/>
  	兴趣爱好：<%
  		
  	String hobit[] = request.getParameterValues("hobit");
  	for(int i=0;i<hobit.length;i++){
  		out.println(hobit[i]);
  	}
  	%><br/>
  	<h3>EL表达式获取参数的值</h3>
  	<hr/>
  	用户名称：${param.username }<br/>
  	年龄：${param.age }<br/>
  	性别：${param.sex }<br/>
  	民族：${param.nation }<br/>
  	兴趣爱好：${paramValues.hobit[0] }
  	
  	<%
  		//	定义变量
  		pageContext.setAttribute("qqcode","12345678");
  		request.setAttribute("qqcode","22222222");
  		session.setAttribute("qqcode","66666666");
  		application.setAttribute("qqcode","777777777");
  	%>
  	<h1>EL表达式获取变量的值</h1>
  	<hr/>
  	 <!-- 
     	共4种范围：pageScope,requestScope,sessionScope,applicationScope
     	当不指明范围的时候，默认是取pageContext变量的值 
     
     -->
  	qqcode=${qqcode }<br/>
  	requestScope qqcode = ${requestScope.qqcode }<br/>
  	sessionscope qqcode = ${sessionScope.qqcode }<br/>
  	applicationScope qqcode = ${applicationScope.qqcode }<br/>
  </body>
</html>
