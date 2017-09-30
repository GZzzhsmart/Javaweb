<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<title>修改用户信息</title>
	<link rel="stylesheet" href="<%=path%>/css/pintuer.css">
	<link rel="stylesheet" href="<%=path%>/css/admin.css">
	<script type="text/javascript" src="<%=path%>/js/jquery2.js"></script>
	<script type="text/javascript" src="<%=path%>/js/pintuer.js"></script>
	<script type="text/javascript">
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
            return true;
        }
	</script>
</head>

<body>
<div class="panel admin-panel">
	<div class="panel-head"><strong><span class="icon-key"></span> 修改用户资料</strong></div>
	<div class="body-content">
		<form method="post" class="form-x" action="<%=path%>/uc/update" method="post" onsubmit="return vform();">
		<c:forEach var="po" items="${uid }">
			<input type="hidden"  name="userid" value="${po.userid}"/><br/>
			<div class="form-group">
				<div class="label">
					<label>登录名称：</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" id="loginname" name="loginname" size="50" value="${po.loginname}" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>密码：</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" id="loginpass" name="loginpass" size="50" value="${po.loginpass}"  />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>用户名：</label>
				</div>
				<div class="field">
					<input type="text" class="input w50" id="username" name="username" size="50" value="${po.username }" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>权限：</label>
				</div>
				<div class="field">
					<select id="upower" name="upower" class="input w50">
						<option value="-1">请选择</option>
						<option value="99">管理员</option>
						<option value="1">普通用户</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>出生日期：</label>
				</div>
				<div class="field">
					<input type="date" class="input w50" id="birthday" name="birthday" size="50" value="${po.birthday}"  />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label>性别：</label>
				</div>
				<div class="field">
					<input type="radio" name="sex" value="1">男
					<input type="radio" name="sex" value="2">女
					<input type="radio" name="sex" value="3" checked="checked">保密
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label></label>
				</div>
				<div class="field">
					<button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
					<a class="button bg-main icon-check-square-o" href="<%=path%>/uc/user">返回</a>
				</div>
			</div>
			</c:forEach>
		</form>
	</div>
</div>
</body>
</html>
