<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
	<title>示例</title>
	<script type="text/javascript">
		function check(){
			if(document.form1.yourName.value==""){
				alert("请输入你的姓名");
			}else{
				document.form1.submit();
			}
		}
	</script>
</head>
<body>
	<form action="TestB.jsp" name="form1" method="post">
		<p>你的姓名：
			<input type="text" name="yourName">
			<input type="button" value="提交" onClick="check()">
		</p>
	</form>
</body>
</html>
