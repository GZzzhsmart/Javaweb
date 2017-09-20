<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EL表达式语言的使用</title>
    
  </head>
  
  <body>
    <h1 align="center">EL表达式语言的使用</h1>
    <hr/>
    <form action="T11/paramDemoSave.jsp" method="post" name="form1">
    	用户名称：<input type="text" name="username"/><br/>
    	年龄：    <input type="text" name="age"/><br/>
    	性别：
    	<input type="radio" name="sex" value="男" checked="checked">男
    	<input type="radio" name="sex" value="女"/><br/>
    	民族：
    	<select name="nation">
    		<option value="汉族">汉族</option>
    		<option value="少数民族">少数民族</option>
    		<option value="其他">其他</option>
    	</select><br/>
    	兴趣爱好：
    	<input type="checkbox" name="hobit" value="篮球">篮球
    	<input type="checkbox" name="hobit" value="跑步">跑步
    	<input type="checkbox" name="hobit" value="购物">购物
    	<input type="checkbox" name="hobit" value="爬山">爬山<br/>
    	<input type="submit" value="提交"/>
    	<input type="reset" name="reset"/>
    </form> 
  </body>
</html>
