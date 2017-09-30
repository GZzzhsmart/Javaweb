<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%
		String path = request.getContextPath();
	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
<meta name="keywords" content="">
<meta name="description" content="">
<title>出错了!</title>
<link rel="stylesheet" href="<%=path %>/css/a8ui.common.css" media="all">


</head>
<body>
	<!--顶部导航-->
	<script type="text/javascript">
		$(function() {
			A8.checklogin(); // 检查登录
		})
	</script>

	<div class="menu"></div>
	<!--顶部导航-->
	<div class="error_404">
		<div class="container clearfix">
			<div class="error_pic"></div>
			<div class="error_info">
				<h2>
					<p>对不起，您访问的页面不存在！</p>
				</h2>
				<div class="operate">
					<input class="global_btn btn_89bf43"
						onclick="location.href='javascript:void(0);'" type="button"
						value="返回主页"> <input class="global_btn btn_39dec8 ml1"
						onclick="history.go(-1)" type="button" value="返回上一页">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#back_top > a").click(function() {
				$("html, body").animate({
					scrollTop : "0px"
				}, 1000);
				return false
			});
		})
	</script>

	<script type="text/javascript">
		var cnzz_protocol = (("https:" == document.location.protocol) ? " https://"
				: " http://");
		document
				.write(unescape("%3Cdiv id='cnzz_stat_icon_30061279'%3E%3C/div%3E%3Cscript src='"
						+ cnzz_protocol
						+ "w.cnzz.com/c.php%3Fid%3D30061279' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<div id="cnzz_stat_icon_30061279"></div>
	<div style="display: none"></div>
	