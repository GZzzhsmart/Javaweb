$(document).ready(function(){
	//nav鼠标移入点击效果  推荐品牌
	current($(".brand_nav").children("li"),"current");
	//热门产品
	current($(".hot_nav").children("li"),"current");

	//首页轮播图
	$(".brand_lunbo").slide({
		mainCell:".bd ul",
		autoPlay:true,
		effect:"leftLoop",
		delayTime:1000		//轮播一张图片所需要的时间
	});

	// 首页文字滚动轮播
	$(".txtMarquee-top").slide({
		mainCell:"ul",
		autoPlay:true,
		effect:"topMarquee",
		vis:3,
		interTime:50
	});

	//推荐品牌 移入移出透明度
	opacity($("#brand_left>li"),"a");
	opacity($(".brand_img"),"a");
	opacity($("#hot").find("a"),"img");

	//优惠券
	$("#coupon").children("li").mouseenter(function(){
		$(this).children("a").css("margin-left","3px");
		$(this).children("p").css("left","29px");
	});
	$("#coupon").children("li").mouseleave(function(){
		$(this).children("a").css("margin-left","0");
		$(this).children("p").css("left","26px");
	});

	//活动资讯
	opacity($("#information_z>li"),"a");

	//家具商场
	opacity($("#market"),"li:not('.ts6')");

	$("#ts6>.ts6_box_c").mouseenter(function(){
		if($(this).children("div").css("display")=="none"){
			$(this).children("p").css("display","none").parent().siblings().children("p").css("display","block");
			$(".ts6_box_c").children("div").css("display","none");
			$(this).children("div").css("display","block");
		}
	});

	//展会轮播
	//$(".show_con").slide({
	//	mainCell:".bd ul",
	//	autoPlay:true,
	//	effect:"leftMarquee",
	//	vis:6,
	//	interTime:50,
	//	trigger:"mouseover"
	//});
	$(".show_con").slide({
	    mainCell: ".bd .picList",
	    effect: "leftLoop",
	    autoPlay: true,
	    vis: 6
	});



	//友情链接展开收起
	//var nowHeight=$("#link_title").height();
	//$("#load").children("span").each(function(index,val){
	//	$(val).click(function(){
	//		if(index==0){
	//			$("#link_box").animate({"height":nowHeight+"px"},500);
	//			$(this).css("display","none").next().css("display","inline-block");
	//		}else{
	//			$("#link_box").animate({"height":"90px"},500);
	//			$(this).css("display","none").prev().css("display","inline-block");
	//		}
	//	});
	//});

	$(".brand_nav>li").each(function (index, val) {
	    $(val).click(function () {
	        $(".brand_left").css("display", "none");
	        $(".brand_left").eq(index).css("display", "block");
	    });
	});
    // 热门产品点击
	$(".hot_nav>li").each(function (index, val) {
	    $(val).click(function () {
	        $(".hot_bottom").css("display", "none");
	        $(".hot_bottom").eq(index).css("display", "block");
	    });
	});
    //优惠券文字轮播
	$(".laba").slide({
	    mainCell: ".laba_text ul",
	    autoPage: true,
	    effect: "topLoop",
	    autoPlay: true,
	    vis: 1
	});
});

//封装鼠标移入，点击方法
function current($element, className) {

	$element.off("mouseenter");
	$element.mouseenter(function(){
	    if (!$(this).hasClass(className)) {
	        $(this).append("<img src='/images/arrow.png'/>").find("a").css({ "border": "1px solid #41CCB4", "color": "#41CCB4" });
		}
	});
	$element.off("mouseleave");
	$element.mouseleave(function(){
	    if (!$(this).hasClass(className)) {
			$(this).find("img").remove();
			$(this).find("a").css({"border":"1px solid #d7d7d7","color":"#666"});
		}
	});
	//nav点击事件
	$element.off("click");
	$element.click(function(){
	    $(this).addClass(className).append("<img src='/images/arrow.png'/>").siblings().removeClass(className).find("img").remove();
		$(this).siblings().find("a").css({"border":"1px solid #d7d7d7","color":"#666"});
		$(this).find("img").eq(1).remove();
	});
}


//透明度
function opacity($element, className) {
    $element.children(className).mouseenter(function () {
		$(this).css("opacity","0.8");
		$(this).css("filter","alpha(opacity=80)");
	});
    $element.children(className).mouseleave(function () {
		$(this).css("opacity","1");
		$(this).css("filter","alpha(opacity=100)");
	});
}
