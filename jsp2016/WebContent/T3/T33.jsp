<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>两数相加</title>
    <script type="text/javascript">
    
    </script>
	
  </head>
  
  <body>
    <h1 align="center">两数相加</h1>
    <hr color="cyan" />
    
    <%!
    	//带感叹号的元素中定义的变量是共享的，只能定义共享变量和函数，不能在函数外面单独写表达式语句
    	
    	int i,j;
     	int add(int a,int b){    		
     		return a+b;    	
     	}
     %>
     <%
     	i++;
     	i=add(200,10);
     
      %>
      i=<%=i %><br/>
      10+20=<%=add(10,20) %>
      &lt;%转义字符%&gt;
  </body>
</html>
