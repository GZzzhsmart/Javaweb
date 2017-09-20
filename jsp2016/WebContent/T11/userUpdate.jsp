<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.mobile.value==""){
    			alert("请输入手机号码。");
    			form1.mobile.focus();
    			return false;
    		}
    		if(form1.homeAddress.value==""){
    			alert("请输入家庭住址。");
    			form1.homeAddress.focus();
    			return false;
    		}
    		if(form1.userName.value==""){
    			alert("请输入真实姓名");
    			form1.userName.focus();
    			return false;
    		}
    		return true;
    	}
    	function changeProv(provinceId){
    		var mobile = form1.mobile.value;
    		alert(mobile);
    		var userName = form1.userName.value;
    		alert(userName);
    		var homeAddress = form1.homeAddress.value;
    		alert(homeAddress);
    		var email = form1.email.value;
    		alert(email);
    		location.href="<%=basePath%>usersServlet?action=update&provinceId="+provinceId+"&mobile="+mobile+"&userName="+userName+"&homeAddress="+homeAddress+"&email="+email;
    		
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">修改用户资料</h1>
    <hr/>
    <h3 align="center"><font color="red">${msg}</font></h3>
    <form name="form1" action="<%=basePath%>usersServlet?action=updateSave" method="post" onsubmit="return check();">
    	<input type="hidden" name="userid" value="${user.userid}">
    	<table align="center" border="0" cellpadding="1" cellspacing="1" width="500" bgcolor="yellow">
		<tr height="40">
			<td align="right">省份名称：</td>
			<td>
				<select name="provinceId" style="width:155px" onchange="changeProv(this.value);">
					<c:forEach items="${provList}" var="d">
						<c:if test="${d.provinceId == provinceId}">
							<option value="${d.provinceId}" selected="selected">${d.provinceName}</option>
						</c:if>
						<c:if test="${d.provinceId != provinceId}">
							<option value="${d.provinceId}">${d.provinceName}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td align="right">城市名称：</td>
			<td>
				<select name="cityId" style="width:155px" >
					<c:forEach items="${cityList}" var="d">
						<option value="${d.cityId}">${d.cityName}</option>
					</c:forEach>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td align="right">手机号码：</td>
			<td>
				<c:if test="${requestScope.tel==null}">
					<input type="text" name="mobile" style="width:155px" value="${user.mobile}"/>
				</c:if>
				<c:if test="${requestScope.tel!=null}">
					<input type="text" name="mobile" style="width:155px" value="${requestScope.tel}"/>
				</c:if>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		
		<tr>
			<td align="right">真实姓名</td>
			<td>
				<c:if test="${requestScope.name==null}">
					<input type="text" name="userName" style="width:155px" value="${user.userName}"/>
				</c:if>
				<c:if test="${requestScope.name!=null}">
					<input type="text" name="userName" style="width:155px" value="${requestScope.name}"/>
				</c:if>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td>
			<c:if test="${user.sex==0}">
				<input type="radio" name="sex" value="0" checked="checked">男
				<input type="radio" name="sex" value="1">女
			</c:if>
			<c:if test="${user.sex==1}">
				<input type="radio" name="sex" value="0">男
				<input type="radio" name="sex" value="1"  checked="checked">女
			</c:if>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">家庭地址</td>
			<td>
				<c:if test="${requestScope.home==null}">
					<input type="text" name="homeAddress" style="width:155px" value="${user.homeAddress}"/>
				</c:if>
				<c:if test="${requestScope.home!=null}">
					<input type="text" name="homeAddress" style="width:155px" value="${requestScope.home}"/>
				</c:if>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">电子邮件</td>
			<td>
				<c:if test="${requestScope.em==null}">
					<input type="text" name="email" style="width:155px" value="${user.email}"/>
				</c:if>
				<c:if test="${requestScope.em!=null}">
					<input type="text" name="email" style="width:155px" value="${requestScope.em}"/>
				</c:if>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
