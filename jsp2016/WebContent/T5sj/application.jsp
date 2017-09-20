<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%!
	//库存量
	int a1=30,a2=50,a3=40;
	//价格
	double p1=48.00,p2=58.00,p3=40.00;
	//商品名称
	String s1="C语言",s2="Java程序设计",s3="javascript";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<title>请求</title>
	
</head>
<body>
	<form action="session.jsp" name="form1" method="post">
		<table border="1">
			<tr align="center">
				<th>商品名</th><th>价格/元</th><th>库存量</th><th>购买数量</th>
			</tr>
			<tr align="left">
				<th><%=s1 %></th><td><%=p1 %></td><td><%=a1 %>
				<input type="text" name="num1" value="0"></td>
			</tr>
			<tr align="left">
				<th><%=s2 %></th><td><%=p2 %></td><td><%=a2 %>
				<input type="text" name="num2" value="0"></td>
			</tr>
			<tr align="left">
				<th><%=s3 %></th><td><%=p3 %></td><td><%=a3 %>
				<input type="text" name="num3" value="0"></td>
				<td><input type="submit" name="submit" value="提交"></td>
			</tr>
		</table>
		<%
			application.setAttribute("s1",s1);
			application.setAttribute("s2",s2);
			application.setAttribute("s3",s3);
			application.setAttribute("p1",p1);
			application.setAttribute("p2",p2);
			application.setAttribute("p3",p3);
			String username = request.getParameter("username");
			session.setAttribute("username",username);
		 %>
	</form>
</body>
</html>
