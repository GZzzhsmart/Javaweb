<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生资料管理</title>
     <script type="text/javascript" src="<%=basePath %>js/jquery-1.4.1.js"></script>
	<script type="text/javascript">
		$(function(){
    		$("#btnAdd").bind("click",function(){
				var url="<%=basePath%>studServlet";
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
				$.post(
					url,
					{
						"studid":$("#studid").val(),
						"studname":$("#studname").val(),
						"cardid":$("#cardid").val(),
						"age":$("#age").val(),
						"classname":$("#classname").val(),
						"sex":$("input[name=sex]:checked").val(),
						"action":"add"
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
							trs+="<td align='center'>";
							trs+="<a href='javascript:void(0);' onclick='add();'>新增</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"del('"+data[i].studid+"');\">删除</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"update('"+data[i].studid+"')\">修改</a>";
							trs+="</td>";
							trs+="</tr>";
						}
						
					 	document.getElementById('table2').style.display='block';
					 	document.getElementById('table3').style.display='none';
						document.getElementById('table1').style.display='none';
						$("#studList").html(trs);
					},
					"json"		
    			);
			});
			$("#refresh").bind("click",function(){
				var url="<%=basePath%>studServlet";
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
							trs+="<td align='center'>";
							trs+="<a href='javascript:void(0);' onclick='add();'>新增</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"del('"+data[i].studid+"');\">删除</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"update('"+data[i].studid+"')\">修改</a>";
							trs+="</td>";
							trs+="</tr>";
						}
					 	document.getElementById('table2').style.display='block';
					 	document.getElementById('table3').style.display='none';
						document.getElementById('table1').style.display='none';
						$("#studList").html(trs);
					},
					"json"		
    			);
			});
			
			
		});
		function add(){
				document.getElementById('table2').style.display='none';
				document.getElementById('table3').style.display='none';
				document.getElementById('table1').style.display='block';
		}
		//删除学生
		function del(studid){
			if(!confirm("确认删除")){
				return;
			}
			var url="<%=basePath%>studServlet";
				$.post(
					url,
					{	"studid":studid,
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
							trs+="<td align='center'>";
							trs+="<a href='javascript:void(0);' onclick='add();'>新增</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"del('"+data[i].studid+"');\">删除</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"update('"+data[i].studid+"')\">修改</a>";
							trs+="</td>";
							trs+="</tr>";
						}
						 	document.getElementById('table2').style.display='block';
						 	document.getElementById('table3').style.display='none';
							document.getElementById('table1').style.display='none';
						$("#studList").html(trs);
					},
					"json"		
    			);
		}
		//修改学生资料
		function update(studid){
			var url="<%=basePath%>studServlet";
				$.post(
					url,
					{	"studid":studid,
						"action":"update"
					},
					function(data){
						$("#studid1").val(data.studid);
						$("#studname1").val(data.studname);
						$("#cardid1").val(data.cardid);
						$("#age1").val(data.age);
						var sex1=data.sex;
						$("input[name=sex1]").each(function(i,v){
							if($(v).val()==sex1){
								$(v).attr("checked",true);
							}
						});
						$("#classname1").val(data.classname);
					 	document.getElementById('table2').style.display='none';
						document.getElementById('table1').style.display='none';
						document.getElementById('table3').style.display='block';
					},
					"json"		
    			);
    			
		}
		$(function(){
			$("#btnupdate").bind("click",function(){
				var url="<%=basePath%>studServlet";
				$.post(
					url,
					{
						"studid":$("#studid1").val(),
						"studname":$("#studname1").val(),
						"cardid":$("#cardid1").val(),
						"age":$("#age1").val(),
						"classname":$("#classname1").val(),
						"sex":$("input[name=sex1]:checked").val(),
						"action":"updatesave"
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
							trs+="<td align='center'>";
							trs+="<a href='javascript:void(0);' onclick='add();'>新增</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"del('"+data[i].studid+"');\">删除</a>&nbsp;";
							trs+="<a href='javascript:void(0);' onclick=\"update('"+data[i].studid+"')\">修改</a>";
							trs+="</td>";
							trs+="</tr>";
						}
					 	document.getElementById('table2').style.display='block';
					 	document.getElementById('table3').style.display='none';
						document.getElementById('table1').style.display='none';
						$("#studList").html(trs);
					},
					"json"		
    			);
			});
		});
		
	</script>
  </head>
  
  <body>
    <h1 align="center" id="refresh">学生资料管理</h1>
    <hr/>
    <center>
    <div id="msg"></div>
    	<table border="1" id="table1" width="400">
    		<tr height="20">
    			<td align="right">学号:</td>
    			<td>
    				<input type="text" name="studid" id="studid"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">姓名:</td>
    			<td>
    				<input type="text" name="studname" id="studname"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">身份证:</td>
    			<td>
    				<input type="text" name="cardid" id="cardid"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">年龄:</td>
    			<td>
    				<input type="text" name="age" id="age"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">性别:</td>
    			<td>
    				<input type="radio" name="sex" id="sex" checked="checked" value="男">男
    				<input type="radio" name="sex" id="sex" value="女">女
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">班级:</td>
    			<td>
    				<input type="text" name="classname" id="classname"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="6" align="center"><input type="button" id="btnAdd" value="新增"></td>
    		</tr>
    	</table>
    	<table border="1" id="table2" width="800" style="display:none">
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
    	
    	<table border="1" id="table3" width="800" style="display:none">
    		<tr>
    			<td align="right">学号:</td>
    			<td>
    				<input type="text" name="studid1" id="studid1"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">姓名:</td>
    			<td>
    				<input type="text" name="studname1" id="studname1"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">身份证:</td>
    			<td>
    				<input type="text" name="cardid1" id="cardid1"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">年龄:</td>
    			<td>
    				<input type="text" name="age" id="age1"/>
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">性别:</td>
    			<td>
    				<input type="radio" name="sex1" id="sex1" value="男">男
    				<input type="radio" name="sex1" id="sex1" value="女">女
    			</td>
    		</tr>
    		<tr height="20">
    			<td align="right">班级:</td>
    			<td>
    				<input type="text" name="classname1" id="classname1"/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="6" align="center"><input type="button" id="btnupdate" value="修改"></td>
    		</tr>
    	</table>
    </center>
  </body>
</html>
