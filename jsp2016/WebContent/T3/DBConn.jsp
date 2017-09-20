<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.Date,java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
  <%
   				Date date=new Date();
   				out.println("<h4 align='right' ><font color='orange'>现在时间："+date.toLocaleString()+"</font></h4>");
   				out.println("<h1 align='center'><font color='blue'>计算机书籍库大全</font></h1>");
   				String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
   				String url="jdbc:sqlserver://localhost\\SQL2005:1433;databasename=t6"; 
   				String username="sa";
   				String password="123456";
   				
   				try{
   					Class.forName(driver);
   					Connection conn=DriverManager.getConnection(url,username,password);
   					PreparedStatement stm=conn.prepareStatement("select * from titles");
   					ResultSet dd=stm.executeQuery();
   					out.println("<br>");
   					out.println("<table width='360' border='1' align='center' bgcolor='skyblue'> ");
   					out.println("<tr><td >书籍编号：&nbsp;</td>");
   					out.println("<td>书籍名称：</td>");
   					out.println("<td>价格：</td></tr>");
   					while(dd.next()){
   						out.println("<tr height='50'>");
   						//out.println("<td>");
   						out.println("<td>"+dd.getInt(1)+"</td>");
   						out.println("<td>"+dd.getString(2)+"</td>");
   						out.println("<td>"+dd.getString(3)+"</td>");
   						out.println("</tr>");
   					}
   					out.println("</table>");
   					dd.close();
   					stm.close();
   					conn.close();
   				}catch(Exception e){
   					e.printStackTrace();
   				}
   				
   %>
   