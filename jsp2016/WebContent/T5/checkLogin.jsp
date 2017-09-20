<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.net.URLEncoder"%>
<%
	//乱码处理
	request.setCharacterEncoding("utf-8");
	//获取参数
	out.println("username="+request.getParameter("username")+"<br/>");
	out.println("password="+request.getParameter("password")+"<br/>");
	out.println("remember="+request.getParameter("remember")+"<br/>");
	out.println("btnReg="+request.getParameter("btnReg")+"<br/>");
	out.println("btnLogin="+request.getParameter("btnLogin")+"<br/>");
	out.println("<hr/>");
	
	Enumeration enums = request.getAttributeNames();
	while(enums.hasMoreElements()){
		String name = enums.nextElement().toString();//获取变量名称
		out.println(name+"="+request.getParameter(name)+"<br/>");
	}
	out.println("<hr/>");
	
		//如果多选框没有勾选无法获取值
    	String remember = request.getParameter("remember");
    	
    	if(remember!=null && remember.equals("1")){ 
	    	String username = request.getParameter("username");
	    	String password = request.getParameter("password");
	    	//保存登录信息到cookie
	    	//cookie是保存在客户端的游览器，是放在本地的一个文本文件，经过加密处理
	    	//当有中文时必须进行编码处理，否则不能保存
	    	Cookie cookie1 = new Cookie("username",URLEncoder.encode(username));
	    	Cookie cookie2 = new Cookie("password",URLEncoder.encode(password));
	    	//设置一天的有效期,单位是秒
			cookie1.setMaxAge(24*60*60);
			//设置一天的有效期
			cookie2.setMaxAge(24*60*60);
	    	System.out.println(cookie1.getName()+"="+cookie1.getValue());
	    	System.out.println(cookie2.getName()+"="+cookie2.getValue());
	    	//设置保存路径
	    	cookie1.setPath(request.getContextPath());
	    	cookie2.setPath(request.getContextPath());
	    	response.addCookie(cookie1);
	    	response.addCookie(cookie2);
	}
%>