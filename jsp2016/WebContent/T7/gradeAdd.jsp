<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增讲师等级资料</title>
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
    <h1 align="center">新增讲师等级资料</h1>
    <hr/>
    <form name="form1" action="<%=basePath%>GradeServlet?action=add" method="post" onsubmit="return check();">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="500">
		<tr height="40">
			<td align="right">讲师等级名称：</td>
			<td><input type="text" name="gradeName"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">提成比例：</td>
			<td><input type="text" name="gradePercent"></td>
			<td><font size="2" color="red">*在0~1之间的小数</font></td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
