<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
  <head>
    
    <title>login1.jsp</title>
    <script type="text/javascript">
    	
    </script>
  </head>
  
  <body>
  <h1 align="center">用户登录</h1>
  <hr color="red"/>
    <form action="check1.jsp" name="form1" method="post" >
    	<table align="center" width="280" bgcolor="cyan">
	    	<tr>
	    		<td>用户名称：<input type="text" name="username" ></td>
	    	</tr>
	    	<tr>
	    		<td>登录密码：<input type="password" name="password"></td>
	    	</tr>
	    	<tr>
	    		<td align="center"><input type="submit" value=" 登 录 "></td>
	    	</tr>
    	</table>
    </form>
  </body>
</html>
