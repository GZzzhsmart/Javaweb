<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.StudentVo"%>
<%@page import="base.IBaseDAO"%>
<%@page import="base.BaseDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生界面修改</title>
	
  </head>
  
  <body>
  	<h1 align="center"><font color="#ff3300">修改学生管理表</font></h1>
  	<form name="form1" action="studentServlet?action=updateSave" method="post"> 
  		<input type="hidden" name="studentid" value="${ studentVo.userId }">
  	 	<table align="center" border="0" width="420" cellspacing="1" cellpadding="1" bgcolor="pink">
  			<tr height="40">
  				<td align="right">手机号：</td>
  				<td><input type="text" name="phone" value="${ studentVo.mobile }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">用户姓名：</td>
  				<td><input type="text" name="username" value="${ studentVo.username }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">性别：</td>
  				<td>
  					<c:if test="${ studentVo.sex==0 }" >
  						<input type="radio" checked="checked" name="sex" value="0">男
  						<input type="radio" name="sex"  value="1">女
  					</c:if>
  					<c:if test="${ studentVo.sex==1 }">
  						<input type="radio" checked="checked" name="sex"  value="1">女
  						<input type="radio" name="sex"  value="0">男
  					</c:if>
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">家庭住址：</td>
  				<td><input type="text" name="homeaddr"   value="${ studentVo.homeaddress }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">邮箱：</td>
  				<td><input type="text" name="email"  value="${ studentVo.email }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">所在省份：</td>
  				<td>  
			  			<c:if test="${ studentVo.provinceId==1 }"><font color="red"><b>北京</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==2 }"><font color="red"><b>天津</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==3 }"><font color="red"><b>河北省</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==4 }"><font color="red"><b>山西省</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==14 }"><font color="red"><b>江西省</b></font></c:if>
  					<select name="province" style="width:100px" >
  						<option value="1">北京</option>
  						<option value="2">天津</option>
  						<option value="3">河北省</option>
  						<option value="4">山西省</option>
  						<option value="14">江西省</option>
  					</select>
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">所在城市：</td>
  				<td>
			  			<c:if test="${ studentVo.provinceId==1 }"><font color="red"><b>石景山区</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==2 }"><font color="red"><b>海淀区</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==17 }"><font color="red"><b>东丽区</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==18 }"><font color="red"><b>西青区</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==32 }"><font color="red"><b>石家庄市</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==33 }"><font color="red"><b>邯郸市</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==43 }"><font color="red"><b>大同市</b></font></c:if>
			  			<c:if test="${ studentVo.provinceId==44 }"><font color="red"><b>太原市</b></font></c:if>
  						<c:if test="${ studentVo.provinceId==165 }"><font color="red"><b>南昌市</b></font></c:if>
  						<c:if test="${ studentVo.provinceId==170 }"><font color="red"><b>赣州市</b></font></c:if>
  					
  					<select name="city" style="width:100px" >
  						<option value="1">石景山区</option>
  						<option value="2">海淀区</option>
  						<option value="17">东丽区</option>
  						<option value="18">西青区</option>
  						<option value="32">石家庄市</option>
  						<option value="33">邯郸市</option>
  						<option value="43">大同市</option>
  						<option value="44">太原市</option>
  						<option value="165">南昌市</option>
  						<option value="170">赣州市</option>
  					</select>
  				</td>	
  			</tr>
	  		<tr>
	  			<td colspan="2" align="center"><input type="submit" value=" 修 改 ">&nbsp;
	  			&nbsp;&nbsp;&nbsp;<input type="reset" value=" 清 空 "></td>
	  		</tr>
  		</table>
  	</form>
   	
  </body>
</html>
