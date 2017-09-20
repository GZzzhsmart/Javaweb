<%@ page contentType="text/html;charset=utf-8"%>
<html>
  <head>
  </head>
  
  <body>
  <h1>count用来记录该页面被访问的次数</h1>
 	<%!int count=0; %>
	<%=count++ %>
	<br>
	<%=new java.util.Date().toLocaleString() %>   
	<hr color="cyan">
	<%
		int[] a = {10,5,2,6,25,8};
		int sum=0;
		for(int i=0;i<a.length;i++){
			sum+=i;
		}
		out.println(sum);
	 %>
  </body>
</html>
