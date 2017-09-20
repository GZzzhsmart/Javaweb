<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改省份资料</title>
   <script type="text/javascript">
   		function check(){
   			if(form1.provinceName.value==""){
   				alert("请输入省份名称");
   				form1.provinceName.focus();
   				return false;
   			}
   			return true;
   		}
   </script>
  </head>
  <%
  	//乱码处理
  	request.setCharacterEncoding("utf-8");
  	//获取读取出来的数据
  	String provinceId = request.getParameter("provinceId").trim();
  	
  	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost\\SQL2005:1433;databasename=education";
	String username="sa";
	String password="123456";
	//调入驱动
	Class.forName(driver);
	//连接数据库
	Connection conn = DriverManager.getConnection(url,username,password);
	//创建Statement对象
	Statement stmt = conn.createStatement();
	//执行sql语句
	String sql = "select * from province where provinceId="+provinceId;
	String provinceName = "";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		provinceName = rs.getString("provinceName");
	}
	rs.close();
	stmt.close();
	conn.close();
   %>
  <body>
  	<h1 align="center">修改省份资料</h1>
  	<hr/>
  	<form name="form1" action="<%=basePath %>T7/provinceEditSave.jsp" method="post" onsubmit="return check();">
  		<input type="hidden" name="provinceId"  value="<%=provinceId%>">
  		<table align="center" border="1" cellpadding="1" cellspacing="1" width="500">
  			<tr height="40">
  				<td align="right">省份名称：</td>
  				<td><input type="text" name="provinceName" value="<%=provinceName %>"></td>
  				<td><font size="2" color="red">*必填</font></td>
  			</tr>
  			<tr height="40">
				<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
			</tr>
  		</table>
  	</form>
  </body>
</html>
