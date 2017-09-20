<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>基础布局</title>
	<link rel="stylesheet" href="<%=path %>/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="<%=path %>/easyui/themes/icon.css" />
	<link rel="stylesheet" href="<%=path %>/css/site.css" />
</head>
<body class="easyui-layout">
		<div data-options="region:'north'" style="height:50px">logo部分，欢迎信息，安全退出</div>
		<div data-options="region:'south',split:true" style="height:50px;">版权信息</div>
		<div data-options="region:'west',split:true" title="主菜单" style="width:250px;">
			<div class="easyui-accordion">
				<div title="用户管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<ul>
						<li>
							<a href="javascript:void(0);" src="<%=path %>/products.jsp" class="site-navi-tab">所有用户</a>
						</li>
						<li>
							<a href="javascript:void(0);" src="http://www.baidu.com" class="site-navi-tab">用户审核</a>
						</li>
					</ul>
				</div>
				<div title="商品管理" data-options="iconCls:'icon-help'" style="padding:10px;">
					<ul>
						<li><a href="javascript:void(0);" src="<%=path %>/page.html" class="site-navi-tab">所有商品</a></li>
						<li><a href="javascript:void(0);" src="http://www.qq.com" class="site-navi-tab">商品类型</a></li>
					</ul>
				</div>
				<div title="系统管理" data-options="iconCls:'icon-search'" style="padding:10px;">
					<ul>
						<li><a href="javascript:void(0);" src="<%=path %>/page.html" class="site-navi-tab">所有管理员</a></li>
						<li><a href="javascript:void(0);" src="<%=path %>/product.jsp" class="site-navi-tab">所有用户</a></li>
						<li><a href="javascript:void(0);" src="<%=path %>/page.html" class="site-navi-tab">密码修改</a></li>
					</ul>
				</div>
				<div title="资源浏览" data-options="iconCls:'icon-ok'" style="padding:10px;">
					<ul class="easyui-tree" data-options="animate:true,
					onContextMenu:function(e, node) {
						e.preventDefault();
						$(this).tree('select',node.target);
						$('#tree-menu').menu('show',{
						left: e.pageX,
						top: e.pageY
					});}">
						<li>
							<span>员工</span>
							<ul>
								<li data-options="state:'closed'">
									<span>老板</span>
									<ul>
										<li>
											<span>股东1</span>
										</li>
										<li>
											<span>股东2</span>
										</li>
										<li>
											<span>股东3</span>
										</li>
									</ul>
								</li>
								<li>
									<span>会计</span>
									<ul>
										<li>美女1</li>
									</ul>
								</li>
							</ul>
						</li>
						<li>
							<span>部门</span>
							<ul>
								<li>
									<span>总经办</span>
								</li>
								<li>
									<span>财务部</span>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="tabs" class="easyui-tabs" data-options="region:'center'">
			<div title="主页" style="padding: 10px">
				<div class="easyui-panel my-panel" title="系统状态">
					Tomcat:8.5
					JDK:1.8
					MySQL:5.7
				</div>
				<div class="easyui-panel my-panel" title="待办任务">
					<p>任务1</p>
					<p>任务2</p>
					<div>
						<a href="javascript:void(0);" onclick="executeTask();" class="easyui-linkbutton" data-options="plain:true">执行任务</a>
						<a href="#" class="easyui-menubutton" data-options="menu:'#mm1',iconCls:'icon-search'">任务详情</a>
					</div>
				</div>
				<div class="easyui-panel my-panel" title="数据报表">
					<p>报表1</p>
					<p>报表2</p>
				</div>
			</div>
		</div>
		<!-- 树的右键菜单  -->
		<div id="tree-menu" class="easyui-menu" style="width:120px;">
			<div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
			<div onclick="removeit()" data-options="iconCls:'icon-remove'">Remove</div>
			<div class="menu-sep"></div>
			<div onclick="expand()">Expand</div>
			<div onclick="collapse()">Collapse</div>
		</div>
		<!-- 选项卡的右键菜单  -->
		<div id="tab-menu">
			<div onclick="append()" data-options="iconCls:'icon-add'">Append</div>
			<div onclick="removeit()" data-options="iconCls:'icon-remove'">Remove</div>
			<div class="menu-sep"></div>
			<div onclick="expand()">Expand</div>
			<div onclick="collapse()">Collapse</div>
		</div>
		<!-- 选项卡右键菜单  -->
		<div id="mm" class="easyui-menu">
		    <div id="mm-tabupdate">刷新</div>
		    <div class="menu-sep"></div>
		    <div id="mm-tabclose">关闭</div>
		    <div id="mm-tabcloseother">关闭其他</div>
		    <div id="mm-tabcloseall">关闭全部</div>
		</div>
		<div id="mm1" class="easyui-menu">
		    <div id="mm-tabupdate" onclick="viewTask();">查看任务</div>
		    <div class="menu-sep"></div>
		    <div id="mm-tabclose" onclick="delTask();">删除任务</div>
		    <div id="mm-tabcloseother">重新指派</div>
		</div>
		
		<!-- 对话框窗口 -->
		<div id="dlg" class="easyui-dialog" title="执行任务" style="width:400px;height:200px;padding:10px"
			data-options="
				closed:true,
				iconCls: 'icon-save',
				toolbar: [{
					text:'添加',
					iconCls:'icon-add',
					handler:function(){
						$.messager.alert('添加');
					}
				},'-',{
					text:'保存',
					iconCls:'icon-save',
					handler:function(){
						$.messager.alert('保存');
					}
				}],
				buttons: [{
					text:'确认执行',
					iconCls:'icon-ok',
					handler:function(){
						$('#dlg').dialog('close');
					}
				},{
					text:'取消执行',
					handler:function(){
						$('#dlg').dialog('close');
					}
				}]
			">
			
			<div id="taskWin" class="easyui-window" title="任务详情" data-options="closed:true" style="width:400px;height:200px;">
				<div class="easyui-panel">任务名称：埃里克森</div>
				<a class="easyui-linkbutton" href="javascript:void(0);" onclick="closeTaskDetail();">关闭</a>
			</div>
		The dialog content.
	</div>
</body>
	<script src="<%=path %>/js/jquery.min.js"></script>
	<script src="<%=path %>/easyui/jquery.easyui.min.js"></script>
	<script src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="<%=path %>/js/main.js"></script>
	<script src="<%=path %>/js/home.js"></script>
</html>