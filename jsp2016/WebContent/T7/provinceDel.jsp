<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
	//乱码处理
	request.setCharacterEncoding("utf-8");
	//获取提交的数据
	String provinceId = request.getParameter("provinceId");

	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost\\SQL2005:1433;databasename=education";
	String username="sa";
	String password="123456";
	//1.调入驱动
	Class.forName(driver);
	//2.连接数据库
	Connection conn = DriverManager.getConnection(url,username,password);
	//3.创建Statement对象
	Statement stmt = conn.createStatement();
	//4.执行SQL语句
	String sql = "delete province where provinceId="+provinceId;
	stmt.executeUpdate(sql);
	stmt.close();
	conn.close();
	//重定向到provinceList.jsp页面
	String href = basePath + "T7/provinceList.jsp"; //绝对路径
	response.sendRedirect(href);

%>

