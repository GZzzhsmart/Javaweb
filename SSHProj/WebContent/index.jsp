<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
		String path = request.getContextPath();
	%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>经销商管理中心</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="<%=path %>/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>/assets/css/font-awesome.min.css" />



<link rel="stylesheet" href="<%=path %>/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="<%=path %>/assets/css/ace-skins.min.css" />



<script src="<%=path %>/assets/js/ace-extra.min.js"></script>


</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> 经销商管理中心
				</small>
				</a>
			</div>

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="grey"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i class="icon-tasks"></i> <span
							class="badge badge-grey">4</span>
					</a>

						<ul
							class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-ok"></i> 还有4个任务完成
							</li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">软件更新</span> <span class="pull-right">65%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 65%" class="progress-bar "></div>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">硬件更新</span> <span class="pull-right">35%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 35%"
											class="progress-bar progress-bar-danger"></div>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">单元测试</span> <span class="pull-right">15%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 15%"
											class="progress-bar progress-bar-warning"></div>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">错误修复</span> <span class="pull-right">90%</span>
									</div>

									<div class="progress progress-mini progress-striped active">
										<div style="width: 90%"
											class="progress-bar progress-bar-success"></div>
									</div>
							</a></li>

							<li><a href="#"> 查看任务详情 <i class="icon-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="purple"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="icon-bell-alt icon-animated-bell"></i> <span
							class="badge badge-important">8</span>
					</a>

						<ul
							class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-warning-sign"></i>
								8条通知</li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-pink icon-comment"></i> 新闻评论
										</span> <span class="pull-right badge badge-info">+12</span>
									</div>
							</a></li>

							<li><a href="#"> <i
									class="btn btn-xs btn-primary icon-user"></i> 切换为编辑登录..
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
											新订单
										</span> <span class="pull-right badge badge-success">+8</span>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-info icon-twitter"></i> 粉丝
										</span> <span class="pull-right badge badge-info">+11</span>
									</div>
							</a></li>

							<li><a href="#"> 查看所有通知 <i class="icon-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="green"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="icon-envelope icon-animated-vertical"></i> <span
							class="badge badge-success">5</span>
					</a>

						<ul
							class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-envelope-alt"></i>
								5条消息</li>

							<li><a href="#"> <img src="assets/avatars/avatar.png"
									class="msg-photo" alt="Alex's Avatar" /> <span
									class="msg-body"> <span class="msg-title"> <span
											class="blue">Alex:</span> 不知道写啥 ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>1分钟以前</span>
									</span>
								</span>
							</a></li>

							<li><a href="#"> <img src="assets/avatars/avatar3.png"
									class="msg-photo" alt="Susan's Avatar" /> <span
									class="msg-body"> <span class="msg-title"> <span
											class="blue">Susan:</span> 不知道翻译...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>20分钟以前</span>
									</span>
								</span>
							</a></li>

							<li><a href="#"> <img src="assets/avatars/avatar4.png"
									class="msg-photo" alt="Bob's Avatar" /> <span class="msg-body">
										<span class="msg-title"> <span class="blue">Bob:</span>
											到底是不是英文 ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>下午3:15</span>
									</span>
								</span>
							</a></li>

							<li><a href="inbox.html"> 查看所有消息 <i
									class="icon-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="<%=path %>/assets/avatars/user.jpg" alt="Jason's Photo" /> <span
							class="user-info"> <small>欢迎光临,</small> Jason
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="icon-cog"></i> 设置
							</a></li>

							<li><a href="#"> <i class="icon-user"></i> 个人资料
							</a></li>

							<li class="divider"></li>

							<li><a href="#"> <i class="icon-off"></i> 退出
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active"><a href="index.html"> <i
							class="icon-dashboard"></i> <span class="menu-text">
								基础信息管理 </span>
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-desktop"></i> <span class="menu-text">员工管理</span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="elements.html"> <i
									class="icon-double-angle-right"></i> 员工添加
							</a></li>

							<li><a href="buttons.html"> <i
									class="icon-double-angle-right"></i> 员工修改
							</a></li>

							<!--<li>
									<a href="treeview.html">
										<i class="icon-double-angle-right"></i>
										树菜单
									</a>
								</li>

								<li>
									<a href="jquery-ui.html">
										<i class="icon-double-angle-right"></i>
										jQuery UI
									</a>
								</li>

								<li>
									<a href="nestable-list.html">
										<i class="icon-double-angle-right"></i>
										可拖拽列表
									</a>
								</li>

								<li>
									<a href="#" class="dropdown-toggle">
										<i class="icon-double-angle-right"></i>

										三级菜单
										<b class="arrow icon-angle-down"></b>
									</a>

									<ul class="submenu">
										<li>
											<a href="#">
												<i class="icon-leaf"></i>
												第一级
											</a>
										</li>

										<li>
											<a href="#" class="dropdown-toggle">
												<i class="icon-pencil"></i>

												第四级
												<b class="arrow icon-angle-down"></b>
											</a>

											<ul class="submenu">
												<li>
													<a href="#">
														<i class="icon-plus"></i>
														添加产品
													</a>
												</li>

												<li>
													<a href="#">
														<i class="icon-eye-open"></i>
														查看商品
													</a>
												</li>
											</ul>
										</li>
									</ul>
								</li>-->
						</ul></li>
					<li><a href="typography.html"> <i class="icon-text-width"></i>
							<span class="menu-text"> 绩效管理 </span>


					</a></li>
					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-list"></i> <span class="menu-text"> 楼盘管理 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="tables.html"> <i
									class="icon-double-angle-right"></i> 楼盘添加
							</a></li>

							<li><a href="jqgrid.html"> <i
									class="icon-double-angle-right"></i> 楼盘修改
							</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-edit"></i> <span class="menu-text"> 楼栋管理</span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="form-elements.html"> <i
									class="icon-double-angle-right"></i> 户型管理
							</a></li>

							<li><a href="form-wizard.html"> <i
									class="icon-double-angle-right"></i> 楼栋添加
							</a></li>

							<li><a href="wysiwyg.html"> <i
									class="icon-double-angle-right"></i> 楼栋修改
							</a></li>

							<!--  	<li>
									<a href="dropzone.html">
										<i class="icon-double-angle-right"></i>
										文件上传
									</a>
								</li>-->
						</ul></li>

					<li><a href="widgets.html"> <i class="icon-list-alt"></i>
							<span class="menu-text"> 活动管理 </span>
					</a></li>

					<li><a href="calendar.html"> <i class="icon-calendar"></i>

							<span class="menu-text"> 购房预约管理 <span
								class="badge badge-transparent tooltip-error"
								title="2&nbsp;Important&nbsp;Events"> <i
									class="icon-warning-sign red bigger-130"></i>
							</span>
						</span>
					</a></li>

					<li><a href="gallery.html"> <i class="icon-picture"></i> <span
							class="menu-text"> 销售管理 </span>
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-tag"></i> <span class="menu-text"> 客户管理</span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="profile.html"> <i
									class="icon-double-angle-right"></i> 留言管理
							</a></li>

							<li><a href="inbox.html"> <i
									class="icon-double-angle-right"></i> 评价管理
							</a></li>

							<li><a href="pricing.html"> <i
									class="icon-double-angle-right"></i> 售价单
							</a></li>

							<li><a href="invoice.html"> <i
									class="icon-double-angle-right"></i> 购物车
							</a></li>

							<li><a href="timeline.html"> <i
									class="icon-double-angle-right"></i> 时间轴
							</a></li>

							<li><a href="login.html"> <i
									class="icon-double-angle-right"></i> 登录 &amp; 注册
							</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-file-alt"></i> <span class="menu-text"> 报表统计 <span
								class="badge badge-primary ">5</span>
						</span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="faq.html"> <i
									class="icon-double-angle-right"></i> 销售统计
							</a></li>

							<li><a href="error-404.html"> <i
									class="icon-double-angle-right"></i> 房屋统计
							</a></li>

							<li><a href="error-500.html"> <i
									class="icon-double-angle-right"></i> 浏览统计
							</a></li>

							<li><a href="grid.html"> <i
									class="icon-double-angle-right"></i> 价格统计
							</a></li>

							<li><a href="blank.html"> <i
									class="icon-double-angle-right"></i> 空白页面
							</a></li>
						</ul></li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">首页</a></li>
						<li class="active">控制台</li>
					</ul>
					<!-- .breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Search ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="icon-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- #nav-search -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							控制台 <small> <i class="icon-double-angle-right"></i> 查看
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="clearfix">
								<div class="pull-left alert alert-success no-margin">
									<button type="button" class="close" data-dismiss="alert">
										<i class="icon-remove"></i>
									</button>

									<i class="icon-umbrella bigger-120 blue"></i> Click on the
									image below or on profile fields to edit them ...
								</div>

								<div class="pull-right">
									<span class="green middle bolder">Choose profile: &nbsp;</span>

									<div class="btn-toolbar inline middle no-margin">
										<div data-toggle="buttons" class="btn-group no-margin">
											<label class="btn btn-sm btn-yellow active"> <span
												class="bigger-110">1</span> <input type="radio" value="1" />
											</label> <label class="btn btn-sm btn-yellow"> <span
												class="bigger-110">2</span> <input type="radio" value="2" />
											</label> <label class="btn btn-sm btn-yellow"> <span
												class="bigger-110">3</span> <input type="radio" value="3" />
											</label>
										</div>
									</div>
								</div>
							</div>

							<div class="hr dotted"></div>

							<div>
								<div id="user-profile-1" class="user-profile row">
									<div class="col-xs-12 col-sm-3 center">
										<div>
											<span class="profile-picture"> <img id="avatar"
												class="editable img-responsive" alt="Alex's Avatar"
												src="assets/avatars/profile-pic.jpg" />
											</span>

											<div class="space-4"></div>

											<div
												class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
												<div class="inline position-relative">
													<a href="#" class="user-title-label dropdown-toggle"
														data-toggle="dropdown"> <i
														class="icon-circle light-green middle"></i> &nbsp; <span
														class="white">Alex M. Doe</span>
													</a>

													<ul
														class="align-left dropdown-menu dropdown-caret dropdown-lighter">
														<li class="dropdown-header">Change Status</li>

														<li><a href="#"> <i class="icon-circle green"></i>
																&nbsp; <span class="green">Available</span>
														</a></li>

														<li><a href="#"> <i class="icon-circle red"></i>
																&nbsp; <span class="red">Busy</span>
														</a></li>

														<li><a href="#"> <i class="icon-circle grey"></i>
																&nbsp; <span class="grey">Invisible</span>
														</a></li>
													</ul>
												</div>
											</div>
										</div>

										<div class="space-6"></div>

										<div class="profile-contact-info">
											<div class="profile-contact-links align-left">
												<a class="btn btn-link" href="#"> <i
													class="icon-plus-sign bigger-120 green"></i> Add as a
													friend
												</a> <a class="btn btn-link" href="#"> <i
													class="icon-envelope bigger-120 pink"></i> Send a message
												</a> <a class="btn btn-link" href="#"> <i
													class="icon-globe bigger-125 blue"></i> www.alexdoe.com
												</a>
											</div>

											<div class="space-6"></div>

											<div class="profile-social-links center">
												<a href="#" class="tooltip-info" title=""
													data-original-title="Visit my Facebook"> <i
													class="middle icon-facebook-sign icon-2x blue"></i>
												</a> <a href="#" class="tooltip-info" title=""
													data-original-title="Visit my Twitter"> <i
													class="middle icon-twitter-sign icon-2x light-blue"></i>
												</a> <a href="#" class="tooltip-error" title=""
													data-original-title="Visit my Pinterest"> <i
													class="middle icon-pinterest-sign icon-2x red"></i>
												</a>
											</div>
										</div>

										<div class="hr hr12 dotted"></div>

										<div class="clearfix">
											<div class="grid2">
												<span class="bigger-175 blue">25</span> <br /> Followers
											</div>

											<div class="grid2">
												<span class="bigger-175 blue">12</span> <br /> Following
											</div>
										</div>

										<div class="hr hr16 dotted"></div>
									</div>

									<div class="col-xs-12 col-sm-9">
										<div class="center">
											<span class="btn btn-app btn-sm btn-light no-hover"> <span
												class="line-height-1 bigger-170 blue"> 1,411 </span> <br />
												<span class="line-height-1 smaller-90"> Views </span>
											</span> <span class="btn btn-app btn-sm btn-yellow no-hover">
												<span class="line-height-1 bigger-170"> 32 </span> <br /> <span
												class="line-height-1 smaller-90"> Followers </span>
											</span> <span class="btn btn-app btn-sm btn-pink no-hover"> <span
												class="line-height-1 bigger-170"> 4 </span> <br /> <span
												class="line-height-1 smaller-90"> Projects </span>
											</span> <span class="btn btn-app btn-sm btn-grey no-hover"> <span
												class="line-height-1 bigger-170"> 23 </span> <br /> <span
												class="line-height-1 smaller-90"> Reviews </span>
											</span> <span class="btn btn-app btn-sm btn-success no-hover">
												<span class="line-height-1 bigger-170"> 7 </span> <br /> <span
												class="line-height-1 smaller-90"> Albums </span>
											</span> <span class="btn btn-app btn-sm btn-primary no-hover">
												<span class="line-height-1 bigger-170"> 55 </span> <br /> <span
												class="line-height-1 smaller-90"> Contacts </span>
											</span>
										</div>

										<div class="space-12"></div>

										<div class="profile-user-info profile-user-info-striped">
											<div class="profile-info-row">
												<div class="profile-info-name">Username</div>

												<div class="profile-info-value">
													<span class="editable" id="username">alexdoe</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Location</div>

												<div class="profile-info-value">
													<i class="icon-map-marker light-orange bigger-110"></i> <span
														class="editable" id="country">Netherlands</span> <span
														class="editable" id="city">Amsterdam</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Age</div>

												<div class="profile-info-value">
													<span class="editable" id="age">38</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Joined</div>

												<div class="profile-info-value">
													<span class="editable" id="signup">20/06/2010</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Last Online</div>

												<div class="profile-info-value">
													<span class="editable" id="login">3 hours ago</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">About Me</div>

												<div class="profile-info-value">
													<span class="editable" id="about">Editable as
														WYSIWYG</span>
												</div>
											</div>
										</div>

										<div class="space-20"></div>

										<div class="widget-box transparent">
											<div class="widget-header widget-header-small">
												<h4 class="blue smaller">
													<i class="icon-rss orange"></i> Recent Activities
												</h4>

												<div class="widget-toolbar action-buttons">
													<a href="#" data-action="reload"> <i
														class="icon-refresh blue"></i>
													</a> &nbsp; <a href="#" class="pink"> <i class="icon-trash"></i>
													</a>
												</div>
											</div>

											<div class="widget-body">
												<div class="widget-main padding-8">
													<div id="profile-feed-1" class="profile-feed">
														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="Alex Doe's avatar"
																	src="assets/avatars/avatar5.png" /> <a class="user"
																	href="#"> Alex Doe </a> changed his profile photo. <a
																	href="#">Take a look</a>

																<div class="time">
																	<i class="icon-time bigger-110"></i> an hour ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="Susan Smith's avatar"
																	src="assets/avatars/avatar1.png" /> <a class="user"
																	href="#"> Susan Smith </a> is now friends with Alex
																Doe.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 2 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-ok btn-success no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> joined <a
																	href="#">Country Music</a> group.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 5 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-picture btn-info no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> uploaded a new
																photo. <a href="#">Take a look</a>

																<div class="time">
																	<i class="icon-time bigger-110"></i> 5 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="David Palms's avatar"
																	src="assets/avatars/avatar4.png" /> <a class="user"
																	href="#"> David Palms </a> left a comment on Alex's
																wall.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 8 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-edit btn-pink no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> published a new
																blog post. <a href="#">Read now</a>

																<div class="time">
																	<i class="icon-time bigger-110"></i> 11 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="Alex Doe's avatar"
																	src="assets/avatars/avatar5.png" /> <a class="user"
																	href="#"> Alex Doe </a> upgraded his skills.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 12 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-key btn-info no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> logged in.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 12 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-off btn-inverse no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> logged out.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 16 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-key btn-info no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> logged in.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 16 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="hr hr2 hr-double"></div>

										<div class="space-6"></div>

										<div class="center">
											<a href="#" class="btn btn-sm btn-primary"> <i
												class="icon-rss bigger-150 middle"></i> <span
												class="bigger-110">View more activities</span> <i
												class="icon-on-right icon-arrow-right"></i>
											</a>
										</div>
									</div>
								</div>
							</div>

							<div class="hide">
								<div id="user-profile-2" class="user-profile">
									<div class="tabbable">
										<ul class="nav nav-tabs padding-18">
											<li class="active"><a data-toggle="tab" href="#home">
													<i class="green icon-user bigger-120"></i> Profile
											</a></li>

											<li><a data-toggle="tab" href="#feed"> <i
													class="orange icon-rss bigger-120"></i> Activity Feed
											</a></li>

											<li><a data-toggle="tab" href="#friends"> <i
													class="blue icon-group bigger-120"></i> Friends
											</a></li>

											<li><a data-toggle="tab" href="#pictures"> <i
													class="pink icon-picture bigger-120"></i> Pictures
											</a></li>
										</ul>

										<div class="tab-content no-border padding-24">
											<div id="home" class="tab-pane in active">
												<div class="row">
													<div class="col-xs-12 col-sm-3 center">
														<span class="profile-picture"> <img
															class="editable img-responsive" alt="Alex's Avatar"
															id="avatar2" src="assets/avatars/profile-pic.jpg" />
														</span>

														<div class="space space-4"></div>

														<a href="#" class="btn btn-sm btn-block btn-success">
															<i class="icon-plus-sign bigger-120"></i> <span
															class="bigger-110">Add as a friend</span>
														</a> <a href="#" class="btn btn-sm btn-block btn-primary">
															<i class="icon-envelope-alt bigger-110"></i> <span
															class="bigger-110">Send a message</span>
														</a>
													</div>
													<!-- /span -->

													<div class="col-xs-12 col-sm-9">
														<h4 class="blue">
															<span class="middle">Alex M. Doe</span> <span
																class="label label-purple arrowed-in-right"> <i
																class="icon-circle smaller-80 align-middle"></i> online
															</span>
														</h4>

														<div class="profile-user-info">
															<div class="profile-info-row">
																<div class="profile-info-name">Username</div>

																<div class="profile-info-value">
																	<span>alexdoe</span>
																</div>
															</div>

															<div class="profile-info-row">
																<div class="profile-info-name">Location</div>

																<div class="profile-info-value">
																	<i class="icon-map-marker light-orange bigger-110"></i>
																	<span>Netherlands</span> <span>Amsterdam</span>
																</div>
															</div>

															<div class="profile-info-row">
																<div class="profile-info-name">Age</div>

																<div class="profile-info-value">
																	<span>38</span>
																</div>
															</div>

															<div class="profile-info-row">
																<div class="profile-info-name">Joined</div>

																<div class="profile-info-value">
																	<span>20/06/2010</span>
																</div>
															</div>

															<div class="profile-info-row">
																<div class="profile-info-name">Last Online</div>

																<div class="profile-info-value">
																	<span>3 hours ago</span>
																</div>
															</div>
														</div>

														<div class="hr hr-8 dotted"></div>

														<div class="profile-user-info">
															<div class="profile-info-row">
																<div class="profile-info-name">Website</div>

																<div class="profile-info-value">
																	<a href="#" target="_blank">www.alexdoe.com</a>
																</div>
															</div>

															<div class="profile-info-row">
																<div class="profile-info-name">
																	<i class="middle icon-facebook-sign bigger-150 blue"></i>
																</div>

																<div class="profile-info-value">
																	<a href="#">Find me on Facebook</a>
																</div>
															</div>

															<div class="profile-info-row">
																<div class="profile-info-name">
																	<i
																		class="middle icon-twitter-sign bigger-150 light-blue"></i>
																</div>

																<div class="profile-info-value">
																	<a href="#">Follow me on Twitter</a>
																</div>
															</div>
														</div>
													</div>
													<!-- /span -->
												</div>
												<!-- /row-fluid -->

												<div class="space-20"></div>

												<div class="row">
													<div class="col-xs-12 col-sm-6">
														<div class="widget-box transparent">
															<div class="widget-header widget-header-small">
																<h4 class="smaller">
																	<i class="icon-check bigger-110"></i> Little About Me
																</h4>
															</div>

															<div class="widget-body">
																<div class="widget-main">
																	<p>My job is mostly lorem ipsuming and dolor sit
																		ameting as long as consectetur adipiscing elit.</p>
																	<p>Sometimes quisque commodo massa gets in the way
																		and sed ipsum porttitor facilisis.</p>
																	<p>The best thing about my job is that vestibulum
																		id ligula porta felis euismod and nullam quis risus
																		eget urna mollis ornare.</p>
																	<p>Thanks for visiting my profile.</p>
																</div>
															</div>
														</div>
													</div>

													<div class="col-xs-12 col-sm-6">
														<div class="widget-box transparent">
															<div
																class="widget-header widget-header-small header-color-blue2">
																<h4 class="smaller">
																	<i class="icon-lightbulb bigger-120"></i> My Skills
																</h4>
															</div>

															<div class="widget-body">
																<div class="widget-main padding-16">
																	<div class="clearfix">
																		<div class="grid3 center">
																			<div class="easy-pie-chart percentage"
																				data-percent="45" data-color="#CA5952">
																				<span class="percent">45</span>%
																			</div>

																			<div class="space-2"></div>
																			Graphic Design
																		</div>

																		<div class="grid3 center">
																			<div class="center easy-pie-chart percentage"
																				data-percent="90" data-color="#59A84B">
																				<span class="percent">90</span>%
																			</div>

																			<div class="space-2"></div>
																			HTML5 & CSS3
																		</div>

																		<div class="grid3 center">
																			<div class="center easy-pie-chart percentage"
																				data-percent="80" data-color="#9585BF">
																				<span class="percent">80</span>%
																			</div>

																			<div class="space-2"></div>
																			Javascript/jQuery
																		</div>
																	</div>

																	<div class="hr hr-16"></div>

																	<div class="profile-skills">
																		<div class="progress">
																			<div class="progress-bar" style="width: 80%">
																				<span class="pull-left">HTML5 & CSS3</span> <span
																					class="pull-right">80%</span>
																			</div>
																		</div>

																		<div class="progress">
																			<div class="progress-bar progress-bar-success"
																				style="width: 72%">
																				<span class="pull-left">Javascript & jQuery</span> <span
																					class="pull-right">72%</span>
																			</div>
																		</div>

																		<div class="progress">
																			<div class="progress-bar progress-bar-purple"
																				style="width: 70%">
																				<span class="pull-left">PHP & MySQL</span> <span
																					class="pull-right">70%</span>
																			</div>
																		</div>

																		<div class="progress">
																			<div class="progress-bar progress-bar-warning"
																				style="width: 50%">
																				<span class="pull-left">Wordpress</span> <span
																					class="pull-right">50%</span>
																			</div>
																		</div>

																		<div class="progress">
																			<div class="progress-bar progress-bar-danger"
																				style="width: 35%">
																				<span class="pull-left">Photoshop</span> <span
																					class="pull-right">35%</span>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<!-- #home -->

											<div id="feed" class="tab-pane">
												<div class="profile-feed row-fluid">
													<div class="span6">
														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="Alex Doe's avatar"
																	src="assets/avatars/avatar5.png" /> <a class="user"
																	href="#"> Alex Doe </a> changed his profile photo. <a
																	href="#">Take a look</a>

																<div class="time">
																	<i class="icon-time bigger-110"></i> an hour ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="Susan Smith's avatar"
																	src="assets/avatars/avatar1.png" /> <a class="user"
																	href="#"> Susan Smith </a> is now friends with Alex
																Doe.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 2 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-ok btn-success no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> joined <a
																	href="#">Country Music</a> group.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 5 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-picture btn-info no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> uploaded a new
																photo. <a href="#">Take a look</a>

																<div class="time">
																	<i class="icon-time bigger-110"></i> 5 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="David Palms's avatar"
																	src="assets/avatars/avatar4.png" /> <a class="user"
																	href="#"> David Palms </a> left a comment on Alex's
																wall.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 8 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>
													</div>
													<!-- /span -->

													<div class="span6">
														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-edit btn-pink no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> published a new
																blog post. <a href="#">Read now</a>

																<div class="time">
																	<i class="icon-time bigger-110"></i> 11 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<img class="pull-left" alt="Alex Doe's avatar"
																	src="assets/avatars/avatar5.png" /> <a class="user"
																	href="#"> Alex Doe </a> upgraded his skills.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 12 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-key btn-info no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> logged in.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 12 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-off btn-inverse no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> logged out.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 16 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>

														<div class="profile-activity clearfix">
															<div>
																<i
																	class="pull-left thumbicon icon-key btn-info no-hover"></i>
																<a class="user" href="#"> Alex Doe </a> logged in.
																<div class="time">
																	<i class="icon-time bigger-110"></i> 16 hours ago
																</div>
															</div>

															<div class="tools action-buttons">
																<a href="#" class="blue"> <i
																	class="icon-pencil bigger-125"></i>
																</a> <a href="#" class="red"> <i
																	class="icon-remove bigger-125"></i>
																</a>
															</div>
														</div>
													</div>
													<!-- /span -->
												</div>
												<!-- /row -->

												<div class="space-12"></div>

												<div class="center">
													<a href="#" class="btn btn-small btn-primary"> <i
														class="icon-rss bigger-150 middle"></i> View more
														activities <i class="icon-on-right icon-arrow-right"></i>
													</a>
												</div>
											</div>
											<!-- /#feed -->

											<div id="friends" class="tab-pane">
												<div class="profile-users clearfix">
													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar4.png"
																	alt="Bob Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span
																		class="user-status status-online"></span> Bob Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">Content Editor</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 orange"></i> <span
																			class="green"> 20 mins ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar1.png"
																	alt="Rose Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span
																		class="user-status status-offline"></span> Rose Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">Graphic Designer</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 grey"></i> <span
																			class="grey"> 30 min ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar.png"
																	alt="Jim Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span class="user-status status-busy"></span>
																		Jim Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">SEO &amp; Advertising</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 red"></i> <span
																			class="grey"> 1 hour ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar5.png"
																	alt="Alex Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span class="user-status status-idle"></span>
																		Alex Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">Marketing</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 orange"></i> <span
																			class=""> 40 minutes idle </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar2.png"
																	alt="Phil Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span
																		class="user-status status-online"></span> Phil Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">Public Relations</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 orange"></i> <span
																			class="green"> 2 hours ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar3.png"
																	alt="Susan Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span
																		class="user-status status-online"></span> Susan Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">HR Management</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 orange"></i> <span
																			class="green"> 20 mins ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar1.png"
																	alt="Jennifer Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span
																		class="user-status status-offline"></span> Jennifer
																		Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">Graphic Designer</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 grey"></i> <span
																			class="grey"> 2 hours ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="itemdiv memberdiv">
														<div class="inline position-relative">
															<div class="user">
																<a href="#"> <img src="assets/avatars/avatar3.png"
																	alt="Alexa Doe's avatar" />
																</a>
															</div>

															<div class="body">
																<div class="name">
																	<a href="#"> <span
																		class="user-status status-offline"></span> Alexa Doe
																	</a>
																</div>
															</div>

															<div class="popover">
																<div class="arrow"></div>

																<div class="popover-content">
																	<div class="bolder">Accounting</div>

																	<div class="time">
																		<i class="icon-time middle bigger-120 grey"></i> <span
																			class="grey"> 4 hours ago </span>
																	</div>

																	<div class="hr dotted hr-8"></div>

																	<div class="tools action-buttons">
																		<a href="#"> <i
																			class="icon-facebook-sign blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-twitter-sign light-blue bigger-150"></i>
																		</a> <a href="#"> <i
																			class="icon-google-plus-sign red bigger-150"></i>
																		</a>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>

												<div class="hr hr10 hr-double"></div>

												<ul class="pager pull-right">
													<li class="previous disabled"><a href="#">&larr;
															Prev</a></li>

													<li class="next"><a href="#">Next &rarr;</a></li>
												</ul>
											</div>
											<!-- /#friends -->

											<div id="pictures" class="tab-pane">
												<ul class="ace-thumbnails">
													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-1.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-2.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-3.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-4.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-5.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-6.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-1.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>

													<li><a href="#" data-rel="colorbox"> <img
															alt="150x150" src="assets/images/gallery/thumb-2.jpg" />
															<div class="text">
																<div class="inner">Sample Caption on Hover</div>
															</div>
													</a>

														<div class="tools tools-bottom">
															<a href="#"> <i class="icon-link"></i>
															</a> <a href="#"> <i class="icon-paper-clip"></i>
															</a> <a href="#"> <i class="icon-pencil"></i>
															</a> <a href="#"> <i class="icon-remove red"></i>
															</a>
														</div></li>
												</ul>
											</div>
											<!-- /#pictures -->
										</div>
									</div>
								</div>
							</div>

							<div class="hide">
								<div id="user-profile-3" class="user-profile row">
									<div class="col-sm-offset-1 col-sm-10">
										<div class="well well-sm">
											<button type="button" class="close" data-dismiss="alert">&times;</button>
											&nbsp;
											<div class="inline middle blue bigger-110">Your profile
												is 70% complete</div>

											&nbsp; &nbsp; &nbsp;
											<div style="width: 200px;" data-percent="70%"
												class="inline middle no-margin progress progress-striped active">
												<div class="progress-bar progress-bar-success"
													style="width: 70%"></div>
											</div>
										</div>
										<!-- /well -->

										<div class="space"></div>

										<form class="form-horizontal">
											<div class="tabbable">
												<ul class="nav nav-tabs padding-16">
													<li class="active"><a data-toggle="tab"
														href="#edit-basic"> <i
															class="green icon-edit bigger-125"></i> Basic Info
													</a></li>

													<li><a data-toggle="tab" href="#edit-settings"> <i
															class="purple icon-cog bigger-125"></i> Settings
													</a></li>

													<li><a data-toggle="tab" href="#edit-password"> <i
															class="blue icon-key bigger-125"></i> Password
													</a></li>
												</ul>

												<div class="tab-content profile-edit-tab-content">
													<div id="edit-basic" class="tab-pane in active">
														<h4 class="header blue bolder smaller">General</h4>

														<div class="row">
															<div class="col-xs-12 col-sm-4">
																<input type="file" />
															</div>

															<div class="vspace-xs"></div>

															<div class="col-xs-12 col-sm-8">
																<div class="form-group">
																	<label class="col-sm-4 control-label no-padding-right"
																		for="form-field-username">Username</label>

																	<div class="col-sm-8">
																		<input class="col-xs-12 col-sm-10" type="text"
																			id="form-field-username" placeholder="Username"
																			value="alexdoe" />
																	</div>
																</div>

																<div class="space-4"></div>

																<div class="form-group">
																	<label class="col-sm-4 control-label no-padding-right"
																		for="form-field-first">Name</label>

																	<div class="col-sm-8">
																		<input class="input-small" type="text"
																			id="form-field-first" placeholder="First Name"
																			value="Alex" /> <input class="input-small"
																			type="text" id="form-field-last"
																			placeholder="Last Name" value="Doe" />
																	</div>
																</div>
															</div>
														</div>

														<hr />
														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-date">Birth Date</label>

															<div class="col-sm-9">
																<div class="input-medium">
																	<div class="input-group">
																		<input class="input-medium date-picker"
																			id="form-field-date" type="text"
																			data-date-format="dd-mm-yyyy"
																			placeholder="dd-mm-yyyy" /> <span
																			class="input-group-addon"> <i
																			class="icon-calendar"></i>
																		</span>
																	</div>
																</div>
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right">Gender</label>

															<div class="col-sm-9">
																<label class="inline"> <input
																	name="form-field-radio" type="radio" class="ace" /> <span
																	class="lbl"> Male</span>
																</label> &nbsp; &nbsp; &nbsp; <label class="inline"> <input
																	name="form-field-radio" type="radio" class="ace" /> <span
																	class="lbl"> Female</span>
																</label>
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-comment">Comment</label>

															<div class="col-sm-9">
																<textarea id="form-field-comment"></textarea>
															</div>
														</div>

														<div class="space"></div>
														<h4 class="header blue bolder smaller">Contact</h4>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-email">Email</label>

															<div class="col-sm-9">
																<span class="input-icon input-icon-right"> <input
																	type="email" id="form-field-email"
																	value="alexdoe@gmail.com" /> <i class="icon-envelope"></i>
																</span>
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-website">Website</label>

															<div class="col-sm-9">
																<span class="input-icon input-icon-right"> <input
																	type="url" id="form-field-website"
																	value="http://www.alexdoe.com/" /> <i
																	class="icon-globe"></i>
																</span>
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-phone">Phone</label>

															<div class="col-sm-9">
																<span class="input-icon input-icon-right"> <input
																	class="input-medium input-mask-phone" type="text"
																	id="form-field-phone" /> <i
																	class="icon-phone icon-flip-horizontal"></i>
																</span>
															</div>
														</div>

														<div class="space"></div>
														<h4 class="header blue bolder smaller">Social</h4>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-facebook">Facebook</label>

															<div class="col-sm-9">
																<span class="input-icon"> <input type="text"
																	value="facebook_alexdoe" id="form-field-facebook" /> <i
																	class="icon-facebook blue"></i>
																</span>
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-twitter">Twitter</label>

															<div class="col-sm-9">
																<span class="input-icon"> <input type="text"
																	value="twitter_alexdoe" id="form-field-twitter" /> <i
																	class="icon-twitter light-blue"></i>
																</span>
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-gplus">Google+</label>

															<div class="col-sm-9">
																<span class="input-icon"> <input type="text"
																	value="google_alexdoe" id="form-field-gplus" /> <i
																	class="icon-google-plus red"></i>
																</span>
															</div>
														</div>
													</div>

													<div id="edit-settings" class="tab-pane">
														<div class="space-10"></div>

														<div>
															<label class="inline"> <input type="checkbox"
																name="form-field-checkbox" class="ace" /> <span
																class="lbl"> Make my profile public</span>
															</label>
														</div>

														<div class="space-8"></div>

														<div>
															<label class="inline"> <input type="checkbox"
																name="form-field-checkbox" class="ace" /> <span
																class="lbl"> Email me new updates</span>
															</label>
														</div>

														<div class="space-8"></div>

														<div>
															<label class="inline"> <input type="checkbox"
																name="form-field-checkbox" class="ace" /> <span
																class="lbl"> Keep a history of my conversations</span>
															</label> <label class="inline"> <span
																class="space-2 block"></span> for <input type="text"
																class="input-mini" maxlength="3" /> days
															</label>
														</div>
													</div>

													<div id="edit-password" class="tab-pane">
														<div class="space-10"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-pass1">New Password</label>

															<div class="col-sm-9">
																<input type="password" id="form-field-pass1" />
															</div>
														</div>

														<div class="space-4"></div>

														<div class="form-group">
															<label class="col-sm-3 control-label no-padding-right"
																for="form-field-pass2">Confirm Password</label>

															<div class="col-sm-9">
																<input type="password" id="form-field-pass2" />
															</div>
														</div>
													</div>
												</div>
											</div>

											<div class="clearfix form-actions">
												<div class="col-md-offset-3 col-md-9">
													<button class="btn btn-info" type="button">
														<i class="icon-ok bigger-110"></i> Save
													</button>

													&nbsp; &nbsp;
													<button class="btn" type="reset">
														<i class="icon-undo bigger-110"></i> Reset
													</button>
												</div>
											</div>
										</form>
									</div>
									<!-- /span -->
								</div>
								<!-- /user-profile -->
							</div>

							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->

			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-navbar" /> <label class="lbl"
							for="ace-settings-navbar"> 固定导航条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-sidebar" /> <label class="lbl"
							for="ace-settings-sidebar"> 固定滑动条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-breadcrumbs" /> <label class="lbl"
							for="ace-settings-breadcrumbs">固定面包屑</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl">切换到左边</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> 切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<script src="assets/js/jquery.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.slimscroll.min.js"></script>
	<script src="assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="assets/js/jquery.sparkline.min.js"></script>
	<script src="assets/js/flot/jquery.flot.min.js"></script>
	<script src="assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="assets/js/flot/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->

	<script type="text/javascript">
		jQuery(function($) {
			$('.easy-pie-chart.percentage')
					.each(
							function() {
								var $box = $(this).closest('.infobox');
								var barColor = $(this).data('color')
										|| (!$box.hasClass('infobox-dark') ? $box
												.css('color')
												: 'rgba(255,255,255,0.95)');
								var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)'
										: '#E2E2E2';
								var size = parseInt($(this).data('size')) || 50;
								$(this)
										.easyPieChart(
												{
													barColor : barColor,
													trackColor : trackColor,
													scaleColor : false,
													lineCap : 'butt',
													lineWidth : parseInt(size / 10),
													animate : /msie\s*(8|7|6)/
															.test(navigator.userAgent
																	.toLowerCase()) ? false
															: 1000,
													size : size
												});
							})

			$('.sparkline').each(
					function() {
						var $box = $(this).closest('.infobox');
						var barColor = !$box.hasClass('infobox-dark') ? $box
								.css('color') : '#FFF';
						$(this).sparkline('html', {
							tagValuesAttribute : 'data-values',
							type : 'bar',
							barColor : barColor,
							chartRangeMin : $(this).data('min') || 0
						});
					});

			var placeholder = $('#piechart-placeholder').css({
				'width' : '90%',
				'min-height' : '150px'
			});
			var data = [ {
				label : "social networks",
				data : 38.7,
				color : "#68BC31"
			}, {
				label : "search engines",
				data : 24.5,
				color : "#2091CF"
			}, {
				label : "ad campaigns",
				data : 8.2,
				color : "#AF4E96"
			}, {
				label : "direct traffic",
				data : 18.6,
				color : "#DA5430"
			}, {
				label : "other",
				data : 10,
				color : "#FEE074"
			} ]
			function drawPieChart(placeholder, data, position) {
				$.plot(placeholder, data, {
					series : {
						pie : {
							show : true,
							tilt : 0.8,
							highlight : {
								opacity : 0.25
							},
							stroke : {
								color : '#fff',
								width : 2
							},
							startAngle : 2
						}
					},
					legend : {
						show : true,
						position : position || "ne",
						labelBoxBorderColor : null,
						margin : [ -30, 15 ]
					},
					grid : {
						hoverable : true,
						clickable : true
					}
				})
			}
			drawPieChart(placeholder, data);

			/**
			we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			so that's not needed actually.
			 */
			placeholder.data('chart', data);
			placeholder.data('draw', drawPieChart);

			var $tooltip = $(
					"<div class='tooltip top in'><div class='tooltip-inner'></div></div>")
					.hide().appendTo('body');
			var previousPoint = null;

			placeholder.on('plothover', function(event, pos, item) {
				if (item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : "
								+ item.series['percent'] + '%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({
						top : pos.pageY + 10,
						left : pos.pageX + 10
					});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}

			});

			var d1 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d1.push([ i, Math.sin(i) ]);
			}

			var d2 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.5) {
				d2.push([ i, Math.cos(i) ]);
			}

			var d3 = [];
			for (var i = 0; i < Math.PI * 2; i += 0.2) {
				d3.push([ i, Math.tan(i) ]);
			}

			var sales_charts = $('#sales-charts').css({
				'width' : '100%',
				'height' : '220px'
			});
			$.plot("#sales-charts", [ {
				label : "Domains",
				data : d1
			}, {
				label : "Hosting",
				data : d2
			}, {
				label : "Services",
				data : d3
			} ], {
				hoverable : true,
				shadowSize : 0,
				series : {
					lines : {
						show : true
					},
					points : {
						show : true
					}
				},
				xaxis : {
					tickLength : 0
				},
				yaxis : {
					ticks : 10,
					min : -2,
					max : 2,
					tickDecimals : 3
				},
				grid : {
					backgroundColor : {
						colors : [ "#fff", "#fff" ]
					},
					borderWidth : 1,
					borderColor : '#555'
				}
			});

			$('#recent-box [data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			$('.dialogs,.comments').slimScroll({
				height : '300px'
			});

			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
			var agent = navigator.userAgent.toLowerCase();
			if ("ontouchstart" in document && /applewebkit/.test(agent)
					&& /android/.test(agent))
				$('#tasks').on('touchstart', function(e) {
					var li = $(e.target).closest('#tasks li');
					if (li.length == 0)
						return;
					var label = li.find('label.inline').get(0);
					if (label == e.target || $.contains(label, e.target))
						e.stopImmediatePropagation();
				});

			$('#tasks').sortable({
				opacity : 0.8,
				revert : true,
				forceHelperSize : true,
				placeholder : 'draggable-placeholder',
				forcePlaceholderSize : true,
				tolerance : 'pointer',
				stop : function(event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
					$(ui.item).css('z-index', 'auto');
				}
			});
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click',
					function() {
						if (this.checked)
							$(this).closest('li').addClass('selected');
						else
							$(this).closest('li').removeClass('selected');
					});

		})
	</script>
</body>
</html>

