<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.TeacherVo"%>
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
    
    <title>教师界面修改</title>
	
  </head>
  
  <body>
  	<h1 align="center"><font color="#ff3300">修改教师表</font></h1>
  	<form name="form1" action="teacherServlet?action=updateSave" method="post"> 
  		<input type="hidden" name="teacherId" value="${ teacher.teacherId }">
  	 	<table align="center" border="0" width="420" cellspacing="1" cellpadding="1" bgcolor="cyan">
  			<tr height="40">
  				<td align="right">教师电话：</td>
  				<td><input type="text" name="teacherMobile" value="${ teacher.teacherMobile }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教师姓名：</td>
  				<td><input type="text" name="teacherName" value="${ teacher.teacherName }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">性别：</td>
  				<td>
  					<c:if test="${ teacher.sex==0 }" >
  						<input type="radio" checked="checked" name="sex" value="0">男
  						<input type="radio" name="sex"  value="1">女
  					</c:if>
  					<c:if test="${ teacher.sex==1 }">
  						<input type="radio" checked="checked" name="sex"  value="1">女
  						<input type="radio" name="sex"  value="0">男
  					</c:if>
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">家庭住址：</td>
  				<td><input type="text" name="homeAddress" value="${ teacher.homeAddress }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">电子邮箱：</td>
  				<td><input type="text" name="email"  value="${ teacher.email }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教师简介：</td>
  				<td><input type="text" name="teacherIntroduce"  value="${ teacher.teacherIntroduce }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教师特长：</td>
  				<td>
  						<c:if test="${ teacher.teacherSpecial==1 }"><font color="red"><b>Java语言</b></font></c:if>
			  			<c:if test="${ teacher.teacherSpecial==2 }"><font color="red"><b>HTML基础</b></font></c:if>
			  			<c:if test="${ teacher.teacherSpecial==3 }"><font color="red"><b>JavaScript</b></font></c:if>
			  			<c:if test="${ teacher.teacherSpecial==4 }"><font color="red"><b>Ajax</b></font></c:if>
			  			<c:if test="${ teacher.teacherSpecial==5 }"><font color="red"><b>jQuery</b></font></c:if>
			  			<c:if test="${ teacher.teacherSpecial==6 }"><font color="red"><b>EasyUI</b></font></c:if>
  					<select name="teacherSpecial" style="width:100px">
  						<option value="Java语言">Java语言</option>
  						<option value="HTML基础">HTML基础</option>
  						<option value="JavaScript">JavaScript</option>
  						<option value="Ajax">Ajax</option>
  						<option value="jQuery">jQuery</option>
  						<option value="EasyUI">EasyUI</option>
  					</select>
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教师简介：</td>
  				<td><input type="text" name="teacherLength"  value="${ teacher.teacherLength }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">学历：</td>
  				<td>
  						<c:if test="${ teacher.education==1 }"><font color="red"><b>小学</b></font></c:if>
			  			<c:if test="${ teacher.education==2 }"><font color="red"><b>初中</b></font></c:if>
			  			<c:if test="${ teacher.education==3 }"><font color="red"><b>高中</b></font></c:if>
			  			<c:if test="${ teacher.education==4 }"><font color="red"><b>本科</b></font></c:if>
			  			<c:if test="${ teacher.education==5 }"><font color="red"><b>专科</b></font></c:if>
			  			<c:if test="${ teacher.education==6 }"><font color="red"><b>博士</b></font></c:if>
  					<select name="education" style="width:100px">
  						<option value="小学">小学</option>
  						<option value="初中">初中</option>
  						<option value="高中">高中</option>
  						<option value="本科">本科</option>
  						<option value="专科">专科</option>
  						<option value="博士">博士</option>
  					</select>
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">头像上传地址：</td>
  				<td><input type="text" name="headpictureUrl"  value="${ teacher.headpictureUrl }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">银行id：</td>
  				<td>
  						<c:if test="${ teacher.bankId==1 }"><font color="red"><b>中国银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==2 }"><font color="red"><b>中国农业银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==3 }"><font color="red"><b>中国建设银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==4 }"><font color="red"><b>中国工商银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==5 }"><font color="red"><b>九江银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==6 }"><font color="red"><b>交通银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==7 }"><font color="red"><b>中国邮政储蓄银行</b></font></c:if>
  					<select name="bankId" style="width:100px">
  						<option value="1">中国银行</option>
  						<option value="2">中国农业银行</option>
  						<option value="3">中国建设银行</option>
  						<option value="4">中国工商银行</option>
  						<option value="5">九江银行</option>
  						<option value="6">交通银行</option>
  						<option value="7">中国邮政储蓄银行</option>
  					</select>
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">银行账户：</td>
  				<td><input type="text" name="accountNo"  value="${ teacher.accountNo }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">开户人：</td>
  				<td><input type="text" name="accountName"  value="${ teacher.accountName }"></td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教师分类：</td>
  				<td>
  						<c:if test="${ TeacherVo.gradeId==1 }"><font color="red"><b>认证讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==2 }"><font color="red"><b>中级讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==3 }"><font color="red"><b>高级讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==4 }"><font color="red"><b>特级讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==5 }"><font color="red"><b>金牌讲师</b></font></c:if>
  					<select name="gradeId" style="width:100px">
  						<option value="1">认证讲师</option>
  						<option value="2">中级讲师</option>
  						<option value="3">高级讲师</option>
  						<option value="4">特级讲师</option>
  						<option value="5">金牌讲师</option>
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
