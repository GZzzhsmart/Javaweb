<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>数据库操作</title>
  </head>
  
  <body >
    <h1 align="center">QQ账号</h1>
    <hr/>
    <table  align="center" border="1" cellpadding="1" cellspacing="1" width="500">
    	<thead>
    		<th>QQcode</th>
    		<th>nickname</th>
    		<th>age</th>
    		<th>remark</th>
    	</thead>
    	<%
    		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=QQ2016";
	  		String username = "sa";
	  		String password = "123456";
    		//注册驱动
    		Class.forName(driver);
    		//连接数据库
    		Connection conn = DriverManager.getConnection(url,username,password);
    		//创建Statement对象
    		Statement stmt = conn.createStatement();
    		//执行SQL语句
    		String sql = "select * from Account";
    		ResultSet rs = stmt.executeQuery(sql);
    		int QQcode=0;
    		int age;
    		String nickname = "0";
    		String remark="0";
    		while(rs.next()){
    			QQcode = rs.getInt("QQcode");
    			nickname = rs.getString("nickname");
    			age = rs.getInt("age");
    			remark = rs.getString("remark");
    			%>
    			<tr>
    				<td><%=QQcode %></td>
    				<td><%=nickname %></td>
    				<td><%=age %></td>
    				<td><%=remark %></td>
    			</tr>
    			<% 
    		}
    		//关闭连接
    		rs.close();
    		stmt.close();
    		conn.close();
    	 %>
    </table>
  </body>
</html>
