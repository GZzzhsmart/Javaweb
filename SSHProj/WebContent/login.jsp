<%@page import="com.gs.pojo.Agency"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="/struts-tags" prefix="s" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
		String path = request.getContextPath();
	%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>经销商登录页面</title>
<meta name="keywords"
	content="" />
<meta name="description"
	content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<%=path %>/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-rtl.min.css" />
</head>
<%
	Agency agency = (Agency)request.getAttribute("agency");
%>
<script type="text/javascript">
	function check(){
		var agency_leader = document.getElementById("agency_leader");
		var agency_pwd = document.getElementById("agency_pwd");
		if(form1.agency_leader.value==""){
				alert("请输入用户名");
				form1.agency_leader.focus();
				return false;
		}
		if(form1.agency_pwd.value==""){
			alert("请输入登录密码");
			form1.agency_pwd.focus();
			return false;
		}
		return true;
	}
	function check1(){
		var agency_name = document.getElementById("agency_name");
		var agency_pwd = document.getElementById("agency_pwd");
		var agency_leader = document.getElementById("agency_leader");
		var agency_phone = document.getElementById("agency_phone");
		var agency_tel = document.getElementById("agency_tel");
		var agency_address = document.getElementById("agency_address");
		var agency_logo = document.getElementById("agency_logo");
		var agency_intro = document.getElementById("agency_intro");
		if(form2.agency_leader.value==""){
			alert("请输入用户名");
			form2.agency_leader.focus();
			return false;
		}
		if(form2.agency_pwd.value==""){
			alert("请输入登录密码");
			form2.agency_pwd.focus();
			return false;
		}
		if(form2.agency_name.value==""){
			alert("请输入经销商名称");
			form2.agency_name.focus();
			return false;
		}
		if(form2.agency_phone.value==""){
			alert("请输入电话号码");
			form2.agency_phone.focus();
			return false;
		}
		if(form2.agency_tel.value==""){
			alert("请输入固定电话");
			form2.agency_tel.focus();
			return false;
		}
		if(form2.agency_address.value==""){
			alert("请输入地址");
			form2.agency_address.focus();
			return false;
		}
		if(form2.agency_intro.value==""){
			alert("请输入公司简介");
			form2.agency_intro.focus();
			return false;
		}
		return true;
	}
</script>
<body class="login-layout" background="<%=path %>/images/loginbg.jpg">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">经销商</span> <span
									class="white">登录</span>
							</h1>
							<h4 class="blue">&copy;房地产营销平台</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<center><i class="icon-coffee green"></i>登录</center>
										</h4>
										<div class="space-6"></div>
										<form name="form1" id="form1"  action="<%=path %>/test/login" method="post" onsubmit="return check();">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_leader" name="agency.agency_leader" type="text" class="form-control" 
														placeholder="用户名" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_pwd" name="agency.agency_pwd" type="密码" class="form-control"
														placeholder="密码" /> <i class="icon-lock"></i>
												</span>
												</label>
												<div class="space"></div>
												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl">记住密码</span>
													</label>

													<button class="width-35 pull-right btn btn-sm btn-primary">
														<li>登录</li>
													</button>
												</div>
												<div class="space-4"></div>
											</fieldset>
										</form>
										<div class="social-or-login center">
											<span class="bigger-110">其他方式登录</span>
										</div>
										<div class="social-login center">
											<a class="btn btn-primary"> <i class="icon-facebook"></i>
											</a> <a class="btn btn-info"> <i class="icon-twitter"></i>
											</a> <a class="btn btn-danger"> <i class="icon-google-plus"></i>
											</a>
										</div>
									</div>
									<!-- /widget-main -->
									<div class="toolbar clearfix">
										<div>
											<a href="#" onclick="show_box('forgot-box'); return false;"
												class="forgot-password-link"> <i class="icon-arrow-left"></i>
												忘记密码
											</a>
										</div>

										<div>
											<a href="#" onclick="show_box('signup-box'); return false;"
												class="user-signup-link">立即注册 <i
												class="icon-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="icon-key"></i>重置密码
										</h4>

										<div class="space-6"></div>
										<p>请输入你的邮箱并接收消息</p>

										<form action="#" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <s:textfield
														name="agency.agency_email" type="text" class="form-control" placeholder="邮箱" />
														<i class="icon-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="icon-lightbulb"></i>发送
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /widget-main -->

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link">返回登录界面 <i
											class="icon-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										
										<h4 class="header green lighter bigger">
											<center><i class="icon-group blue"></i>经销商入驻</center>
										</h4>
										
										<div class="space-6"></div>
										<p>请输入你的基本信息：</p>

										<form name="form2" id="form2" action="<%=path %>/test/add" method="post"  onsubmit="return check1();">
											<input type="hidden" name="agency_id" value="${agency.agency_id }">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														name="agency.agency_name" id="agency_name" type="text" class="form-control" placeholder="经销商名称" />
														<i class="icon-envelope"></i>
												</span>
												</label>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_email" name="agency.agency_email" type="text" class="form-control" placeholder="邮箱" />
														<i class="icon-envelope"></i>
												</span>
												</label> 
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_pwd" name="agency.agency_pwd" type="password" class="form-control"
														placeholder="密码" /> <i class="icon-lock"></i>
												</span>
												</label> 
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_pwd" name="agency.agency_pwd" type="password" class="form-control"
														placeholder="确认密码" /> <i class="icon-retweet"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_leader" name="agency.agency_leader" type="text" class="form-control" placeholder="姓名" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_phone" name="agency.agency_phone" type="text" class="form-control" placeholder="手机号码" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_tel" name="agency.agency_tel" type="text" class="form-control" placeholder="固定电话" />
														<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														id="agency_address" name="agency.agency_address" type="text" class="form-control" placeholder="地址" />
														<i class="icon-user"></i>
												</span>
												<!-- 
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														" name="agency_logo" type="file" label="请选择文件"/>
												</span>
												 -->
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right">
													<textarea  id="agency_intro" name="agency.agency_intro" placeholder="简介" style="width:305px;height:100px;"></textarea> 
												</span>
												
												</label> <label class="block"> <input type="checkbox"
													class="ace" /> <span class="lbl">我接受<a
														href="#">用户条款</a>
												</span>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="icon-refresh"></i>重置
													</button>
				
													<button class="width-65 pull-right btn btn-sm btn-success">
														<i class="icon-arrow-right icon-on-right">注册</i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> <i class="icon-arrow-left"></i>
											返回登录界面
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
		window.jQuery || document.write("<script src='<%=path%>/assets/js/jquery-2.0.3.min.js'>" + "<"+"/script>");
	</script>

	<script type="text/javascript">
		if ("ontouchend" in document)
			document.write("<script src='<%=path%>/assets/js/jquery.mobile.custom.min.js'>" + "<"+"/script>");
	</script>

	<script type="text/javascript">
		function show_box(id) {
			jQuery('.widget-box.visible').removeClass('visible');
			jQuery('#' + id).addClass('visible');
		}
	</script>
</body>
</html>
