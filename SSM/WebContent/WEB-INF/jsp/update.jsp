<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改用户信息</title>
    
	<!-- 引入jQuery文件 -->
	<script src="/ssmpo/js/jquery-1.11.2.min.js" language="javascript"></script>
	<script type="text/javascript">
	// 控制onsubmit提交的方法，方法名是vform()
		function vform(){
			//获取下面的id值
			var ln = $("#loginname").val();
			var lp = $("#loginpass").val();
			var un = $("#username").val();
			var up = $("#upower").val();
			var bir = $("#birthday").val();
			//判断上面的变量，如果为空字符串不能提交
			if(ln == ""){
				alert("请输入登录名！");
				return false;
			}
			if(lp == ""){
				alert("请输入密码！");
				return false;
			}
			if(un == ""){
				alert("请输入用户名！");
				return false;
			}
			if(up == -1){
				alert("请选择权限！");
				return false;
			}
			if(bir == ""){
				alert("请输入生日！");
				return false;
			}			
			//除以上结果的可以提交，返回true
			return true;
		}
	</script>
  </head>
  
  <body>
  	<!-- 用onsubmit调用上面的方法 -->
    <form action="<%=path %>/uc/update" method="post" onsubmit="return vform()">    
    <c:forEach var="po" items="${uid }">    
        <input type="hidden"  name="userid" value="${po.userid}"/><br/>   
    	<table width="1000" border="1">
	    	<tr>		    	
		    	<th>登录名</th>
		    	<th>密码</th>
		    	<th>用户名</th>
		    	<th>权限</th>
		    	<th>生日</th>
		    	<th>性别</th>
	   		</tr>  		
   			<tr>
		    	<td><input type="text" id="loginname" name="loginname" value="${po.loginname}"></td>
		    	<td><input type="text" id="loginpass" name="loginpass" value="${po.loginpass}"></td>
		    	<td><input type="text" id="username" name="username" value="${po.username }"></td>
		    	<td>
		    		<select id="upower" name="upower" >
		    			<option value="-1">=请选择=</option>
	    				<option value="99">管理员</option>
	    				<option value="1">普通用户</option>
	    			</select>
    			</td>	    			
	    		<td><input type="text" id="birthday" name="birthday" value="${po.birthday }"></td>	
		    	<td>性别：
		   			男<input type="radio" name="sex" value="1">
		    		女<input type="radio" name="sex" value="2">
		    		保密<input type="radio" name="sex" value="3" checked="checked">
		        </td>
		   </tr>
    </table>
    </c:forEach>
    <input type="submit" value="提交"/>
    ${updateUser }<br><!-- 操作提醒 -->
    &nbsp;&nbsp;<a href="<%=path %>/uc/user">返回</a>
    </form>
  </body>
</html>
