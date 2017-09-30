<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ajax验证注册用户是否存在</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax.js"></script>
    <script type="text/javascript">
    	//接收数据
		function recedata(){
			if(xmlhttp.status==200){
				if(xmlhttp.readyState==4){
					//responseText：服务器发送给客户端的数据
					var msg=xmlhttp.responseText;
					if(msg=="succ"){
						document.getElementById('imgpic').src="images/tiku_icon_right.png";
						document.getElementById('imgpic').style.visibility='visible';
					}else if(msg=="fail"){
						document.getElementById('imgpic').src="images/tiku_icon_wrong.png";
						document.getElementById('imgpic').style.visibility='visible';
					}else if(msg=="ok"){
						alert("恭喜你注册成功");
					}
					
				}
			}
		}
		//验证学号是否存在
		function validateUser(){
			//获取学号
			var studid = document.getElementById("studid").value;
			if(studid==""){
				alert("请输入学号");
				return;
			}
			var param="action=check&studid="+studid;
			var url = "${pageContext.request.contextPath}/ajaxServlet";
			send('post',url,param,true);
			
		}
		//注册
		function regsave(){
			var studid = document.getElementById("studid").value;
			if(studid==""){
				alert("请输入学号");
				document.getElementById("studid").focus();
				return;
			}
			var studname = document.getElementById("studname").value;
			if(studname==""){
				alert("请输入姓名");
				document.getElementById("studname").focus();
				return;
			}
			var age = document.getElementById("age").value;
			if(age==""){
				alert("请输入年龄，必须是0到120之间的数字");
				document.getElementById("age").focus();
				return;
			}
			var hobit = document.getElementById("hobit").value;
			if(hobit==""){
				alert("请输入你的爱好");
				document.getElementById("hobit").focus();
				return;
			}
			
			var sex = document.getElementById("sex").value;
			if(!document.getElementById("sex").checked){
				sex = "女";
			}
			var classid = document.getElementById("classid").value;
			
			var param="action=save&studid="+studid +"&studname="+studname;
			param = param + "&age="+age+"&hobit="+hobit+"&sex="+sex+"&classid="+classid;
			alert(param);
			var url = "${pageContext.request.contextPath}/ajaxServlet";
			send('post',url,param,true);
		}
    </script>

  </head>
  
  <body>
    <h1 align="center">Ajax验证注册学生是否存在</h1>
    <hr>
    学号：<input type="text" name="studid" id="studid"/><img src="images/tiku_icon_right.png" id="imgpic" height="20" style="visibility:hidden"><br/><br/>
    <input type="button" value="检查学号是否存在" onclick="validateUser();"><br/><br/>
    姓名：<input type="text" name="studname" id="studname"/><br/><br/>
    年龄: <input type="text" name="age" id="age"/><br/><br/>
    爱好：<input type="text" name="hobit" id="hobit"/><br/><br/>
    性别: <input type="radio" name="sex" id="sex" value="男" checked/>男
    	 <input type="radio" name="sex"  id="sex" value="女"/>女<br/><br/>
    班级:
    	<select name="classid" id="classid">
    		<option value="1">2016宏图1班</option>
    		<option value="2">2016宏图2班</option>
    		<option value="3">2016宏图3班</option>
    		<option value="4">2016宏图4班</option>
    	</select><br/><br/>
    <input type="button" value="注册" onclick="regsave();">
  </body>
</html>
