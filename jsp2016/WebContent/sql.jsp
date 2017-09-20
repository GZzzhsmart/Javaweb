<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.Date,java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>

<html>
  <head>
    <title>数据库连接</title>
    <script type="text/javascript">
    	
    </script>
  </head>
  
  <body>
  	<%
  		Date date = new Date();
  		out.println("现在时间："+date.toLocaleString());
  		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6";
		String username = "sa";
		String password = "123456";
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();
			String sql = "select id,username from Account";
			ResultSet rs = stmt.executeQuery(sql);
			int i=0;
			out.println("<br>");
			out.println("<table><tr>");
			out.println("<td>编号</td>");
			out.println("<td>用户名</td>");
			
			while(rs.next()&&i++<2){
				out.println("<tr height=\"15\">");
				out.println("<td align=center>"+rs.getString(1)+"</td>");
				out.println("<td align=left>"+rs.getString(2)+"</td>");
				
			}
			out.println("</table>");
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
  	 %>
  </body>
</html>
