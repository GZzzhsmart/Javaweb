<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="jquery-easyui/themes/default/easyui.css" />
<link rel="stylesheet" href="jquery-easyui/themes/icon.css" />
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/main.js"></script>

</head>
<body class="easyui-layout">
		<div data-options="region:'north'" style="height:60px">
			<img src="images/3.jpg" class="logo" />
			<div id="wel">
				欢迎您：XXXX，安全退出
			</div>
		</div>
		<div data-options="region:'west',split:true" title="菜单" style="width:240px;">
			<div class="easyui-accordion menu" style="width:240px;">
				<div title="商品管理">
					<ul>
						<li><a href="javascript:;" onclick="addTab('所有商品','<%=path %>/products.jsp');">所有商品</a></li>
						<li><a href="javascript:;" onclick="addTab('系统设置','http://www.sina.com.cn');">系统设置</a></li>
						<li>系统公告</li>
						<li>系统监测</li>
					</ul>
				</div>
				<div title="用户管理">
					<ul>
						<li><a href="#">修改密码</a></li>
						<li>系统参数</li>
						<li>系统公告</li>
						<li>系统监测</li>
					</ul>
				</div>
				<div title="消息管理">
					<ul>
						<li><a href="#">修改密码</a></li>
						<li>系统参数</li>
						<li>系统公告</li>
						<li>
							<ul class="easyui-tree">
								<!-- 这是第一个一级菜单 -->
								<li>
									<span>多级目录1</span>
									<ul>
										<li><a href="javascript:;" onclick="addTab('修改密码','http://www.baidu.com');">目录1</a></li>
										<li>目录2</li>
										<li>目录3</li>
									</ul>
								</li>
								<!-- 这是第二个一级菜单 -->
								<li data-options="state:'closed'"><!-- 默认为关闭状态 -->
									<span>多级目录2</span>
									<ul>
										<li>目录1</li>
										<li>目录2</li>
										<li>目录3</li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center'">
			<div id="tabs" class="easyui-tabs" style="width:100%;height:100%;">
				<div title="主页" style="padding:10px">
					主页内容
				</div>
			</div>
		</div>
		<div data-options="region:'south',split:false" style="height:50px;">Copyright&copy;test 2016-2020</div>
</body>
</html>