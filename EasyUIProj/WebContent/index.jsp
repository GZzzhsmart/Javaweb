<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>EasyuiDemo</title>
	<link rel="stylesheet" href="<%=path %>/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="<%=path %>/easyui/themes/icon.css" />
	<link rel="stylesheet" href="<%=path %>/css/main.css" />
</head>
<body class="easyui-layout">
	<div id="top" data-options="region:'north'">
		<div id="logo"><img src="<%=path %>/images/girl.jpg" /></div>
		<div id="wel_msg">欢迎您：1729340612@qq.com&nbsp;&nbsp;
			<a href="javascript:void(0);" onclick="logout();">安全退出</a>
		</div>
		<p class="clear"></p>
	</div>
	
	<div data-options="region:'south',split:true" style="height: 50px;">版权信息</div>
	<div data-options="region:'west',split:true" title="主菜单" style="width: 250px;">
		<div class="easyui-accordion">
			<div title="商品管理" data-options="iconCls:'icon-ok'"
				style="padding: 10px;">
				<ul>
					<li><a href="javascript:void(0);" src="<%=path%>/products.jsp"
						class="site-navi-tab">所有商品</a></li>
					<li><a href="javascript:void(0);" src="<%=path%>/product_type.jsp"
						class="site-navi-tab">商品类型</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="tabs" class="easyui-tabs" data-options="region:'center'">
		<div title="主页" style="padding: 10px">
			<div class="easyui-panel my-panel" title="系统状态">
				系统状态
			</div>
		</div>
	</div>
	<div id="mm" class="easyui-menu">
	    <div id="mm-tabupdate">刷新</div>
	    <div class="menu-sep"></div>
	    <div id="mm-tabclose">关闭</div>
	    <div id="mm-tabcloseother">关闭其他</div>
	    <div id="mm-tabcloseall">关闭全部</div>
	</div>
</body>
<script src="<%=path %>/js/jquery.min.js"></script>
<script src="<%=path %>/easyui/jquery.easyui.min.js"></script>
<script src="<%=path %>/easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="<%=path %>/js/main.js"></script>
</html>