<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="T7.ContactBean"%>
<%@page import="java.sql.ResultSet"%>
<<jsp:useBean id="contact" class="T7.ContactBean" scope="page"/>
<html>
  <head>
    <title>使用javabean来操作数据库</title>
  </head>
  <body>
  	<table border="1">
  		<tr><td>QQcode</td><td>nickname</td><td>age</td></tr>
  		<%
  			try{
  				ResultSet rs = contact.getResult("select * from Account order by QQcode");
  				while(rs.next()){
  					out.println("<tr>");
  					out.println("<td>"+rs.getString("QQcode")+"</td>");
  					out.println("<td>"+rs.getString("nickname")+"</td>");
  					out.println("<td>"+rs.getString("age")+"</td>");
  				}
  			}catch(Exception e){
  				e.printStackTrace();
  			}
  		 %>
  	</table>
  </body>
</html>
