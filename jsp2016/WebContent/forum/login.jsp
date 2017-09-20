<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>胡歌聊天室</title>
    
	
	<script type="text/javascript">
		function check(){
			if(form1.nickname.value==""){
				alert("请输入昵称");
				form1.nickname.focus();
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body>
  <%
  	//乱码处理
  	request.setCharacterEncoding("utf-8");
  	//点击了登录按钮才能运行以下代码
  	if(request.getParameter("btnLogin")!=null){
	  	String nickname=request.getParameter("nickname");
	  	if(application.getAttribute("allUser")==null){
	  		//1.创建session,代表自己的身份
	  		session.setAttribute("nickname",nickname);
	  		//2.保存到application中，让其他在线用户可以看到；
	  		Hashtable<String,String> ht_allUser = new Hashtable<String,String>();
	  		ht_allUser.put(nickname,nickname);
	  		application.setAttribute("allUser",ht_allUser);
	  		//3.保存聊天内容application变量
	  		String str = "欢迎【"+nickname+"】登录胡歌聊天室！<br/>";
	  		application.setAttribute(nickname,str);
	  		//4.进入聊天界面
	  		response.sendRedirect("main.jsp");
	  	}else{
	  		//1.获取所有在线用户的信息
	  		Hashtable<String,String> ht_allUser = (Hashtable<String,String>)application.getAttribute("allUser");
	  		//控制聊天室的总认识不能超过50个;
	  		if(ht_allUser.size()>49){
	  		%>
	  			<script type="text/javascript">
	  				alert("人满为患，请稍后再来！");
	  			</script>
	  		<%
	  		}else{
		  		//2.判断昵称是否已经存在;
		  		String myName = ht_allUser.get(nickname);
		  		if(myName==null){
		  			//3.创建session,代表自己的身份
	  				session.setAttribute("nickname",nickname);
		  			//4.保存到application中，让其他在线用户可以看到；
		  			ht_allUser.put(nickname,nickname);
		  			application.setAttribute("allUser",ht_allUser);
		  			//5.保存聊天内容application变量
			  		String str = "欢迎【"+nickname+"】登录胡歌聊天室！<br/>";
			  		System.out.println(str);
			  		application.setAttribute(nickname,str);
			  		//6.进入聊天界面
	  				response.sendRedirect("main.jsp");
		  		}else{
		  		%>
		  			<script type="text/javascript">
		  				alert("昵称已经存在，请输入其他昵称");
		  			</script>
		  		<%
		  		}
	  		}
	  	}
  	}
   %>
  	<br/><br/><br/><br/>
    <h1 align="center"><b><i><font color="cyan">胡歌聊天室</font></i></b></h1>
    <hr/>
	<form name="form1" action="forum/login.jsp" method="post" onsubmit="return check();">
		<center>
			请输入昵称：<input type="text" name="nickname" id="nickname">
			<input type="submit" value=" 登 录 " name="btnLogin">
		</center>
	</form>
  </body>
</html>
