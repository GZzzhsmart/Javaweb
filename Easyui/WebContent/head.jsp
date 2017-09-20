<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Easyui小例子</title>
	 <link href="easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="easyui/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="js/Default.js" type="text/javascript"></script>
    <style type="text/css">
        .easyui-accordion ul
        {
            list-style-type: none;
            margin: 0px;
            padding: 10px;
        }
        .easyui-accordion ul li
        {
            padding: 0px;
        }
        .easyui-accordion ul li a
        {
            line-height: 24px;
        }
        .easyui-accordion ul li div
        {
            margin: 2px 0px;
            padding-left: 10px;
            padding-top: 2px;
        }
        .easyui-accordion ul li div.hover
        {
            border: 1px dashed #99BBE8;
            background: #E0ECFF;
            cursor: pointer;
        }
        .easyui-accordion ul li div.hover a
        {
            color: #416AA3;
        }
        .easyui-accordion ul li div.selected
        {
            border: 1px solid #99BBE8;
            background: #E0ECFF;
            cursor: default;
        }
        .easyui-accordion ul li div.selected a
        {
            color: #416AA3;
            font-weight: bold;
        }
    </style>
</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no">
    <noscript>
        <div style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px;
            width: 100%; background: white; text-align: center;">
            <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
        </div>
    </noscript>
    <div region="north" split="true" style="overflow: hidden; height: 30px; background: #D2E0F2 repeat-x center 50%;
        line-height: 20px; color: #fff;">
        欢迎使用
    </div>
    <div region="south" style="height: 20px; background: #D2E0F2;">
        <div style="text-align: center; font-weight: bold">
            EntWebSite ver 1.0</div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width: 180px;overflow:hidden;" icon="icon-redo">
        <div id="menu" class="easyui-accordion" fit="true" border="false">
            <div title="系统管理" style="overflow:auto; padding: 10px;" icon="icon-edit">
                <div title="网站设置">
                    <ul>
                        <li>
                            <div>
                                <a target="mainFrame" href="products.jsp">网站设置</a></div>
                        </li>
                    </ul>
                </div>
            </div>
            <div title="产品管理" style="padding: 10px;" icon="icon-edit">
                <div title="产品管理">
                    <ul>
                        <li>
                            <div>
                                <a target="mainFrame" href="index.jsp">产品管理</a></div>
                        </li>
                    </ul>
                </div>
            </div>
            <div title="关于" icon="icon-help">
                <h4>
                    EntWebSite Ver 1.0</h4>
            </div>
        </div>
    </div>
    <div region="center" id="mainPanle" style="background: #eee;overflow:hidden;">
        <div id="tabs" class="easyui-tabs" fit="true" border="false">
            <div title="主页" style="padding: 20px;" id="home">
                <h1>
                    Welcome...</h1>
            </div>
        </div>
    </div>
</body>

</html>