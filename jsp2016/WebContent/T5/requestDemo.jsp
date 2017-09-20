<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>request对象详解1</title>
    
  </head>
  
  <body>
  	<h1>request对象详解</h1>
  	<hr/>
  	<%
  		request.setAttribute("username","admin");
  		request.setAttribute("sex","男");
  		request.setAttribute("age","19");
  		request.setAttribute("nation","汉族");
  		//取出所有变量
  		out.println("username="+request.getAttribute("username")+"<br/>");
  		out.println("sex="+request.getAttribute("sex")+"<br/>");
  		out.println("age="+request.getAttribute("age")+"<br/>");
  		out.println("nation="+request.getAttribute("nation")+"<br/>");
  		out.println("<hr/>");
  		
  		Enumeration enums = request.getAttributeNames();
  		while(enums.hasMoreElements()){
  			String name = enums.nextElement().toString();//获取变量名称
  			out.println(name+"="+request.getAttribute(name)+"<br/>");
  		}
  		out.println("<hr/>");
  		//删除变量
  		request.removeAttribute("username");
  		out.println("username="+request.getAttribute("username")+"<br/>");
  	 %>
  </body>
</html>
