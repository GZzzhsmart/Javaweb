<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增教师资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.teacherPassword.value==""){
    			alert("请输入教师密码");
    			form1.teacherPassword.focus();
    			return false;
    		}
    		if(form1.teacherName.value==""){
    			alert("请输入教师姓名");
    			form1.teacherName.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">新增教师资料</h1>
    <hr/>
    <form name="form1" action="<%=basePath%>teacherServlet?action=add" method="post" onsubmit="return check();">
    	<table align="center" border="0" cellpadding="1" cellspacing="1" width="500" bgcolor="cyan">
		<tr height="40">
			<td align="right">教师电话：</td>
			<td>
				<input type="text" name="teacherMobile" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">教师密码</td>
			<td><input type="password" name="teacherPassword"  style="width:155px"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">教师姓名</td>
			<td><input type="text" name="teacherName"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td>
			<input type="radio" name="sex" value="0" checked="checked">男
			<input type="radio" name="sex" value="1">女
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">家庭住址</td>
			<td><input type="text" name="homeAddress"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">电子邮箱</td>
			<td><input type="text" name="email"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">教师简介</td>
			<td><input type="text" name="teacherIntroduce"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
  				<td align="right">教师特长：</td>
  				<td>
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
		<tr>
			<td align="right">教龄</td>
			<td><input type="text" name="teacherLength"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
  				<td align="right">学历：</td>
  				<td>
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
		<tr>
			<td align="right">头像上传地址</td>
			<td><input type="text" name="headpictureUrl"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
  			<td align="right">银行id：</td>
  				<td>
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
		<tr>
			<td align="right">银行账户</td>
			<td><input type="text" name="accountNo"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">开户人</td>
			<td><input type="text" name="accountName"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
  				<td align="right">教师分类：</td>
  				<td>
  					<select name="gradeId" style="width:100px">
  						<option value="1">认证讲师</option>
  						<option value="2">中级讲师</option>
  						<option value="3">高级讲师</option>
  						<option value="4">特级讲师</option>
  						<option value="5">金牌讲师</option>
  					</select>
  				</td>	
  		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
