$(function(){
	var W=document.body.offsetWidth;
	var H= document.documentElement.clientHeight;
	$(".viewMenu").css("height",H+'px');
	$(".3dView").css("height",H+'px');
	$("#js_banner .couponScroll").css("right",(W-1200)/2+'px');
	$(".fx_grid_c1").css("margin-left",(W-1200)/2+'px');
	$("#js_banner .lp").css("right",(W-1200)/2+'px');
	var w = $(".nav").width();
	$(".pullDown").css("left", (W - 1200) / 2 + 'px');
	$(".fixed_index").css("height",H+'px');
	//头部导航
	$(".nav ul li a").not(".sel").hover(function(){
		$(this).addClass("sel2");
	},function(){
		$(this).removeClass("sel2");
	});
	$(".typeSel ul li").click(function(){
		$(".typeSel ul li").removeClass("sel");
		$(this).addClass("sel");
		var index=$(this).index();
		var str="sel"+index;
		$(".selDiv").css("display","none");
		$("#"+str).css("display","block");
	});
	$(".selDiv p span").click(function(){
		$(".selDiv p span").removeClass("sel");
		$(this).addClass("sel");
	});

	$('.menuNav .nav ul li:first-child').click(function () {
	    //$('.pullDownList').fadeIn();
	    var updown = $(this).find("span").html()
	    if (updown !== '∨' && updown !== '∧')
	        return;
        if (updown == "∨") {
	        $(this).find("span").html("∧");
	        $(".pullDownList").slideDown("fast")
	    }
	    else {
	        $(this).find("span").html("∨");
	        $(".pullDownList").slideUp("fast")
	    }
	});

	$("#selResult").append("<a href='' target='_blank'>"+"查看更多>"+"</a>")
	$(".pullDownTitle").click(function () {
    	if($(this).find("span").html()=="∨"){
    		$(this).find("span").html("∧");
    		$(".pullDownList").slideDown("fast")
    	}
    	else{
    		$(this).find("span").html("∨");
    		$(".pullDownList").slideUp("fast")
    	}
    });
    $(".active div p").not( $(".active div p:first-child")).hover(function(){
    	$(this).find("span").css("width",5+'px');
    },function(){
    	$(this).find("span").css("width",5+'px').stop();
    	$(this).find("span").css("width",0+'px');
    });
    $(".active .title em").mouseover(function(){
    	$(".active .title em").removeClass("sel");
    	$(this).addClass("sel");
    	var index=$(this).index();
    	str="active"+index;
    	$(".active div").css("display","none");
    	$("#"+str).css("display","block");
    });

    // 导航左侧栏js效果 start
    $(".yMenuListCon").hide();
    $(".pullDownList li").hover(function () {
        $(".yMenuListCon").css("box-shadow", "10px 2px 8px rgba(200,200,200,0.6)");
        $(".pullDownList").css("background-color", "#f2f2f2");
        $(".yMenuListCon").fadeIn();
        var index = $(this).index(".pullDownList li");
        if (!($(this).hasClass("menulihover") || $(this).hasClass("menuliselected"))) {
            $($(".yBannerList")[index]).css("display", "block").siblings().css("display", "none");
            $($(".yBannerList")[index]).removeClass("ybannerExposure");
            setTimeout(function () {
                $($(".yBannerList")[index]).addClass("ybannerExposure");
            }, 60)
        } else {
        }
        $(this).addClass("menulihover").siblings().removeClass("menulihover");
        $(this).addClass("menuliselected").siblings().removeClass("menuliselected");
        $($(".yMenuListConin")[index]).fadeIn().siblings().fadeOut();
    }, function () {

    })
    $(".pullDown").mouseleave(function () {
        $(".yMenuListCon").fadeOut();
        $(".yMenuListConin").fadeOut();
        $(".pullDownList li").removeClass("menulihover");
        $(".pullDownList li").removeClass("menuliselected");
        $(".pullDownList").css("background-color", "#fafafa");
    })
    // 导航左侧栏js效果  end
    //优惠券下拉
    $(".hotyhq ul li:first-child").find("div").slideDown();
    $(".hotyhq ul li .hotTitle").mouseover(function(){
    	var display=$(this).parent().find("div").css("display");
    	if(display=='none'){
    		$(".hotyhq ul li").find("div").slideUp();
    		$(".hotyhq ul li .hotTitle").find("span").html("∨")
    		$(this).parent().find("div").slideDown();
    		$(this).find("span").html("∧");
    	}
    });
     
    $(".newsyhq ul li:first-child").find("div").slideDown();
    $(".newsyhq ul li .hotTitle").mouseover(function(){
    	var display=$(this).parent().find("div").css("display");
    	if(display=='none'){
    		$(".newsyhq ul li").find("div").slideUp();
    		$(".newsyhq ul li .hotTitle").find("span").html("∨")
    		$(this).parent().find("div").slideDown();
    		$(this).find("span").html("∧");
    	}
    });
    
    $(".reyhq ul li:first-child").find("div").slideDown();
    $(".reyhq ul li .hotTitle").mouseover(function(){
    	var display=$(this).parent().find("div").css("display");
    	if(display=='none'){
    		$(".reyhq ul li").find("div").slideUp();
    		$(".reyhq ul li .hotTitle").find("span").html("∨")
    		$(this).parent().find("div").slideDown();
    		$(this).find("span").html("∧");
    	}
    });
    /*立体家*/
    $(".ltj ul li").mouseenter(function () {
        $(this).css("margin-right", "2px");
    }).mouseleave(function () {
        $(this).css("margin-right", "0px");
    });
    //电话号码3位隐藏
    var telLen=$(".last #ul1 li").length;
    var ul1=$(".last #ul1");
    var ul2=$(".last #ul2");
    //for(var i=0;i<telLen;i++){
    //    var str = ul1.find("li").eq(i).find(".tel").html();
    //    alert(str);
    //	if (str.length >= 11) {
    //	    str = str.subString(0, 7) + '***' + str.subString(7, 11);
    //	    ul1.find("li").eq(i).find(".tel").html(str)
    //	}
    //}
    //最新领用向上滚动
    var ul1h=ul1.height();
    if(ul1h>244){
    	var topNum=0;
    	var yhqT=setInterval(function(){
    		topNum--;
    		ul1.animate({top:topNum+'px'},10,function(){
    			if(Math.abs(topNum)%68==0){
    				ul1.find("li").first().insertAfter(ul1.find("li").last());
    				ul1.css("top",0);
    				topNum=0;
    			}
    		});
    	},50);
    }
    //全景图片缩小
    $(".view ul li a img").hover(function(){
    	$(this).css("width",240+'px');
    	$(this).css("height",187.8+'px');
    	$(this).css("margin-top",-5+'px');
    	$(this).css("margin-left",-5+'px');
    },function(){
    	$(this).css("width",230+'px').stop();
    	$(this).css("height",180+'px').stop();
    	$(this).css("width",230+'px');
    	$(this).css("height",180+'px');
    	$(this).css("margin-top",0+'px');
    	$(this).css("margin-left",0+'px');
    });
    
    //产品图片缩小
    $(".product table td a img").hover(function(){
    	$(this).css("width",234+'px');
    	$(this).css("height",175.5+'px');
    	$(this).css("margin-top",-3+'px');
    	$(this).css("margin-left",-3+'px');
    },function(){
    	$(this).css("width",234+'px').stop();
    	$(this).css("height",175.5+'px').stop();
    	$(this).css("width",224+'px');
    	$(this).css("height",168+'px');
    	$(this).css("margin-top",0+'px');
    	$(this).css("margin-left",0+'px');
    });
    //最新商场
    var shopLi=$(".shop .newShop ul li");
    var shopI=0
    $(".shop .newShop ul li:eq(0)").find(".shopT").slideUp();
    $(".shop .newShop ul li:eq(0)").find("div").slideDown()
	$(".shop .shopT").hover(function(){
		shopLi.eq(shopI).find("div").css("display","none");
		shopLi.eq(shopI).find(".shopT").css("display","block");
		$(this).parent().find("div").css("display","block");
		$(this).parent().find(".shopT").css("display","none");
		shopI=$(this).parent().index();
	});
	//图库js
	$(".imgKu .title em").mouseover(function(){
		var kui=$(this).index();
		$(".imgKu .title em").removeClass("sel");
		$(this).addClass("sel");
		$(".imgKu ul").css("display","none");
		$("#ku"+kui).css("display","block");
	});
	//展会js
	var exUl=$(".exhibition ul");
	var exLen=exUl.find("li").length;
//	var exDiv=$(".exhibition>div div");
	exUl.css("width",(exLen*180+(exLen-1)*24)+'px');
//	$(".exhibition>div div").css("width",((exLen*180+(exLen-1)*24)*2+24)+'px');
	var exLeft=0;
	var exw=$(".exhibition ul").width();
	var exT;
	//定义滚动函数
	function move(){
		exT=setInterval(function(){
		exLeft--;
		exUl.animate({left:exLeft+'px'},10,function(){
			if(Math.abs(exLeft)==180){
				exUl.find("li").first().insertAfter(exUl.find("li").last());
				exUl.css("left",24+'px');
				exLeft=24;
			}
		});
		},100);
	}
	//点击向前按钮
		$("#exPrev").click(function(){
			exUl.find("li").last().insertBefore(exUl.find("li").first());
			exUl.css("left",0);
			exLeft=0;
		});
	//向后按钮
	$("#exNext").click(function(){
			exUl.find("li").first().insertAfter(exUl.find("li").last());
			exUl.css("left",0);
			exLeft=0;
		});
	if(exw>1200){
		move();
	}
	else{
		$("#exNext").click(function(){alert("没有更多")});
		$("#exPrev").click(function(){alert("没有更多")});
	}
	//
	exUl.hover(function(){
		clearInterval(exT);
	},
	function(){
		move();
	});
//	//活动页图片滚播
	var actLen=$("#activeScroll img").length;
	var actscroll=$("#activeScroll")
	var actI=0;
	//添加索引
	for(var i=0;i<actLen;i++){
		$(".actControl").append("<li></li>");
	}
	//点击索引
	$(".actControl li").click(function(){
		actI=$(this).index();
		actscroll.find("img").fadeOut();
		$(".actControl li").removeClass("sel");
		actscroll.find("img").eq(actI).fadeIn();
		$(".actControl li:eq("+actI+")").addClass("sel");
	});
	$(".actControl li:eq(0)").addClass("sel");
	setInterval(function(){
		actscroll.find("img").eq(actI).fadeOut();
		$(".actControl li:eq("+actI+")").removeClass("sel");
		if(actI==actLen-1){
			actI=-1;
		}
		actscroll.find("img").eq(actI+1).fadeIn();
		$(".actControl li:eq("+(actI+1)+")").addClass("sel");
		actI+=1;
	},3000);
	//活动专题活动框变色
	$(".Active .ztActive li").hover(function(){
		$(this).find("div").addClass("sel");
	},function(){
		$(this).find("div").removeClass("sel");
	});
	//商家-----最新商家活动
	var lastI=0;
	$(".sj .lastAct #lastUl li").mouseover(function(){
		$(".sj .lastAct #lastUl li:eq("+lastI+")").find("div").css("display","none");
		$(".sj .lastAct #lastUl li:eq("+lastI+")").find("a:first-child").css("display","block");
		lastI=$(this).index();
		$(this).find("div").css("display","block");
		$(this).find("a:first-child").css("display","none");
	});
	//商家-----即将到期活动
	var jjdqI=0;
	$(".sj .lastAct #jjdqUl li").mouseover(function(){
		$(".sj .lastAct #jjdqUl li:eq("+lastI+")").find("div").css("display","none");
		$(".sj .lastAct #jjdqUl li:eq("+lastI+")").find("a:first-child").css("display","block");
		lastI=$(this).index();
		$(this).find("div").css("display","block");
		$(this).find("a:first-child").css("display","none");
	});
	//商场-----最新商家活动
	var lastI=0;
	$(".sc .lastAct #lastUl li").mouseover(function(){
		$(".sc .lastAct #lastUl li:eq("+lastI+")").find("div").css("display","none");
		$(".sc .lastAct #lastUl li:eq("+lastI+")").find("a:first-child").css("display","block");
		lastI=$(this).index();
		$(this).find("div").css("display","block");
		$(this).find("a:first-child").css("display","none");
	});
	//商场-----即将到期活动
	var jjdqI=0;
	$(".sc .lastAct #jjdqUl li").mouseover(function(){
		$(".sc .lastAct #jjdqUl li:eq("+lastI+")").find("div").css("display","none");
		$(".sc .lastAct #jjdqUl li:eq("+lastI+")").find("a:first-child").css("display","block");
		lastI=$(this).index();
		$(this).find("div").css("display","block");
		$(this).find("a:first-child").css("display","none");
	});

	//活动首页tab
	var actTabi=0;
	$(".Active .tab a").not(".sel").mouseover(function(){
		$(".Active .tab a").removeClass("sel2");
		$(this).addClass("sel2");
	});
	//优惠券图片滚播
	var yhqLen=$("#couponScroll img").length;
	var yhqscroll=$("#couponScroll")
	var yhqI=0;
	//添加索引
	for(var i=0;i<yhqLen;i++){
		$(".yhqControl").append("<li></li>");
	}
	//点击索引
	$(".yhqControl li").click(function(){
		yhqI=$(this).index();
		yhqscroll.find("img").fadeOut();
		$(".yhqControl li").removeClass("sel");
		yhqscroll.find("img").eq(yhqI).fadeIn();
		$(".yhqControl li:eq("+yhqI+")").addClass("sel");
	});
	$(".yhqControl li:eq(0)").addClass("sel");
	setInterval(function(){
		yhqscroll.find("img").eq(yhqI).fadeOut();
		$(".yhqControl li:eq("+yhqI+")").removeClass("sel");
		if(yhqI==yhqLen-1){
			yhqI=-1;
		}
		yhqscroll.find("img").eq(yhqI+1).fadeIn();
		$(".yhqControl li:eq("+(yhqI+1)+")").addClass("sel");
		yhqI+=1;
	},3000);
	//优惠券页面
	var couponI=0;
	$(".allYhq ul li").mouseover(function(){
		$(".allYhq ul li:eq("+couponI+")").removeClass("sel");
		$(this).addClass("sel");
		couponI=$(this).index();
	});
	
	//资讯页图片滚播
	var newsLen=$("#newsScroll img").length;
	var newsscroll=$("#newsScroll")
	var newsI=0;
	//添加索引
	for(var i=0;i<newsLen;i++){
		$(".newsControl").append("<li></li>");
	}
	//点击索引
	$(".newsControl li").click(function(){
		newsI=$(this).index();
		newsscroll.find("img").fadeOut();
		$(".newstControl li").removeClass("sel");
		newsscroll.find("img").eq(newsI).fadeIn();
		$(".newsControl li:eq("+newsI+")").addClass("sel");
	});
	$(".newsControl li:eq(0)").addClass("sel");
	setInterval(function(){
		newsscroll.find("img").eq(newsI).fadeOut();
		$(".newsControl li:eq("+newsI+")").removeClass("sel");
		if(newsI==newsLen-1){
			newsI=-1;
		}
		newsscroll.find("img").eq(newsI+1).fadeIn();
		$(".newsControl li:eq("+(newsI+1)+")").addClass("sel");
		newsI+=1;
	},3000);
	//资讯获取当天日期
	var data=new Date();
	var y=data.getFullYear();//年
	var m=data.getMonth()+1;//月，0开始
	var w=data.getDay();//星期几
	var d=data.getDate();//日
	var arr=['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];
	var str=y+"-"+m+"-"+d+" "+arr[w];
	$(".news #day").html(str);
	
	
	
	//注册界面js
	$(".register input[type=text]").click(function(){
		if($(this).val()!=""){
			$(this).val("");
		}
	});
	//判断用户名是否null
	$(".name").blur(function(){
		if($(this).val()==""){
			var src="image/error.jpg";
			var message="用户名不能为空";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
		else{
			var src="image/pass.jpg";
			var message="用户名可用,一经注册不可修改";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
	});
	//判断手机号
	$(".phone").blur(function(){
		var str=$(this).val();
		if(!/^1[3,5,8]{1}[0-9]{9}$/.test(str)){
			var src="image/error.jpg";
			var message="手机号格式不正确!";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
		else{
			var src="image/pass.jpg";
			var message="手机号可用";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
	});
	//手机验证码
	$(".yz input[type=button]").click(function(){
		var src="image/pass.jpg";
		var message="验证码已发送";
		$(this).parents("p").find(".tips").find("img").attr("src",src);
		$(this).parents("p").find(".tips").find("i").html(message);
	});
	//判断密码是否null
	$(".password").blur(function(){
		if($(this).val()==""){
			var src="image/error.jpg";
			var message="密码不能为空";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
			$(this).parents("p").find(".tips").find("em").fadeOut();
		}
		else{
			var src="image/pass.jpg";
			var message="安全程度";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
			$(this).parents("p").find(".tips").find("em").fadeIn();
			var pwLen=$(".password").val().length;
			if(pwLen>0&&pwLen<=6){
				$(this).parents("p").find(".tips").find("em").css("background","#ff3300");
				$(this).parents("p").find(".tips").find("em").html("");
				$(this).parents("p").find(".tips").find("i+em").html("弱");
			}
			else if(pwLen>6&&pwLen<=8){
				$(this).parents("p").find(".tips").find("em").css("background","#2ebef4");
				$(this).parents("p").find(".tips").find("em").html("");
				$(this).parents("p").find(".tips").find("i+em+em").html("中");
			}
			else{
				$(this).parents("p").find(".tips").find("em").css("background","green");
				$(this).parents("p").find(".tips").find("em").html("");
				$(this).parents("p").find(".tips").find("i+em+em+em").html("强");
			}
		}
	});
	//判断密码是否相同
	$(".confirm").blur(function(){
		var pw=$(".password").val();
		if($(this).val()==""){
			var src="image/error.jpg";
			var message="密码不能为空";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
		else if($(this).val()!=pw){
			var src="image/error.jpg";
			var message="密码不一致";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
		else{
			var src="image/pass.jpg";
			var message="";
			$(this).parents("p").find(".tips").find("img").attr("src",src);
			$(this).parents("p").find(".tips").find("i").html(message);
		}
	});

	$(".point>div p span").click(function(){
		$(".point>div p span").removeClass("sel");
		$(this).addClass("sel");
	});
	//活动页面灵感图库
	var tkIndex=0;
	$(".tk .prev").click(function(){
		var tkLen=$(".tk").find("img").length;
		if(tkIndex==0){
			$(".tk").find("img").eq(tkIndex).fadeOut();
			tkIndex=tkLen-1;
			$(".tk").find("img").eq(tkIndex).fadeIn();
		}
		else{
			$(".tk").find("img").eq(tkIndex).fadeOut();
			tkIndex-=1;
			$(".tk").find("img").eq(tkIndex).fadeIn();
		}
	});
	$(".tk .next").click(function(){
		var tkLen=$(".tk").find("img").length;
		if(tkIndex==tkLen-1){
			$(".tk").find("img").eq(tkIndex).fadeOut();
			tkIndex=0;
			$(".tk").find("img").eq(tkIndex).fadeIn();
		}
		else{
			$(".tk").find("img").eq(tkIndex).fadeOut();
			tkIndex+=1;
			$(".tk").find("img").eq(tkIndex).fadeIn();
		}
	});
	//品牌图片滚播
	var bandLen=$(".Bandscroll img").length;
	var bandscroll=$(".Bandscroll")
	var bandI=0;
	//添加索引
	for(var i=0;i<bandLen;i++){
		$(".Bandscroll .control").append("<li></li>");
	}
	$(".Bandscroll .control li").eq(0).addClass("sel");
	//点击索引
	$(".Bandscroll .control li").click(function(){
		bandI=$(this).index();
		bandscroll.find("img").fadeOut();
		$(".Bandscroll .control li").removeClass("sel");
		bandscroll.find("img").eq(bandI).fadeIn();
		$(".Bandscroll .control li:eq("+bandI+")").addClass("sel");
	});
	$(".Bandscroll .control li:eq(0)").addClass("sel");
	setInterval(function(){
		bandscroll.find("img").eq(bandI).fadeOut();
		$(".Bandscroll .control li:eq("+bandI+")").removeClass("sel");
		if(bandI==bandLen-1){
			bandI=-1;
		}
		bandscroll.find("img").eq(bandI+1).fadeIn();
		$(".Bandscroll .control li:eq("+(bandI+1)+")").addClass("sel");
		bandI+=1;
	},3000);
	
	//品牌列表
	var blIndex=0;
	var blIndex2=0;
	$(".bandlist .selType li").click(function(){
		$(".bandlist .selType li").removeClass("sel");
		blIndex=$(this).index();
		$(this).addClass("sel");

		$('.result').hide();
		$($('.result')[blIndex]).show();

	});
	$(".bandlist .result span").click(function(){
		$(".bandlist .result span").eq(blIndex2).removeClass("sel");
		blIndex2=$(this).index()-1;
		$(this).addClass("sel");
	});
	var em=true;
	$(".sortType span").click(function(){
		$(this).siblings().removeClass("sel");
		$(this).addClass("sel");
		if(em){
			$(this).find("em").html("∨");
			em=false;
		}
		else{
			$(this).find("em").html("∧");
			em=true;
		}
	});
	$(".sortType a.sort").click(function(){
		$(this).siblings().removeClass("sel");
		$(this).addClass("sel");
		if(em){
			$(this).find("em").html("∨");
			em=false;
		}
		else{
			$(this).find("em").html("∧");
			em=true;
		}
	});
	//图库
	$(".library .libSel p span").click(function(){
		$(this).parent().find(".sel").removeClass("sel");
		$(this).addClass("sel");
	});
	var libLen=$(".library .falls li").length;
	for(var i=0;i<libLen;i++){
		if(i%4==0){
			$(".library .falls li").eq(i).css("margin-left",0);
		}
	}
	//全景滚动
	var gindex=$(".gView .scrollpic li").length;
	for(var i=0;i<gindex;i++){
		$(".scrollindex").append("<li></li>")
	}
	$(".scrollindex li").eq(0).addClass("sel");
	var gi=0;
	setInterval(function(){
		$(".scrollpic li").eq(gi).fadeOut();
		$(".scrollindex li").eq(gi).removeClass("sel");
		gi+=1;
		if(gi==$(".gView .scrollpic li").length){gi=0}
		$(".scrollpic li").eq(gi).fadeIn();
		$(".scrollindex li").eq(gi).addClass("sel");
	},3000);
	//活动滚动
	for(var i=0;i<$(".active2 .scroll img").length;i++){
		$(".active2 .scrollI").append("<li></li>");
	}
	$(".active2 .scrollI li").eq(0).addClass("sel");
	var actIndex=0;
	$(".active2 .scrollI li").click(function(){
		$(".active2 .scroll img").eq(actIndex).fadeOut();
		$(".active2 .scrollI li").eq(actIndex).removeClass("sel");
		actIndex=$(this).index();
		$(".active2 .scroll img").eq(actIndex).fadeIn();
		$(".active2 .scrollI li").eq(actIndex).addClass("sel");
	});
	setInterval(function(){
		$(".active2 .scroll img").eq(actIndex).fadeOut();
		$(".active2 .scrollI li").eq(actIndex).removeClass("sel");
		actIndex+=1;
		if(actIndex==$(".active2 .scroll img").length){
			actIndex=0;
		}
		$(".active2 .scroll img").eq(actIndex).fadeIn();
		$(".active2 .scrollI li").eq(actIndex).addClass("sel");
	},3000);
	//全景
	$(".viewList .viewsel li").click(function(){
		$(".viewList .viewsel li").removeClass('sel');
		$(this).addClass("sel");
		$(".viewList .rs").css("display","none");
		$("#rs"+$(this).index()).css("display","block");
	});
	var viewi=0;
	
	$(".viewList .rs span").click(function(){
		$(".viewList .rs span").eq(viewi).removeClass("sel");
		viewi=$(this).index();
		$(this).addClass("sel");
	});
	for(var i=0;i<$(".viewList .listUl li").length;i++){
		if(i%4==0){
			$(".viewList .listUl li").eq(i).css("margin-left",0);
		}
	}
	$(".viewList .listUl li").hover(function(){
		$(this).addClass("sel");
	},function(){
		$(this).removeClass("sel");
	});
	//商场详情
	for(var i=0;i<$(".shopDetails .scroll img").length;i++){
		$(".shopDetails .scrollindex").append("<li></li>");
	}
	var sd=0;
	var t=4000;
	$(".shopDetails .scrollindex li").eq(0).addClass("sel");
	$(".shopDetails .scrollindex li").click(function(){
		$(".shopDetails .scroll img").fadeOut();
		$(".shopDetails .scrollindex li").removeClass("sel");
		sd=$(this).index();
		$(".shopDetails .scroll img").eq(sd).fadeIn();
		$(".shopDetails .scrollindex li").eq(sd).addClass("sel");
		t=4000;
	});
	setInterval(function(){
		
		$(".shopDetails .scroll img").eq(sd).fadeOut();
		$(".shopDetails .scrollindex li").eq(sd).removeClass("sel");
		sd+=1;
		if(sd==$(".shopDetails .scroll img").length){
			sd=0;
		}
		$(".shopDetails .scroll img").eq(sd).fadeIn();
		$(".shopDetails .scrollindex li").eq(sd).addClass("sel");
	},t);
	$(".shopDetails .shopYh> ul li").click(function(){
		var index=$(this).index();
		
		$(".shopDetails .shopYh> ul li").removeClass("sel");
		$(this).addClass("sel");

		$('ul[fs]').hide();
		$($('ul[fs]')[index]).show();
	});
//	for(var i=0;i<$(".shopDetails .commentImg img").length;i++){
//		if(i%5==0){
//			$(".shopDetails .commentImg img").eq(i).css("margin-left",0);
//		}
//	}
	//星星评分
	$(".commentArea .star img").click(function(){
		var sum=0;
		$(this).prevAll("img").attr("src","image/lian.jpg");
		$(this).attr("src","image/lian.jpg");
		$(this).nextAll("img").attr("src","image/hui.jpg");
		$(this).parent().attr("data-score",$(this).index());
		for(var i=0;i<$(this).parents(".star").find("li").length;i++){
			sum+=parseInt($(this).parents(".star").find("li").eq(i).attr("data-score"));
		}
		$(".df").find("span:first-child").html((sum/$(this).parents(".star").find("li").length).toFixed(2));
	});
	$(".commentArea textarea").click(function(){
		if($(this).val()=="请输入文本内容(文字不超过200字！)"){
			$(this).val("");
		}
	});
	for(var i=0;i<$(".shopDetails .shopactive li").length;i++){
		if(i%2==0){
			$(".shopDetails .shopactive li").eq(i).css("margin-left",0);
		}
	}
	//品牌详情
	for(var i=0;i<$(".bandLeft .picscroll img").length;i++){
		$(".bandLeft .picindex").append("<li></li>");
	}
	$(".bandLeft .picindex li").eq(0).addClass("sel");
	//自动滚播
	var bandi=0;
	$(".bandLeft .picindex li").click(function(){
		$(".bandLeft .picscroll img").eq(bandi).fadeOut();
		$(".bandLeft .picindex li").eq(bandi).removeClass("sel");
		bandi=$(this).index();
		$(".bandLeft .picscroll img").eq(bandi).fadeIn();
		$(".bandLeft .picindex li").eq(bandi).addClass("sel");
	});
	setInterval(function(){
		
		$(".bandLeft .picscroll img").eq(bandi).fadeOut();
		$(".bandLeft .picindex li").eq(bandi).removeClass("sel");
		bandi++;
		if(bandi==$(".bandLeft .picscroll img").length){
			bandi=0;
		}
		$(".bandLeft .picscroll img").eq(bandi).fadeIn();
		$(".bandLeft .picindex li").eq(bandi).addClass("sel");
	},4000);
	//
	for(var i=0;i<$(".bandDetails .tj li").length;i++){
		if(i%2!=0){
			$(".bandDetails .tj li").eq(i).css("margin-left",20+'px');
		}
	}
	//快捷留言
	$(".bandDetails .fastLy .define p").click(function(){
		$(this).parents(".fastLy").find("textarea").val($(this).html());
	});
	$(".bandDetails .bandmd div p span").click(function(){
		$(this).parent().find("span").removeClass("sel");
		$(this).addClass("sel");
	});
	
	//
	for(i=0;i<$(".active2 .actList .actDiv .tj li img").length;i++){
		if(i%2!=0){
			$(".active2 .actList .actDiv .tj li").eq(i).css("margin-left",14+'px');
		}
	}
	//
	var libIndex=0,libLeft=0,libLen=$(".libDetails .imgul li").length,viewI=0;
	$(".number").html(libLen);
	$(".cNum").html(libIndex+1);
	var path=$(".libDetails .imgul li:eq(0)").find("img").attr("src");
	$(".libDetails .viewimg>img").attr("src",path);
	$(".libDetails .viewimg #down").click(function(){
		libIndex+=1;
		libLeft=libIndex*118+libIndex*11;
		if(libIndex>=libLen-5){
			alert("已到最后");
			libIndex=libLen-5;
		}
		else{
			$(".libDetails .imgul").animate({left:-libLeft+'px'});
		}	
		
	});
	$(".libDetails .viewimg #up").click(function(){
		libIndex-=1;
		if(libIndex<0){
			alert("已到最前");
			libIndex=0;
		}
		else{
			libLeft=libIndex*118+libIndex*11;
			$(".libDetails .imgul").animate({left:-libLeft+'px'});
		}
	});
	$(".libDetails .imgul li").hover(function(){
		viewI=$(this).index();
		$(this).addClass("sel");
		path=$(this).find("img").attr("src");
		$(".libDetails .viewimg>img").attr("src",path);
		$(".cNum").html($(this).index()+1);
	},function(){
		$(this).removeClass("sel");
	});
	$(".previmg").click(function(){
		if(viewI==0){
			alert("已到最前!");
		}
		else{
			viewI-=1;
			path=$(this).siblings("div").find(".imgul li").eq(viewI).find("img").attr("src");
			$(".libDetails .viewimg>img").attr("src",path);
		}
	});
	$(".nextimg").click(function(){
		if(viewI==libLen-1){
			alert("已到最后!");
		}
		else{
			viewI+=1;
			path=$(this).siblings("div").find(".imgul li").eq(viewI).find("img").attr("src");
			$(".libDetails .viewimg>img").attr("src",path);
		}
	});
	///
	 for(var i=0;i<$(".viewInfo ul li").length;i++){
	 	if(i%3==0){
	 		$(".viewInfo ul li").eq(i).css("margin-left",0);
	 	}
	 }
	 for(var i=0;i<$(".libDetails>ul li").length;i++){
	 	if(i%4==0){
	 		$(".libDetails>ul li").eq(i).css("margin-left",0);
	 	}
	 }
	////店铺列表
	$(".dpList .select div span").click(function(){
		$(this).parent().find("span").removeClass("sel");
		$(this).addClass("sel");
	});
	//产品列表
	for(var i=0;i<$(".proList>ul li").length;i++){
	 	if(i%4==0){
	 		$(".proList>ul li").eq(i).css("margin-left",0);
	 	}
	 }
	$("#list li").hover(function(){
		$(this).addClass("sel");
	},function(){
		$(this).removeClass("sel");
	});
	//产品详情
	$(".proDetails .prodesc em").click(function(){
		$(".proDetails .prodesc em").removeClass("sel");
		$(this).addClass("sel");
	});
	//缩略图切换
	var smPath=$(".proDetails .proInfo ul li").eq(0).find("img").attr("src");
	$(".proDetails .smallimg").find("img").attr("src",smPath);
	$(".proDetails .bigimg").find("img").attr("src",smPath);
	$(".proDetails .proInfo ul li").click(function(){
		smPath=$(this).find("img").attr("src");
		$(".proDetails .smallimg").find("img").attr("src",smPath);
		$(".proDetails .bigimg").find("img").attr("src",smPath);
		$(".proDetails .bigimg img").css("left",0+'px');
		$(".proDetails .bigimg img").css("top",0+'px');
	});
	//产品详情放大镜
	
	$(".proDetails .smallimg").mousemove(function(e){
		var my=Math.round(e.pageY-$(this).offset().top);
		var mx=Math.round(e.pageX-$(this).offset().left);
		var imgw=$(".proDetails .bigimg").find("img").width();
		var imgh=$(".proDetails .bigimg").find("img").height();
		$(".proDetails .bigimg").css("display","block");
		$(".proDetails .area").css("display","block");
		$(".proDetails .area").css("left",mx+'px');
		$(".proDetails .area").css("top",my+'px');
		
		if((mx*990/380)<440){
			
			$(".proDetails .bigimg img").css("left",-mx+'px');
		
		}
		if((425-my*425/285)>285){
			$(".proDetails .bigimg img").css("top",-my+'px');
		}
	});
	$(".proDetails .smallimg").mouseout(function(){
		$(".proDetails .bigimg").css("display","none");
		$(".proDetails .area").css("display","none");
	});
	//切换
	$(".proDetails .proDiv div:first-child>ul li").click(function(){
		$(".proDetails .proDiv div:first-child>ul li").removeClass("sel");
		$(this).addClass("sel");
		if($(this).index()==2){
			$(".proDetails .result").fadeOut();
		}
		else{
			$(".proDetails .result").fadeOut();
			$(".proDetails #pro"+$(this).index()).fadeIn();
		}
	});
	
	//找回密码
	$(".pw .zh input").click(function(){
		$(this).val("");
	});
	//身份选择
	var identIndex;
	$(".identity>ul li").hover(function(){
		identIndex=$(this).index()+1;
		$(this).find("img").attr("src","image/pic_0"+identIndex+".jpg");
	},function(){
		$(this).find("img").attr("src","image/pic_"+identIndex+".jpg");
	});
	$(".identity p i").live('click',function(){
		$(this).siblings().removeClass("sel");
		$(this).addClass("sel");
	});
	//免费电话
	//$(".free .close").click(function(){
	//	$(".free").fadeOut();
	//	$(".smallFree").fadeIn();
	//});
	//$(".smallFree").click(function(){
	//	$(".free").fadeIn();
	//	$(".smallFree").fadeOut();
	//});
	//$(".transparent").css("height",H+'px');
	//$(".freecall").click(function(){
	//	$(".free").fadeOut();
	//	$(".transparent").fadeIn();
	//});
	//$(".transparent .close").click(function(){
	//	$(".free").fadeIn();
	//	$(".transparent").fadeOut();
    //});

    // 悬浮框鼠标移入移出
	$(".fixed_index>div").find("a").each(function (index, val) {
	    if (index == 2) {
	        $(this).mouseenter(function () {
	            $(this).children("img").attr("src", "/images/icon/gwc.png");
	        });
	    } else {
	        $(val).mouseenter(function () {
	            $(this).children("img").attr("src", "/images/icon/coin" + (index + 1) + ".png");
	        });
	    }
	});
	$(".fixed_index>div").find("a").each(function (index, val) {
	    var arr = ["my", "yhqx", "gwc", "hj"];
	    $(val).mouseleave(function () {
	        $(this).children("img").attr("src", "/images/icon/" + arr[index] + ".png");
	    });
	});

	//首页悬浮
	//$(".fixed_index a").hover(function () {
	//    if ($(this).index() == 0) {
	//        $(this).find("img").attr("src", "../images/index/my" + 2 + ".png");
	//    }
	//    if ($(this).index() == 1) {
	//        $(this).find("img").attr("src", "../images/index/yhqx" + 2 + ".png");
	//    }
	//    if ($(this).index() == 2) {
	//        $(this).find("img").attr("src", "../images/index/scj2" + 2 + ".png");
	//    }
	//    if ($(this).index() == 3) {
	//        $(this).find("img").attr("src", "../images/index/hj" + 2 + ".png");
	//    }
	//    $(this).css("color", "#41CCB4");

	//}, function () {
	//    if ($(this).index() == 0) {
	//        $(this).find("img").attr("src", "../images/index/my.png");
	//    }
	//    if ($(this).index() == 1) {
	//        $(this).find("img").attr("src", "../images/index/yhqx.png");
	//    }
	//    if ($(this).index() == 2) {
	//        $(this).find("img").attr("src", "../images/index/scj2.png");
	//    }
	//    if ($(this).index() == 3) {
	//        $(this).find("img").attr("src", "../images/index/hj.png");
	//    }
	//    $(this).css("color", "#666");
	//});
	$(".backTop").click(function(){
		var st=document.body.scrollTop||document.documentElement.scrollTop;
		var id=null;
		if(st!=0){
			id=setInterval(function(){
				st-=500;
				if(st<=0){clearInterval(id);st=0}
				document.body.scrollTop=st;
				document.documentElement.scrollTop=st;
			},10);
		}	
	});
	//品牌
//	var floorT=$(".floor1").offset().top;
//	$(".fixed_band").css("top",floorT-200+'px');
	$(".fixed_band a").not(".backTop").hover(function(){
		switch ($(this).index()){
			case 0:
				$(this).html("实木");
				break;
			case 1:
				$(this).html("软体");
				break;
			case 2:
				$(this).html("板式");
				break;
			case 3:
				$(this).html("欧美");
				break;
			case 4:
				$(this).html("儿童");
				break;
			case 5:
				$(this).html("红木");
				break;
			case 6:
				$(this).html("户外");
				break;
			case 7:
				$(this).html("其他");
				break;
		}
		$(this).addClass("sel");
	},function(){
		switch ($(this).index()){
			case 0:
				$(this).html("1F");
				break;
			case 1:
				$(this).html("2F");
				break;
			case 2:
				$(this).html("3F");
				break;
			case 3:
				$(this).html("4F");
				break;
			case 4:
				$(this).html("5F");
				break;
			case 5:
				$(this).html("6F");
				break;
			case 6:
				$(this).html("7F");
				break;
			case 7:
				$(this).html("8F");
				break;
		}
		$(this).removeClass("sel");
	});
	//品牌详情
	if($(".shopDetails ul.jmly li").length>=3){
		jmscroll();
	}
	function jmscroll(){
		var st=0;
		setInterval(function(){
			st++;
			$(".shopDetails ul.jmly").animate({top:-st+'px'},50,function(){
				if(st==86){
					st=0;
					$(".shopDetails ul.jmly li").first().insertAfter($(".shopDetails ul.jmly li").last());
					$(".shopDetails ul.jmly").css("top",0);
				}
			});
		},100);
	}
	function zoom(){
		var len,path,index,obj;
		$(".zoom img").live('click',function(){
			obj=$(this).parents("li").index();
			len=$(this).parent().find("img").length;
			index=$(this).index();
			path=$(this).attr("src");
			$(".commendBg").css("display","block");
			$(".commendBg>div").css("top",(H-441)/2+'px');
			$(".commendBg>span").css("top",(H-49)/2+'px');
			$(".commendBg>div img").attr("src",path);
		});
		$(".commendBg>span").hover(function(){
			$(this).addClass("sel");
		},function(){
			$(this).removeClass("sel");
		});
		$(".commendBg .prev").click(function(){
			index--;
			if(index<0){
				index=len-1;
			}
			path=$("ul.comment>li").eq(obj).find(".zoom img").eq(index).attr("src");
			$(".commendBg>div img").attr("src",path);
		});
		$(".commendBg .next").click(function(){
			index++;
			if(index>len-1){
				index=0;
			}
			path=$("ul.comment>li").eq(obj).find(".zoom img").eq(index).attr("src");
			$(".commendBg>div img").attr("src",path);
		});
		$(".commendBg .close").click(function(){
			$(".commendBg").fadeOut();
		});
		
	}
	zoom();
	function bandimg(){
		var len=$(".shopDetails .bandimg ul li").length;
		$(".shopDetails .bandimg ul").css("width",len*224+(len-1)*20+'px');
		var left=0;
		var id;
		function sc(){
			
			id=setInterval(function(){
				left--;
				$(".shopDetails .bandimg ul").animate({left:left+'px'},10,function(){
					if(left==-244){
						left=0;
						$(".shopDetails .bandimg ul li").first().insertAfter($(".shopDetails .bandimg ul li").last());
						$(".shopDetails .bandimg ul").css("left",0);
					}
				});
			},50);
		}
		sc();
		$(".shopDetails .bandimg ul").hover(function(){
			clearInterval(id);
		},function(){
			sc();
		});
	}
	bandimg();
	//优惠券详情
	$(".active2 .actList .record div p").click(function () {

		$(this).siblings().removeClass("sel");
		$(this).addClass("sel");
		if($(this).index()==0){
			$(".active2 .actList .record ul.dp").css("display","none");
			$(".active2 .actList .record ul.ly").css("display","block");
		}
		else{
			$(".active2 .actList .record ul.ly").css("display","none");
			$(".active2 .actList .record ul.dp").css("display","block");
		}
	});
	////
	$(".dpList .sortType span").click(function(){
		$(this).siblings().removeClass("sel");
		$(this).addClass("sel");
	});
	//////////////////////
	$(".shopContainer .products .rightArea .proUl li").hover(function(){
		$(this).addClass("sel");
	},function(){
		$(this).removeClass("sel");
	});
	/////////全景详情
	function sq(){
		var t=true;
		$(".sq").click(function(){
			if(t){
				t=false;
				$(".viewMenu").animate({right:-190+'px'},50);
				$(".sq").animate({right:0+'px'},50);
				$(this).html("<");
			}
			else{
				t=true;
				$(".viewMenu").animate({right:0+'px'},50);
				$(".sq").animate({right:190+'px'},50);
				$(this).html(">");
			}
		});
	}
	sq();
	///礼品
	function giftScroll(){
		var len=$("#gift").find("img").length;
		var i=0,id;
		for(var j=0;j<len;j++){
			$(".gift .giftScroll ul").append("<li></li>");
		}
		$(".gift .giftScroll ul li").eq(i).addClass("sel");
		$(".gift .giftScroll ul li").live('click',function(){
			clearInterval(id);
			$("#gift").find("img").eq(i).fadeOut();
			$(".gift .giftScroll ul li").eq(i).removeClass("sel");
			i=$(this).index();
			$("#gift").find("img").eq(i).fadeIn();
			$(".gift .giftScroll ul li").eq(i).addClass("sel");
			giftzoom();
		});
		function giftzoom(){
			id=setInterval(function(){
				$("#gift").find("img").eq(i).fadeOut();
				$(".gift .giftScroll ul li").eq(i).removeClass("sel");
				i+=1;
				if(i>=len){i=0}
				$("#gift").find("img").eq(i).fadeIn();
				$(".gift .giftScroll ul li").eq(i).addClass("sel");
			},3000);
		}
		giftzoom();
	}
	giftScroll();
	function exchange(){
		var t=0;
		setInterval(function(){
			t++;
			$(".gift .giftDiv .giftRight>div .zh ul").animate({top:-t+'px'},50,function(){
				if(t>=84){
					$(".gift .giftDiv .giftRight>div .zh ul li").first().insertAfter($(".gift .giftDiv .giftRight>div .zh ul li").last());
					$(".gift .giftDiv .giftRight>div .zh ul").css("top",0);
					t=0;
				}
			});
		},100);
	}
	if($(".gift .giftDiv .giftRight>div .zh ul li").length>6){
		exchange();
	}
	$(".gift .giftDiv .giftDetail .introduce p span").click(function(){
		var i=$(this).index();
		$(this).siblings().removeClass("sel");
		$(this).addClass("sel");
		$(".gift .giftDiv .giftDetail .introduce div").css("display","none");
		$(".gift .giftDiv .giftDetail .introduce div").css("display","none");
		$(".gift .intro"+(i+1)).css("display","block");
	});
	//
	$(".falls li div").hover(function(){
		$(this).find("span").css("display","block")
	},function(){
		$(this).find("span").css("display","none")
	});
	//品牌图库
	function libScroll(lib){
		var lib,path,len,obj;
		$(".bandLibrary .libDiv>div ul li").click(function () {
		    
			obj=$(this).parent();
			len=$(this).parent().find("li").length;
			$(".transparent").css("display","block");
			$(".commendBg>div").css("top",(H-441)/2+'px');
			$(".commendBg>span").css("top",(H-49)/2+'px');
			lib=$(this).index();
			path=$(this).find("img").attr("src");
			$(".transparent img").attr("src",path);
		});
		$(".commendBg>span").hover(function(){
			$(this).addClass("sel");
		},function(){
			$(this).removeClass("sel");
		});
		$(".commendBg .prev").click(function(){
			lib--;
			if(lib<0){
				lib=len-1;
			}
			path=obj.children().eq(lib).find("img").attr("src");
			$(".commendBg>div img").attr("src",path);
		});
		$(".commendBg .next").click(function(){
			lib++;
			if(lib>len-1){
				lib=0;
			}
			path=obj.children().eq(lib).find("img").attr("src");
		
			$(".commendBg>div img").attr("src",path);
		});
		$(".commendBg .close").click(function(){
			$(".commendBg").fadeOut();
		});
	}
	libScroll();

    /*2016-1-31*/
	$(".showEwm img").hover(function () {
	    $(".prodesc .ewm").fadeIn();
	}, function () {
	    $(".prodesc .ewm").fadeOut();
	});
});
