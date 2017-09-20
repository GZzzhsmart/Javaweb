<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>表单信息</title>
    
  </head>
  
  <body>
    <h1>您填写的信息如下：</h1>
    <hr/>
    <%
    	request.setCharacterEncoding("utf-8");
     %>
     性别：<%=request.getParameter("sex") %><br/>
     婚姻状况：<%=request.getParameter("marry") %><br/>
     <%
        String[] hobits=request.getParameterValues("hobit");
	   	String str="";
	   	if(hobits!=null){
	   		for(int i=0;i<hobits.length;i++){
	   			str += hobits[i]+",";
	   		}
	   		str = str.substring(0,str.length()-1);
 	  	}
      %>
      兴趣爱好：<%=str %>
  </body>
</html>
