<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery Easyui Demo</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/easyui/demo.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Custom ValidateBox Tooltip</h2>
	<p>This sample shows how to display another tooltip message on a valid textbox.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Register" style="width:400px;padding:10px 60px 20px 60px;">
		<table cellpadding="5">
			<tr>
				<td>用户名称：</td>
				<td><input class="easyui-validatebox textbox" data-options="prompt:'Enter User Name.',required:true,validType:'length[3,10]'"></td>
			</tr>
			<tr>
				<td>电子邮箱:</td>
				<td><input class="easyui-validatebox textbox" data-options="prompt:'Enter a valid email.',required:true,validType:'email'"></td>
			</tr>
			<tr>
				<td>出生日期:</td>
				<td><input class="easyui-datebox"></td>
			</tr>
			<tr>
				<td>访问地址:</td>
				<td><input class="easyui-validatebox textbox" data-options="prompt:'Enter your URL.',required:true,validType:'url'"></td>
			</tr>
			<tr>
				<td>手机号码:</td>
				<td><input class="easyui-validatebox textbox" data-options="prompt:'Enter your phone number.',required:true"></td>
			</tr>
		</table>
	</div>
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$('input.easyui-validatebox').validatebox({
				// the options to create tooltip
				tipOptions: {	
					showEvent: 'mouseenter',
					hideEvent: 'mouseleave',
					showDelay: 0,
					hideDelay: 0,
					zIndex: '',
					onShow: function(){
						if (!$(this).hasClass('validatebox-invalid')){
							if ($(this).tooltip('options').prompt){
								$(this).tooltip('update', $(this).tooltip('options').prompt);
							} else {
								$(this).tooltip('tip').hide();
							}
						} else {
							$(this).tooltip('tip').css({
								color: '#000',
								borderColor: '#CC9933',
								backgroundColor: '#FFFFCC'
							});
						}
					},
					onHide: function(){
						if (!$(this).tooltip('options').prompt){
							$(this).tooltip('destroy');
						}
					}
				}
			}).tooltip({
				position: 'right',
				content: function(){
					var opts = $(this).validatebox('options');
					return opts.prompt;
				},
				onShow: function(){
					$(this).tooltip('tip').css({
						color: '#000',
						borderColor: '#CC9933',
						backgroundColor: '#FFFFCC'
					});
				}
			});
		});
	</script>
</body>
</html>