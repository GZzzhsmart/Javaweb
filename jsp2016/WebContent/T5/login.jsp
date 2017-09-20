<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.username.value==""){
    			alert("请输入用户名称");
    			form1.username.focus();
    			return false;
    		}
    		if(form1.password.value==""){
    			alert("请输入登录密码");
    			form1.password.focus();
    			return false;
    		}
    		return true;
    	}
    
    </script>
  </head>
  <body>
  <%
  		//读取cookie变量的值
  		Cookie cookies[] = request.getCookies();
  		String user = "";
  		String pass = "";
  		//如果没有cookie则数组为空
  		if(cookies!=null){
  			for(int i=0;i<cookies.length;i++){
  				Cookie c = cookies[i];
  				System.out.println(c.getName()+"="+c.getValue());
  				if(c.getName().equals("username")){
  					user = URLDecoder.decode(c.getValue());//获取cookie的值
  				}
  				if(c.getName().equals("password")){
  					pass = URLDecoder.decode(c.getValue());//获取cookie的值
  				}
  			}
  		}
   %>
    <h1 align="center">系统登录</h1>
    <hr/>
    <form action="<%=basePath%>/T5/checkLogin.jsp" name="form1" onsubmit="return check();" method="post">
    	<table align="center" border="1" width="500">
    		<tr>
    			<td align="right">用户名称：</td>
    			<td><input type="text" name="username" value="admin" /></td>
    		</tr>
    		<tr>
    			<td align="right">登录密码：</td>
    			<td><input type="password" name="password" value="1234"/></td>
    		</tr>
    		<tr>
    			<td align="center" colspan="2">
    			<input type="checkbox" name="remember" value="1"/>记住密码
    			</td>
    		</tr>
    		<tr>
    			<td  colspan="2" align="center">
    			<input type="submit" name="btnLogin" value="  登 录  "/>
    			<input type="button" name="btnReg" value="注册">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
