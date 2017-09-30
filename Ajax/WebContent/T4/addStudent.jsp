<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" pageEncoding="gb2312" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>新增学生信息</title>
<style type="text/css">
<!--
.style1 {
	font-size: 36px;
	font-family: "楷体_GB2312";
}
.style2 {color: #273443}
-->
</style>
<script language="javascript" src="dwr/interface/TeamDAO.js"></script>
<script language="javascript" src="dwr/interface/StudentDAO.js"></script>
<script language="javascript" src='dwr/engine.js'></script>
<script language="javascript" src='dwr/util.js'></script>
</head>
<script type="text/javascript">
	function addStudent(){
		var stuName=document.frm.stuName.value;
		var stuNo=document.frm.stuNo.value;
		var teamId=document.frm.teamId.value;
		
		var stu = {stuName:stuName,stuNo:stuNo,teamId:teamId};
		
		StudentDAO.addStudent(stu,function(result){
			if(result){
				alert("添加学生成功!!");
				window.opener.document.location.reload(); 
				close();
			}
			else{
				alert("添加学生失败!!");
			}
		});
	}
	
	function initTeamList(){		
		TeamDAO.findAllTeam(function(data){
			var teamId = document.getElementById("teamId");
			teamId.length = 0;
			for(var i = 0;i<data.length;i++){
				teamId.add(document.createElement("option"));
				teamId.options[i].value=data[i].id;
				teamId.options[i].text=data[i].teamName;
			}
		});
	}
</script>
<body onload="initTeamList();">
	<h1 align="center">新增学生</h1>
	<hr/>
	<form  action="" name="frm">
	<table width="440" border="0" cellpadding="0" cellspacing="0">
	  <!--DWLayoutTable-->
	  <tr>
	    <td height="52" colspan="2" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
	      <!--DWLayoutTable-->
	      <tr>
	        <td width="764" height="52" valign="middle"><div align="center" class="style1 style2">添加学生</div></td>
	      </tr>
	    </table></td>
	  </tr>
	  <tr>
	    <td width="157" height="26" valign="top"><div align="right">班级：</div></td>
	    <td width="283" valign="top">
	    <select name=teamId id="teamId">
	    	<option value="1">1601班</option>
	    	<option value="2">1602班</option>
	    	<option value="3">1603班</option>
	    	<option value="4">1604班</option>
	    </select>
	  </tr>
	  <tr>
	    <td height="26" valign="top"><div align="right">学生名称：</div></td>
	    <td valign="top"><input type="text" name="stuName"></td>
	  </tr>
	  <tr>
	    <td height="26" valign="top"><div align="right">学生学号：</div></td>
	    <td valign="top"><input type="text" name="stuNo"></td>
	  </tr>
	  <tr>
	    <td height="26" colspan="2" valign="top"><div align="center">
	       <input type="button" name="Submit" value="添加" onclick="addStudent();" >
	      &nbsp;
	      <input type="button" name="ss" value="返回">
	    </div></td>
	  </tr>
	  <tr>
	    <td height="110" colspan="2">&nbsp;</td>
	  </tr>
	</table>
	
	</form>
</body>
</html>
