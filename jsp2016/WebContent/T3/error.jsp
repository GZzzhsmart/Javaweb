<%@ page contentType="text/html;charset=GB2312" isErrorPage="true"%>
<%@ page import="java.io.PrintWriter"%>
<%
	/*
		设置当前页面为错误处理页面
		需要设置page指令的isErrorPage属性，值设置为true(isErrorPage="true");
		设置了isErrorPage="true"的页面就不能设置errorPage属性；这2个属性是互斥的
		只有设置了isErrorPage="true"的页面才能使用exception对象
	
	*/
%>


<html>
  <head>
    
    <title>error.jsp</title>
    <script type="text/javascript">
    	
    </script>
	
  </head>
  
  <body>
   <h2>errorpage的范例程序</h2>
   
   <p> ErrorPage.jsp 错误产生：<I><%=exception %> </I></p><br>
   <pre>
  问题如下：<% exception.printStackTrace(new PrintWriter(out)); %>
   </pre>
  </body>
</html>
