<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息注册</title>
  </head>
  
  <body>
    <h1 align="center">学生信息注册</h1>
    <hr/>
    
    <form name="form1" method="post" action="T6/studentBean2.jsp">
    	学号：<input type="text" name="Studid"><br/>
    	姓名：<input type="text" name="studName"><br/>
    	年龄：<input type="text" name="age"><br/>
    	性别：
    	<input type="radio" name="sex" value="男" checked="checked">男
    	<input type="radio" name="sex" value="女">女<br/>
    	班级：<input type="text" name="className"><br/>
    	婚姻状况：
    	<input type="radio" name="marry" value="单身" checked="checked">单身
    	<input type="radio" name="marry" value="已婚">已婚<br/>
    	兴趣爱好：
    	<input type="checkbox" name="hobit" value="篮球">篮球
    	<input type="checkbox" name="hobit" value="足球">足球
    	<input type="checkbox" name="hobit" value="羽毛球">羽毛球
    	<input type="checkbox" name="hobit" value="乒乓球">乒乓球
    	<input type="checkbox" name="hobit" value="排球">排球
    	<input type="checkbox" name="hobit" value="上网">上网
    	<input type="checkbox" name="hobit" value="看书">看书
    	<input type="checkbox" name="hobit" value="打游戏">打游戏<br/>
    	
    	<input type="submit" value="提交">
    </form>
    
  </body>
</html>
