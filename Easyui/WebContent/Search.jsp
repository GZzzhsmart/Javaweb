<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:wb="http://open.weibo.com/wb"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>css+div家具网页面小例子</title>
    <meta charset="utf-8">
    <meta name="keywords" content="家具,家具网,">
    <meta name="description" content="GO佳居家具网">
    <!--页面图标-->
    <link rel="shortcut" href="http://www.gojiaju.com/favicon.ico">
    <link href="./jiaju/main.css" rel="stylesheet">
    <link href="./jiaju/iframeStyle.css" rel="stylesheet">
    <link href="./jiaju/dropdown_menu.css" rel="stylesheet">
    <link href="./jiaju/movepic.css" rel="stylesheet">
    <link href="./jiaju/home.css" rel="stylesheet">   
</head>
<body>
<!--头部--> 
<div class="head">
    <div>
        <span>欢迎来到乐佳居!</span>
        <span id="state" data-state="0">
			<a href="javascript:void(0);" rel="nofollow" target="_blank">登录</a>
			<sapn>&nbsp;&nbsp;</sapn>
			<a href="javascript:void(0);" rel="nofollow" target="_blank">免费注册</a>
        </span>
        <a href="javascript:void(0);">微信</a>
        <a href="javascript:void(0);" target="_blank">客户服务</a>
        <a href="javascript:void(0);" rel="nofollow"><em><img style="display:inline-block;" src="./jiaju/gwc.jpg" alt="购物车"></em>购物车(0)</a>
        <a href="javascript:void(0);" target="_blank" rel="nofollow">个人中心</a>
    </div>
</div>
<div class="operat">
    <a href="javascript:void(0);"><img src="./jiaju/logo.jpg" alt="logo" id="logo"></a>
    <div class="city">
        <span>赣州站</span>
        <p>切换城市</p>
    </div>
    <div>
        <p>
            <span class="sel" category="brand">品牌</span>
            <span category="product">产品</span>
            <span category="mall">商场</span>
            <span category="store">店铺</span>
            <span category="panorama">全景</span>
        </p>
        <div class="search">
			<form action="#" method="post">                
				<input name="keywords" id="keywords" type="text" autocomplete="off">
                <input type="submit" value="搜索">
                <input type="hidden" id="category" name="category" value="brand">
                <input type="hidden" name="SortOrder" id="SortOrder" value="editdate_desc">
			</form>        
		</div>
    </div>
        <a href="javascript:void(0);" target="_blank">
            <img src="./jiaju/9bd42ee7-36d7-4397-abd0-ae3ff4276793.jpg" alt="优惠券" title="优惠券">
        </a>
	</div>
<div class="menuNav">
    <div class="nav">
        <ul>
            <li style="width:150px; text-align:center;">全部产品分类
            </li>
            <li><a href="javascript:void(0);" class="sel">首页</a></li>
            <li><a href="javascript:void(0);" class="">活动</a></li>
            <li><a href="javascript:void(0);" class="">优惠券</a></li>
            <li><a href="javascript:void(0);" class="">资讯</a></li>
            <li><a href="javascript:void(0);" target="_self" class="">品牌</a></li>
            <li><a href="javascript:void(0);" target="_self" class="">商场</a></li>
            <li><a href="javascript:void(0);" class="">产品</a></li>
            <li><a href="javascript:void(0);" class="">全景</a></li>
            <li><a href="javascript:void(0);" class="">加盟</a><img style="display: inline-block;" src="./jiaju/195a7163-c19c-4039-88ad-793e789b3458.gif" alt="品牌加盟"></li>
            <li><a href="javascript:void(0);" target="_blank">佳居金融</a></li>
        </ul>
    </div>
    <div class="pullDown" style="left: 54px;">
        <!--左导航-->
        <ul class="pullDownList" style="display: block; background-color: rgb(250, 250, 250);">
            <li class="">
                <a href="javascript:void(0);" target="_blank">卧室家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">客厅家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">餐厅家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">书房家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">门厅家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">儿童家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">休闲家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">户外家具</a>
                <span></span>
            </li>
            <li class="">
            
                <a href="javascript:void(0);" target="_blank">酒店家具</a>
                <span></span>
            </li>
            <li class="">
              
                <a href="javascript:void(0);" target="_blank">工程家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">红木家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">办公家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">定制家具</a>
                <span></span>
            </li>
            <li class="">
                <a href="javascript:void(0);" target="_blank">学校用具</a>
    <span></span>
</li>
        </ul>
        <!-- 下拉详细列表具体分类 -->
        <div class="yMenuListCon " style="display: none; box-shadow: rgba(200, 200, 200, 0.6) 10px 2px 8px;">
        </div>
    </div>
</div>
 
