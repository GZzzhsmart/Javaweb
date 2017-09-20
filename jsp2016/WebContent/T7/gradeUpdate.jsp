<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.TeacherGradeVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改讲师等级资料</title>
    <script type="text/javascript">
    	function check(){
    		if(form1.gradeName.value==""){
    			alert("请输入讲师等级名称");
    			form1.gradeName.focus();
    			return false;
    		}
    		if(form1.gradePercent.value==""){
    			alert("请输入提成比例，在0~1之间的数字");
    			form1.gradePercent.focus();
    			return false;
    		}
    		if(isNaN(form1.gradePercent.value)){
    			alert("提成比例含有非法字符，请输入0~1之间的数字");
    			form1.gradePercent.focus();
    			return false;
    		}
    		var percent = form1.gradePercent.value;
    		if(parseFloat(percent)<0 || parseFloat(percent)>1){
    			alert("提成比例必须是0~1之间的小数");
    			form1.gradePercent.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <h1 align="center">修改讲师等级资料</h1>
    <hr/>
    <%
    	TeacherGradeVo grade = (TeacherGradeVo)request.getAttribute("grade");
     %>
    <form name="form1" action="<%=basePath%>GradeServlet?action=updateSave" method="post" onsubmit="return check();">
    	<input type="hidden" name="gradeId" value="<%=grade.getGradeId() %>">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="500">
		<tr height="40">
			<td align="right">讲师等级名称：</td>
			<td><input type="text" name="gradeName" value="<%=grade.getGradeName() %>"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">提成比例：</td>
			<td><input type="text" name="gradePercent" value="<%=grade.getGradePercent() %>"></td>
			<td><font size="2" color="red">*在0~1之间的小数</font></td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
