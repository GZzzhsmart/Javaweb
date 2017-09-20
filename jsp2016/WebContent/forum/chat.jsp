<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'chat.jsp' starting page</title>
  </head>
  
  <body bgcolor="#00ff88">
  <%
  		request.setCharacterEncoding("utf-8");
  		if(request.getParameter("btnSend")!=null){
  			//设置字体
  			String face = request.getParameter("face");
  			//设置颜色
  			String color = request.getParameter("color");
  			//设置字体大小
  			String fontsize = request.getParameter("fontsize");
  			//设置和谁聊天
  			String who = request.getParameter("who");
  			String chatmsg = request.getParameter("chatmsg");
  			//发给所有人
  			String msg = "<font size="+fontsize+" color="+color+">";
  			msg += "【<b>"+session.getAttribute("nickname")+"</b>】"+face+"对";
  			if(who.equals("all")){
  				msg += "【<b>所有人</b>】说："+chatmsg+"</font><br/>";
				Hashtable<String,String> ht_allUser = (Hashtable<String,String>)application.getAttribute("allUser");
			  	if(ht_allUser !=null){
			  		Set set = ht_allUser.keySet();
			  		Iterator<String> it = set.iterator();
			  		String key="";
			  		while(it.hasNext()){
			  			key = it.next();
			  			//获取原来的聊天内容;
			  			String s = application.getAttribute(key).toString();
			  			s += msg;
			  			application.setAttribute(key,s);
			  		}
			  	}
				
  			}else{//私聊
   				msg += "【<b>"+who+"</b>】说："+chatmsg+"</font><br/>";
   				String s = application.getAttribute(who).toString();
	  			s += msg;
	  			application.setAttribute(who,s);
 	  			application.setAttribute(session.getAttribute("nickname").toString(),s);
  			}
  		}
   %>
    <form action="forum/chat.jsp" name="form1" method="post" >
    	<table align="center">
    		<tr>
    			<td>
    				<select name="face" style="width:150px">
    					<option value="神采奕奕">神采奕奕</option>
    					<option value="表情忧伤">表情忧伤</option>
    				</select>
    				<select name="fontsize" style="width:150px">
    					<option value="1">1</option>
    					<option value="2">2</option>
    					<option value="3">3</option>
    					<option value="4">4</option>
    					<option value="5">5</option>
    					<option value="6">6</option>
    					<option value="7">7</option>
    				</select>
    				<select name="color" style="width:150px">
    					<option value="red">红色</option>
    					<option value="pink">粉红</option>
    					<option value="green">绿色</option>
    					<option value="blue">蓝色</option>
    					<option value="yellow">黄色</option>
    				</select>
    				<select name="who" style="width:150px">
    					<option value="all">所有人</option>
    					<%
    					Hashtable<String,String> ht_allUser = (Hashtable<String,String>)application.getAttribute("allUser");
					  	if(ht_allUser !=null){
					  		Set set = ht_allUser.keySet();
					  		Iterator<String> it = set.iterator();
					  		String key="";
					  		while(it.hasNext()){
					  			key = it.next();
					  			//把自己排除在列表之外
					  			if(!key.equals(session.getAttribute("nickname"))){
					  			%>
					  				<option value="<%=key%>"><%=key%></option>
					  			<%
					  			}
					  		}
					  	}
    					 %>
    				</select>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<textarea rows="4" cols="100" name="chatmsg"></textarea>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">
    				<input type="submit" name="btnSend" value=" 发 送 ">
    			</td>
    		</tr>
    	</table>
    </form>
    
  </body>
</html>
