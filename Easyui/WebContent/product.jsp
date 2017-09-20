<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=path %>/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="<%=path %>/easyui/themes/icon.css" />
	<link rel="stylesheet" href="<%=path %>/css/site.css" />
</head>
<body>
	<table id="userList" class="easyui-datagrid"
		data-options="
			toolbar:'#tb',
			rownumbers:true,
			border:false,
			singleSelect:true,
			pagination:true,
			pageSize:20,
			url:'<%=path %>/user/user',
			method:'get'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80">编号</th>
				<th data-options="field:'email',width:100">邮箱</th>
				<th data-options="field:'nickname',width:80,align:'right'">昵称</th>
				<th data-options="field:'gender',width:80,align:'right'" formatter="formatGender">性别</th>
				<th data-options="field:'birthday',width:250" formatter="formatDate">生日</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="height: auto">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" onclick="showAddWin('addWin')">添加</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit">修改</a>
	</div>
	
	<!-- 添加窗口 -->
	<div id="addWin" class="easyui-window normal_win" data-options="title:'添加用户', closed:true">
		<form id="addUser">
			<table>
				<tr>
					<td>姓名</td>
					<td>
						<input class="easyui-textbox easyui-validatebox" data-options="prompt:'请输入姓名',
						required:true,
						validType:'length[2,5]',
						novalidate:true,
						buttonText:'SEARCH'"/>
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<select id="gender" style="width:150px"></select>
					</td>
				</tr>
				<tr>
					<td>岗位</td>
					<td>
						<input class="easyui-combobox" 
						name="jobs"
						data-options="
								valueField:'id',
								textField:'text',
								multiple:true,
								panelHeight:'auto',
								data:[
									{'id':'developer','text':'软件工程师','selected':true},
									{'id':'manager','text':'项目经理'}
								]
						">
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>
						<input class="easyui-numberbox" data-options="min:0,max:150,precision:0">
					</td>
				</tr>
				<tr>
					<td>工资</td>
					<td>
						<input class="easyui-numberbox" data-options="min:0,precision:2,groupSeparator:',',prefix:'￥'">
					</td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td>
						<input id="hireDate" class="easyui-datebox" data-options="onSelect:onSelect">
					</td>
				</tr>
				<tr>
					<td>上班时间</td>
					<td><input id="workTime" class="easyui-timespinner" data-options="min:'08:00:00',max:'09:00:00'"/></td>
				</tr>
				<tr>
					<td>生日</td>
					<td>
						<input class="easyui-datetimebox" value="10/11/2012 2:3:56" />
					</td>
				</tr>
				<tr>
					<td>身份证</td>
					<td>
						<input class="easyui-filebox" name="file1" data-options="prompt:'选择文件',buttonText:'选择文件'" />
					</td>
				</tr>
				<tr>
					<td>描述</td>
					<td>
						<input class="easyui-textbox" data-options="prompt:'请输入描述',multiline:true"/>
					</td>
				</tr>
				<tr>
					<td><a class="easyui-linkbutton" onclick="addUser();">确认</a></td>
				</tr>
			</table>
		</form>
		<div id="gender_item">
			<div style="color:#99BBE8;background:#fafafa;padding:5px;">请选择性别</div>
			<div style="padding:10px">
				<input type="radio" name="lang" value="01"><span>男</span><br/>
				<input type="radio" name="lang" value="02"><span>女</span><br/>
				<input type="radio" name="lang" value="03"><span>其他</span><br/>
			</div>
		</div>
	</div>
</body>
	<script src="<%=path %>/js/jquery.min.js"></script>
	<script src="<%=path %>/easyui/jquery.easyui.min.js"></script>
	<script src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="<%=path %>/js/main.js"></script>
	<script>
		$(function() {
			setPagination("userList", 20);
			
			$("#gender").combo({
				editable:false
			});
			
			$('#gender_item').appendTo($('#gender').combo('panel'));
			$('#gender_item input').click(function(){
				var v = $(this).val();
				var s = $(this).next('span').text();
				$('#gender').combo('setValue', v).combo('setText', s).combo('hidePanel');
			});
			
		});
	</script>
</html>