<div class="container">
    <!--BANNER区-->
    <div class="yBanner">
        <div class="yBannerList ybannerExposure" style="display: block;">
            <!--BANNER区-->
            <div id="js_banner" class="fx_banner" style="width: 1308px; overflow: hidden; zoom: 1;">
                <ul id="js_banner_img" class="fx_banner_img clear" style="position: relative; left: -13080px; margin-left: 10464px; width: 5232px;">
                <li style="width: 1308px; float: left; background: rgb(253, 196, 211);">
                                <div class="fx_banner_inner fx_grid_c1" style="margin-left: 54px;">
                                        <div class="child child0" data-z="1">
                                            <img src="./jiaju/562a0026-b8d1-420a-9e29-4f1466a53efb.jpg" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="2" style="left: 0px; top: 0px; margin-left: 0px;">
                                            <img src="./jiaju/bd7bbd54-3623-4841-b9e8-e3f010500824.png" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="3" style="left: 0px; top: 0px; margin-left: 0px;">
                                            <img src="./jiaju/saved_resource" alt="GO佳居">
                                        </div>
                                </div>
                            </li><li style="width: 1308px; float: left; background: rgb(21, 185, 176);">
                                <div class="fx_banner_inner fx_grid_c1" style="margin-left: 54px;">
                                        <div class="child child0" data-z="1">
                                            <img src="./jiaju/1f0650e4-e35f-41e2-ab73-e34577537a43.jpg" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="2" style="left: 0px; top: 0px; margin-left: 0px;">
                                            <img src="./jiaju/758ec2ab-98f6-4a79-905e-a8d17fe61194.png" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="3" style="left: 0px; top: 0px; margin-left: 0px;">
                                            <img src="./jiaju/70c4e5f2-b57c-49ee-a860-fcc238386012.png" alt="GO佳居">
                                        </div>
                                </div>
                            </li><li style="width: 1308px; float: left; background: rgb(253, 196, 211);">
                                <div class="fx_banner_inner fx_grid_c1" style="margin-left: 54px;">
                                        <div class="child child0" data-z="1">
                                            <img src="./jiaju/562a0026-b8d1-420a-9e29-4f1466a53efb.jpg" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="2" style="left: 0px; top: 0px; margin-left: -2.89416px;">
                                            <img src="./jiaju/bd7bbd54-3623-4841-b9e8-e3f010500824.png" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="3" style="left: 0px; top: 0px; margin-left: -12.0683px;">
                                            <img src="./jiaju/saved_resource" alt="GO佳居">
                                        </div>
                                </div>
                            </li><li style="width: 1308px; float: left; background: rgb(21, 185, 176);">
                                <div class="fx_banner_inner fx_grid_c1" style="margin-left: 54px;">
                                        <div class="child child0" data-z="1">
                                            <img src="./jiaju/1f0650e4-e35f-41e2-ab73-e34577537a43.jpg" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="2" style="left: 0px; top: 0px; margin-left: 0px;">
                                            <img src="./jiaju/758ec2ab-98f6-4a79-905e-a8d17fe61194.png" alt="GO佳居">
                                        </div>
                                        <div class="child" data-z="3" style="left: 0px; top: 0px; margin-left: 0px;">
                                            <img src="./jiaju/70c4e5f2-b57c-49ee-a860-fcc238386012.png" alt="GO佳居">
                                        </div>
                                </div>
                            </li></ul>
                <div class="fx_banner_common fx_grid_c1" style="margin-left: 54px;">
                    <a ytag="30000" id="js_banner_pre" href="javascript:void(0);" class="fx_banner_pre"></a>
                    <a ytag="30010" id="js_banner_next" href="javascript:void(0);" class="fx_banner_next"></a>
                </div>
                <!--优惠券信息-->
                <div class="couponScroll" style="right: 54px;">
                    <ul style=" width:260px;">
						<a href="javascript:void(0);" target="_blank">
							<img src="./jiaju/85379792-0272-44d0-93ec-bcb2ee6f6531.jpg" alt="GO佳居城市合伙人" title="GO佳居城市合伙人">
						</a>
                    </ul>
                </div>
                <!--礼品信息-->
                <div class="lp" style="right: 54px;">                    
					<a href="javascript:void(0);" target="_blank">
						<img src="./jiaju/8e21debe-ea24-49e5-ad70-85c09f3632c7.gif" alt="Go佳居双12品牌大优惠" title="Go佳居双12品牌大优惠">
					</a>
                </div>
            <ul class="control"><li class=""><a href="javascript:void(0);">1</a></li><li class="current"><a href="javascript:void(0);">2</a></li></ul></div>
            <div class="ltj">
                <ul>
                    <li>
                        <a href="javascript:void(0);" target="_blank"><img src="./jiaju/3.3ad.jpg" alt="Go佳居金融"></a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" target="_blank"><img src="./jiaju/3.2ad.jpg" alt="Go佳居品牌加盟"></a>
                    </li>
                    <li style="margin-right: 0px;">
                        <a href="javascript:void(0);" target="_blank"><img src="./jiaju/3.1ad.jpg" alt="Go佳居会员店铺全景，商场全景"></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
 <!--首页 nav-->
    <script src="./jiaju/hm.js"></script>
    <script src="./jiaju/uaredirect.js"></script>
    <script src="./jiaju/jquery-1.8.2.min.js"></script>
    <script src="./jiaju/ellipsis.js"></script>
    <script src="./jiaju/mainScrpit.js"></script>
    <script src="./jiaju/home.js"></script>
    <script src="./jiaju/jquery.SuperSlide.2.1.1.js"></script>
    <script src="./jiaju/movepic.js"></script>
    <script src="./jiaju/tab.js"></script>
</html>