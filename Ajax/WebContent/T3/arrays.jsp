<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>arrays.jsp</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/prototype.js"></script>
  	<script type="text/javascript">
  		function findEmployeeById(emp_id){
			var listBox = $('lstEmployees')
			var options = listBox.getElementsByTagName('option');
			options = $A(options);
			var opt = options.find( function(employee){
				return (employee.value == emp_id);
			});
			alert(opt.text); 
		}
  	</script>
  </head>
  
  <body>
    <select id="lstEmployees" size="10">
    <option value="5">
		Buchanan, Steven
	</option>
	<option value="8">
		Callahan, Laura
	</option>
	<option value="1">
		Davolio, Nancy
	</option>
    </select>
    <input type="button" value="Find Laura" onclick="findEmployeeById(1);">
  </body>
</html>
