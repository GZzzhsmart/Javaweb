<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jQuery事件</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
	<script type="text/javascript">
		//事件绑定
		$(function(){
			//alert("ok");
			//绑定事件
			$("#btnTest").bind("click",function(){
				alert("btnTest");
			});
			/*
			$("#username").bind("mouseover",function(){
				$("#username").css("background","#ff1188");
			});
			$("#username").bind("mouseout",function(){
				$("#username").css("background","#ffffff");
			});
			*/
			$("#username").hover(
				function(){
				$("#username").css("background","#ff1188");
				},
				function(){
					$("#username").css("background","#ffffff");
			});
			//失去焦点
			$("#username").bind("blur",function(){
				var val = $("#username").val();
				if(val==""){
					alert("请输入用户名称");
					$("#username").focus();
					return;
				}
				if(isNaN(val)){
					alert("只能输入数字");
					$("#username").focus();
					return;
				}
			});
			$("#btnTest3").bind("click",function(){
				$("#btnTest").trigger("click");
				$("#username").trigger("blur");
			});
			$("#btnTest4").bind("click",function(){
				$("#p1").append("追加的内容");
				$("#p1").after("追加内容到P标签后面");
				$("#p1").before("追加内容到P标签前面");
			});
			$("#btnTest5").bind("click",function(){
				$("#p1").appendTo("div");
			});
		});
		function test2(){
			$("#username").unbind("blur");
			alert("成功取消了username控件的失去焦点事件");
		}
	</script>

  </head>
  
  <body>
    <h1 align="center">jQuery事件</h1>
    <hr/>
    <input type="text" id="username"><br/>
    <input type="button" id="btnTest" value="事件测试"><br/>
    <input type="button" id="btnTest2" value="取消事件的绑定" onclick="test2();"><br/>
    <input type="button" id="btnTest3" value="触发事件测试按钮的单击事件">
    <hr/>
    <p id="p1">P标签的内容</p>
    <div>div1</div>
    <input type="button" id="btnTest4" value="追加内容到P标签">
    <input type="button" id="btnTest5" value="把P标签的内容追加到DIV中">
  </body>
</html>
