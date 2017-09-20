<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>最喜欢的明星评选</title>
    <script type="text/javascript">
    	
    </script>
	
  </head>
  
  <body>
    <h1 align="center">最喜欢的明星评选</h1>
    <form action="./loginServlet3" method="post" name="form1">
    	<table align="center" width="400" border="1" height="300">
    		<tr bgcolor="cyan">
    			<td align="center">姓名：</td><td><input type="text" name="username"></td>
    		</tr>
	    	<tr bgcolor="pink">
	   			<td align="center">性别：</td><td><input type="text" name="sex"><br></td>
	   		</tr>
	   		<tr bgcolor="yellow">
	   			<td align="center">年龄：</td><td><input type="text" name="age"><br></td>
	   		</tr>
	   		<tr bgcolor="cyan">
	   			<td align="center">电话:</td><td><input type="text" name="telephone"><br></td>
	   		</tr>
	   		<tr bgcolor="green">
   			<td align="center">喜欢的原因</td><td>
   				<select name="reason">
		   			<option value="人长的好看">人长的好看</option>
		   			<option value="课上的好">有钱，与气质</option>
		   			<option value="有魅力">有魅力</option>
		   			<option value="受人欢迎">受人欢迎</option>
   				</select></td>
   			</tr>
   			<tr height="40" bgcolor="coffee">
				<td align="center" width="100">为什么选他(她)</td>
				<td colspan="3">
					<textarea name="remark" id="remark" style="width:200px;height:100px">
					</textarea>
				</td>
			</tr>
			<tr>
   			<td align="center" colspan="2">
   				<input type="submit" name="submit" value="确认">
   			</td>
   		</tr>
    	</table>
    </form>
   </body>
  </html>
