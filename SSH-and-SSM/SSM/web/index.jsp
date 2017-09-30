<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>项目管理中心</title>
  <link rel="stylesheet"  href="<%=path%>/css/pintuer.css">
  <link rel="stylesheet"  href="<%=path%>/css/admin.css">
  <script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="<%=path%>/images/loginbg.jpg" class="radius-circle rotate-hover" height="50" alt="" /><span style="color:black;">项目管理中心</span></h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="javascript:void(0);" target="_blank"><span class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="javascript:void(0);" class="button button-little bg-blue"><span class="icon-wrench"></span> 清除缓存</a></div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>项目管理</h2>
  <ul style="display:block">
    <li><a href="<%=path%>/uc/user" target="right"><span class="icon-caret-right"></span>mybatis列表</a></li>
    <li><a href="<%=path%>/stu/list" target="right"><span class="icon-caret-right"></span>学生列表</a></li>
    <li><a href="<%=path%>/upload/up_page" target="right"><span class="icon-caret-right"></span>上传图片</a></li>
    <li><a href="<%=path%>/druid" target="right"><span class="icon-caret-right"></span>数据源监控</a></li>
    <li><a href="javascript:void(0);" target="right"><span class="icon-caret-right"></span>留言管理</a></li>
    <li><a href="javascript:void(0);" target="right"><span class="icon-caret-right"></span>栏目管理</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>栏目管理</h2>
  <ul>
    <li><a href="javascript:void(0);" target="right"><span class="icon-caret-right"></span>内容管理</a></li>
    <li><a href="javascript:void(0);" target="right"><span class="icon-caret-right"></span>添加内容</a></li>
    <li><a href="javascript:void(0);" target="right"><span class="icon-caret-right"></span>分类管理</a></li>
  </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;"><php>中文</php></span>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="<%=path%>/stu/head" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">

</div>
</body>
</html>