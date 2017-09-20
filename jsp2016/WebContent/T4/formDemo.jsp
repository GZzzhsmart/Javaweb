<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    
    <title>表单控件</title>
    
	
  </head>
  
  <body>
    <h1 align="center">常用的表单控件</h1>
    <hr/>
    <form action="formDemoSave.jsp" name="form1" method="post">
    	性别：
    	<input type="radio" name="sex" value="男" checked="checked">男
    	<input type="radio" name="sex" value="女">女<br/>
    	婚姻状况:
    	<input type="radio" name="marry" value="单身" checked="checked">单身
    	<input type="radio" name="marry" value="已婚">已婚<br/>
    	兴趣爱好：
    	<input type="checkbox" name="hobit" value="篮球">篮球
    	<input type="checkbox" name="hobit" value="羽毛球">羽毛球
    	<input type="checkbox" name="hobit" value="足球">足球
    	<input type="checkbox" name="hobit" value="乒乓球">乒乓球
    	<input type="checkbox" name="hobit" value="排球">排球
    	<input type="checkbox" name="hobit" value="上网">上网
    	<input type="checkbox" name="hobit" value="看书">看书
    	<input type="checkbox" name="hobit" value="打游戏">打游戏<br/>
    	
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
