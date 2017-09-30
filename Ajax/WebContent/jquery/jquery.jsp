<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jQuery类库的应用</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.js"></script>

  </head>
  
  <body>
    <h1 align="center">jQuery类库的应用</h1>
    <hr/>
    <ul>
    	<li id="li1">1111111</li>
    	<li class="li2">2222222</li>
    	<li name="li3">3333333</li>
    	<li aaa="li4">4444444</li>
    	<li bbb="li5">5555555</li>
    	<li>6666666</li>
    	<li>7777777</li>
    </ul>
    <input type="button" value="测试" id="btnTest"/>
    <script type="text/javascript">
		/*
			获取id属性的值 $("#id");
			获取class属性的值 $(".id");
			获取其他属性的值 $("[xxx=yyyy]");
		
		*/    
		//在jQuery中获取标签的值用text()函数
    	$("#li1").click(
    		function(){
    			//取值
 	   			alert($("#li1").text());
 	   			//更改值
 	   			//$("#li1").text("li1更改之后的值");
    		}	
    	);
    	$(".li2").click(
    		function(){
    			alert($(".li2").text());
    		}
    	);
    	$("[name=li3]").click(
    		function(){
    			alert($("[name=li3]").text());
    		}
    	);
    	$("[aaa=li4]").click(
    		function(){
    			alert($("[aaa=li4]").text());
    		}
    	);
    	
    	
    	$("#btnTest").click(
    		function(){
    			/*
    			$("ul li").each(
    				function(i,v){
    					alert(i+":"+$(v).text());
    				}
    			);
    			*/
    			//取索引为偶数的行
    			$("ul li:even").each(
    				function(i,v){
    					alert($(v).text());
    					$(v).css("background","#00ff00");
    				}
    			);
    			
    			//取索引为奇数的行
    			$("ul>li:odd").each(
    				function(i,v){
    					$(v).text($(v).text()+"888");
    					$(v).css("background","#0088ff");
    					$(v).css("cursor","pointer");
    				}
    			);
    			//选中带有contains里面关键字的行，与其他的颜色区分开来
    			$("li:contains('444')").css("background","#ff2888");
    		}
    	);
    </script>
  </body>
</html>
