<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>九九乘法表</title>
    <script type="text/javascript">
    	
    </script>
	
  </head>
  
  <body>
   <h1 align="center">九九乘法表</h1>
   <hr/>
   
   <%
   		int i,j;
   		for(i=1;i<=9;i++){
   			for(j=1;j<=i;j++){
    %>
   		 <%=i%>*<%=j %>=<%=i*j %>&nbsp;&nbsp;&nbsp;&nbsp;
    
    <%
    		}
     %>
    	<br/>
    <%
    	}
    	i++;
     %>
     
     <%=i %>
  </body>
</html>
