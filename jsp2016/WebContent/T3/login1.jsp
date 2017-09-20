<%@ page contentType="text/html;charset=utf-8"%>


<html>
  <head>
   
    
    <title>登录界面</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.username.value!="admin"){
    			alert("用户名不存在");
    			form1.username.focus();
    			return false;
    		}
    		if(form1.password.value!="1234"){
    			alert("密码错误");
    			form1.password.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
  <h1 align="center">用户登录界面</h1>
    <form action="yanzheng.jsp" name="form1" method="post" onsubmit="return check();">
    	<table align="center" width="280" bgcolor="pink">
    	<tr>
    		<td>
    		用户名称：<input type="text" name="username" >
    		</td>
    	</tr>
    	<tr>
    		<td>
    		登录密码：<input type="password" name="password">
    		</td>
    	</tr>
    	<tr>
    		<td align="center">
    			<input type="submit" value=" 登 录 ">
    		</td>
    	</tr>
    	</table>
    </form>
  </body>
</html>
