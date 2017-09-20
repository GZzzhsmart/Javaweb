$(function(){
				window.onload=function(){
//					var scroll=document.getElementById("scroll");
//					var li=scroll.getElementsByTagName("li")[0];
//					var len=$("#scroll li").length;
//					//添加小圆点按钮
//					for(var i=0;i<len;i++){
//						$("#scroll_control").append("<li></li>")
//					}
//					$("#scroll_control li:eq(0)").addClass("sel");
//					//图片淡入淡出
//					li.getElementsByTagName("img")[0].style.left=0+'px';
//					li.getElementsByTagName("img")[1].style.right=0+'px';
//					var index=1,n=1;
					//索引点击事件
					$("#scroll_control li").live('click',function(){
						var current=$(this).index();
						//添加选中样式
						$("#scroll_control li").removeClass("sel");
						$("#scroll_control li:eq("+current+")").addClass("sel");
						//图片跳转
						$("#scroll li").fadeOut("fast");
						$("#scroll li:eq("+current+")").fadeIn("fast");
						if(current==3){
							index=0;
						}
						else{index=current;}
						//图片浮动效果
						n=current;
						$("#scroll li").find("img:nth-child(1)").css("left",-10+'px');
						$("#scroll li").find("img:nth-child(2)").css("right",-10+'px');
						$("#scroll li:eq("+n+")").find("img:nth-child(1)").animate({left:0+'px'});
						$("#scroll li:eq("+n+")").find("img:nth-child(2)").animate({right:0+'px'});
					});
//					setInterval(auto,4000);
//					function auto(){
//						$("#scroll_control li").removeClass("sel");
//						$("#scroll_control li:eq("+n+")").addClass("sel");
//						$("#scroll li").find("img:nth-child(1)").css("left",-10+'px');
//						$("#scroll li").find("img:nth-child(2)").css("right",-10+'px');
//						$("#scroll li:eq("+n+")").find("img:nth-child(1)").animate({left:0+'px'});
//						$("#scroll li:eq("+n+")").find("img:nth-child(2)").animate({right:0+'px'});
//						$("#scroll li").fadeOut("fast");
//						$("#scroll li:eq("+index+")").fadeIn("fast");
//						index++;
//						n++;
//						if(n==3){n=0}
//						if(index==3){
//							index=0;
//						}
					
				}
				
				//品牌栏目滚动
				var len2=$(".band .middleDiv ul li").length;
				var bandT,bandN;
				var index2=0;
				var bandImg=$(".band .middleDiv ul li");
				var bandP=$(".band .middleDiv>p");
				bandImg.eq(index2).find(".desc").animate({left:20+'px'},1000);
				//添加索引
				for(var i=0;i<len2;i++){
					bandP.append("<span></span>")
				}
				bandP.find("span").eq(0).addClass("sel");
//				//点击索引
				bandP.find("span").click(function(){
					clearInterval(bandT);
					bandN=$(this).index();
				
					bandImg.eq(index2).fadeOut();
					bandP.find("span").eq(index2).removeClass("sel");
					bandImg.eq(index2).find(".desc").css("left",-192+'px');
					bandImg.eq(bandN).fadeIn();
					bandP.find("span").eq(bandN).addClass("sel");
					console.log(bandImg.eq(bandN).find(".desc"))
					bandImg.eq(bandN).find(".desc").animate({left:20+'px'},1000);
					index2=bandN;
					bandscroll1();
				});
				
				
				function bandscroll1(){
					bandT=setInterval(function(){
					    bandImg.eq(index2).fadeOut();
					    bandP.find("span").eq(index2).removeClass("sel");
					    bandImg.eq(index2).find(".desc").css("left",-192+'px');
					     if(index2==(len2-1)){
							index2=-1;
						}
					    bandImg.eq(index2+1).fadeIn();
					    bandP.find("span").eq(index2+1).addClass("sel");
					    bandImg.eq(index2+1).find(".desc").animate({left:20+'px'},1000);
					    index2+=1;
					},4000);
				}
				bandscroll1();
				//品牌栏目右侧广告切换
				var index3=0;
				var rightad=$(".band .rightDiv ul li");
				var len3=rightad.length;
				$("#next").click(function(){
					index3+=1;
					rightad.fadeOut();
					if(index3==len3){
						index3=0;
					}
					rightad.eq(index3).fadeIn();
				});
				$("#prev").click(function(){
					
					if(index3==0){
						index3=len3;
					}
					index3-=1;
					rightad.fadeOut();
					rightad.eq(index3).fadeIn();
				});
				/////////////
				function couponScroll(){
					var i=0;
					var len=$("#js_banner .couponScroll ul li").length;
					$("#js_banner .right").live('click',function(){
						$("#js_banner .couponScroll ul li").eq(i).fadeOut()
						i+=1;
						if(i>len-1){i=0}
						$("#js_banner .couponScroll ul li").eq(i).fadeIn()
					});
					$("#js_banner .left").live('click',function(){
						$("#js_banner .couponScroll ul li").eq(i).fadeOut()
						i-=1;
						if(i<0){i=len-1}
						$("#js_banner .couponScroll ul li").eq(i).fadeIn()
		
					});
				}
				couponScroll();
			});