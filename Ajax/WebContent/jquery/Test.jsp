<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生资料管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.1.js"></script>
    <script type="text/javascript">
    	var action = "add";
    	$(function(){
    		$("#btnAdd").bind("click",function(){
    			var studid = document.getElementById("studid").value;
    			var studname = document.getElementById("studname").value;
    			var cardid = document.getElementById("cardid").value;
    			var classname = document.getElementById("classname").value;
    			var age = document.getElementById("age").value;
    			if(studid==""){
    				alert("请输入学号");
    				document.getElementById("studid").focus();
    				return;
    			}
    			if(studname==""){
    				alert("请输入姓名");
    				document.getElementById("studname").focus();
    				return;
    			}
    			if(cardid==""){
    				alert("请输入身份证号");
    				document.getElementById("cardid").focus();
    				return;
    			}
    			if(classname==""){
    				alert("请输入班级名称");
    				document.getElementById("classname").focus();
    				return;
    			}
    			if(age==""){
    				alert("请输入年龄");
    				document.getElementById("age").focus();
    				return;
    			}
    			var url = "${pageContext.request.contextPath}/studentServlet";
    			$.post(
					url,
					{
						"studid":$("#studid").val(),
						"studname":$("#studname").val(),
						"cardid":$("#cardid").val(),
						"age":$("#age").val(),
						"classname":$("#classname").val(),
						"sex":$("input[name=sex]:checked").val(),
						"action":action
					},
					function(data){
						var trs = "";
						for(var i = 0 ;i<data.length;i++){
							trs+="<tr>";
							trs+="<td>"+data[i].studid+"</td>";
							trs+="<td>"+data[i].studname+"</td>";
							trs+="<td>"+data[i].cardid+"</td>";
							trs+="<td>"+data[i].age+"</td>";
							trs+="<td>"+data[i].sex+"</td>";
							trs+="<td>"+data[i].classname+"</td>";
							trs+="<td>";
							trs+="<a href='javascript:void(0);' onclick='del('"+data[i].studid+"');'>删除</a>&nbsp;&nbsp;";
							trs+="<a href='javascript:void(0);' onclick='update('"+data[i].studid+"')'>修改</a>";
							trs+="</td>";
							trs+="</tr>";
						}
						$("#studList").html(trs);
					},
					"json"		
    			);
    		});
    		$("#refresh").bind("click",function(){
    			var url = "${pageContext.request.contextPath}/studentServlet";
    			$.post(
					url,
					{
						"action":"list"
					},
					function(data){
						var trs = "";
						for(var i = 0 ;i<data.length;i++){
							trs+="<tr>";
							trs+="<td>"+data[i].studid+"</td>";
							trs+="<td>"+data[i].studname+"</td>";
							trs+="<td>"+data[i].cardid+"</td>";
							trs+="<td>"+data[i].age+"</td>";
							trs+="<td>"+data[i].sex+"</td>";
							trs+="<td>"+data[i].classname+"</td>";
							trs+="<td>";
							trs+="<a href='javascript:void(0);' onclick=\"del('"+data[i].studid+"');\">删除</a>&nbsp;&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"update('"+data[i].studid+"');\">修改</a>";
							trs+="</td>";
							trs+="</tr>";
						}
						$("#studList").html(trs);
					},
					"json"		
    			);
    		});
    	});
    	
    	//删除学生
    	function del(studid){
    		if(!confirm('删除确认')){
    			return;
    		}
    		var url = "${pageContext.request.contextPath}/studentServlet";
   			$.post(
				url,
				{
					"studid":studid,
					"action":"del"
				},
				function(data){
					var trs = "";
					for(var i = 0 ;i<data.length;i++){
						trs+="<tr>";
						trs+="<td>"+data[i].studid+"</td>";
						trs+="<td>"+data[i].studname+"</td>";
						trs+="<td>"+data[i].cardid+"</td>";
						trs+="<td>"+data[i].age+"</td>";
						trs+="<td>"+data[i].sex+"</td>";
						trs+="<td>"+data[i].classname+"</td>";
						trs+="<td>";
						trs+="<a href='javascript:void(0);' onclick=\"del('"+data[i].studid+"');\">删除</a>&nbsp;&nbsp;";
						trs+="<a href='javascript:void(0);' onclick=\"update('"+data[i].studid+"');\">修改</a>";
						trs+="</td>";
						trs+="</tr>";
					}
					$("#studList").html(trs);
				},
				"json"		
   			);
    	}
    	
    	//修改学生资料
    	function update(studid){
    		var url = "${pageContext.request.contextPath}/studentServlet";
   			$.post(
				url,
				{
					"studid":studid,
					"action":"update"
				},
				function(data){
					$("#studid").val(data.studid);
					$("#studname").val(data.studname);
					$("#cardid").val(data.cardid);
					$("#age").val(data.age);
					$("#classname").val(data.classname);
					var sex = data.sex;
					$("input[name=sex]").each(function(i,v){
						if($(v).val()==sex){
							$(v).attr("checked",true);
						}
					});
					action="updatesave";
				},
				"json"		
   			);
    	}
   		/*
    	//分页
    	function play(data){
			var trs="";
			for(var i=0;i<data.length;i++){
				if(i<data.length-1){
					trs+="<tr>";
					trs+="<td>"+data[i].studid+"</td>";
					trs+="<td>"+data[i].studname+"</td>";
					trs+="<td>"+data[i].sex+"</td>";
					trs+="<td>"+data[i].cardid+"</td>";
					trs+="<td>"+data[i].age+"</td>";
					trs+="<td>"+data[i].classname+"</td>";
					trs+="<td>";
					trs+="<a href='javascript:void(0);' onclick='del("+data[i].studid+");'>删除</a>&nbsp;&nbsp;";
					trs+="<a href='javascript:void(0);' onclick='update("+data[i].studid+");'>修改</a>";
					trs+="</td>";
					trs+="</tr>";
				}else{
					trs+="<tr align='center'><td colspan='7'>";
					trs+="<span>总记录数："+data[i].recordCount+"</span>";
					trs+="<span>页码："+data[i].pageCount+"/"+data[i].currentPage+"</span>";
					trs+="<a href='javascript:void(0);' onclick=\"first('1');\">首页</a>";
					trs+="<a href='javascript:void(0);' onclick=\"up('"+data[i].currentPage+"');\">上一页</a>";
					trs+="<a href='javascript:void(0);' onclick=\"down('"+data[i].currentPage+"');\">下一页</a>";
					trs+="<a href='javascript:void(0);' onclick=\"last('"+data[i].currentPage+"');\">尾页</a>";
					trs+="</td></tr>";
				}
			}
			$("#studList").html(trs);
			
		}
		function first(data){
			var url = "${pageContext.request.contextPath}/studentServlet",
			$.post(
				url,
				{
					"action":"list",
					"opr":"first",
					"currentPage":data
				},
				play,  
				"json"
			);
		}
		function up(data){
			var url ="${pageContext.request.contextPath}/studentServlet";
			$.post(
				url,
				{
					"action":"list",
					"opr":"piror",
					"currentPage":data
				},
				play,  
				"json"
			);
			
		}
		function down(data){
			var url="${pageContext.request.contextPath}/studentServlet";
			$.post(
				url,
				{
					"action":"list",
					"opr":"next",
					"currentPage":data
				},
				play,  
				"json"
			);
		}
		function last(data){
			var url="${pageContext.request.contextPath}/studentServlet";
			$.post(
				url,
				{
					"action":"list",
					"opr":"last",
					"currentPage":data
				},
				play,  
				"json"
			);
		}
		*/
		
    </script>
  </head>
  
  <body>
    <h1 align="center">学生资料管理</h1>
    <hr/>
    <center>
    	<table border="0" cellpadding="3" cellspacing="1" width="400" bgcolor="pink">
    		<tr height="20">
    			<td align="right">学号：</td>
    			<td>
    				<input type="text" name="studid" id="studid">
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">姓名：</td>
    			<td>
    				<input type="text" name="studname" id="studname">
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">身份证：</td>
    			<td>
    				<input type="text" name="cardid" id="cardid">
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">年龄：</td>
    			<td>
    				<input type="text" name="age" id="age">
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">性别：</td>
    			<td>
	    			<input type="radio" name="sex" id="sex" value="男" checked="checked">男
	    			<input type="radio" name="sex" id="sex" value="女">女
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">班级：</td>
    			<td>
    				<input type="text" name="classname" id="classname">
    			</td>
    		</tr>
    		<tr>
    			<td colspan="6" align="center"><input type="button" id="btnAdd" value="保存"></td>
    		</tr>
    	</table>
    	<hr/>
    	<h1 id="refresh">学生资料列表</h1>
    	<table border="0" cellpadding="3" cellspacing="1" width="800" bgcolor="pink">
    		<thead>
    			<tr>
    				<th>学号</th>
    				<th>姓名</th>
    				<th>身份证</th>
    				<th>年龄</th>
    				<th>性别</th>
    				<th>班级</th>
    				<th>操作</th>
    			</tr>
    		</thead>
    		<tbody id="studList">
    		</tbody>
    	</table>
    	<!--  
    	<table align="center" border="0" cellpadding="3" cellspacing="1" width="800" bgcolor="pink">
    		<tr >
				<td>
					<a href="">总记录数&nbsp;&nbsp;${pager.recordCount }</a>
					<a href="">页码&nbsp;&nbsp;${pager.currentPage }/${pager.pageCount }页</a>
					<a href="javascript:void(0);" onclick="first();">首   页</a>
					<a href="javascript:void(0);" onclick="up(${pager.currentPage });">上一页</a>
					<a href="javascript:void(0);" onclick="down(${pager.currentPage });" >下一页</a>
					<a href="javascript:void(0);" onclick="last(${pager.pageCount });">尾  页</a> 
				</td>
		    </tr>
    	</table>
    	-->
    </center>
  </body>
</html>
