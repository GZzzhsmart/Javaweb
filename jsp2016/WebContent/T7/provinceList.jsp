<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <title>省份列表</title>
  </head>
  
  <body>
  	<h1 align="center">数据库连接，显示省份资料列表</h1>
  	<hr/>
  
  	  <table align="center"  cellpadding="1" cellspacing="1" width="500" bgcolor="cyan">
    	<thead>
    		<th>省份编号</th>
    		<th>省份名称</th>
    		<th>操作</th>
    	</thead>
  	<%
  		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=education";
  		String username = "sa";
  		String password = "123456";
  		//注册驱动
  		Class.forName(driver);
  		//连接数据库
  		Connection conn = DriverManager.getConnection(url,username,password);
  		//out.println("数据库连接成功");
  		//创建Statement对象
  		Statement stmt = conn.createStatement();
  		//执行sql语句
  		String sql = "select * from province order by provinceId";
  		ResultSet rs = stmt.executeQuery(sql);
  		//数据处理
  		int provinceId=0;
  		String provinceName = "";
  		while(rs.next()){
  			provinceId = rs.getInt("provinceId");
  			provinceName = rs.getString(2);
  			%>
  			<tr>
  				<td><%=provinceId %></td>
  				<td><%=provinceName %></td>
  				<td>
  				<a href="T7/provinceAdd.jsp">新增</a>
  				<a href="<%=basePath%>T7/provinceEdit.jsp?provinceId=<%=provinceId%>">修改</a>
				<a href="<%=basePath%>T7/provinceDel.jsp?provinceId=<%=provinceId%>" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
  				</td>
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
