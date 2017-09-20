<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>在线报名系统</title>
    
  </head>
  
  <body>
    <h1 align="center">在线报名系统</h1>
    <hr/>
    <form action="Yansi/student1.jsp" name="form1" method="post">
    	姓名：<input type="text" name="username"><br/>
    	电话号码：<input type="text" name="phone"><br/>
    	年龄：<input type="text" name="age"><br/>
    	性别：
    	<input type="radio" name="sex" value="男" checked="checked">男
    	<input type="radio" name="sex" value="女">女<br/>
    	受教育程度：
    	<input type="radio" name="education" value="小学">小学
    	<input type="radio" name="education" value="初中">初中
    	<input type="radio" name="education" value="高中">高中
    	<input type="radio" name="education" value="大学" checked="checked">大学<br/>
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
