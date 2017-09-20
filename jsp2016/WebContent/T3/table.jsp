<%@ page contentType="text/html;charset=utf-8"%>
<%@ page  import="java.util.Date,java.sql.*" %>
<html>
  <head>
    <title>主页面</title>
  </head>
  <body>
     <form method="post" name="form1">
   <table border="1" width="100%" align="center" height="610">
   		<tr align="center">
   			<td colspan="2"><font size="48" color="blue"><%@include file="success.jsp" %></font></td>
   		</tr>
   		<tr>
   			<td width="200" height="480">
   				<table align="center">
   					<tr height="80" align="center"><td valign="middle" align="center"><font color="red"><a href="answer.jsp"><I>运算</I></font></td></tr>
   					<tr height="80"><td valign="middle" align="center"><font color="red"><a href="Vote.jsp"><I>投票</I></font></td></tr>
   					<tr height="80"><td valign="middle" align="center"><font color="red"><a href="login1.jsp"><I>登录页面</I></font></td></tr>
   					<tr height="80"><td valign="middle" align="center"><font color="red"><a href="T31.jsp"><i>九九乘法表</i></font></td></tr>
   					<tr height="80"><td valign="middle" align="center"><font color="red"><a href="head.jsp"><I>小窗口</I></font></td></tr>
   				</table>
   			</td>
   			<td>
   				<%@include file="DBConn.jsp" %>
   			</td>
   		</tr>
   		<tr>
       		<td colspan="3">
			<marquee direction="left" height="30" bgcolor="cyan" behavior="scroll"><font color="red" size="5" face="宋体">
       			 胡歌制作，违版必究，版权所有
 	    	</marquee>
   		</td>
	    </tr>
   </table>
    </form>
  
  </body>
</html>
