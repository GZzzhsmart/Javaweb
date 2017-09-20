<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
	String yhbh = request.getParameter("yhbh");
	String yhbhs="";
	Cookie cookies[]=request.getCookies();
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			Cookie c = cookies[i];
			if(c.getName().equals("yhbhs")){
				//解码操作URLDecoder.decode();
				yhbhs=URLDecoder.decode(c.getValue());//获取cookie的值
			}
		}
	}
	Hashtable ht = new Hashtable();
	String tempbh = yhbhs;
	while(tempbh!=null && !tempbh.equals("")){
		String uid = tempbh.substring(0,8);
		ht.put(uid,uid);
		tempbh = tempbh.substring(8);
	}
	Object obj = ht.get(yhbh);
	if(obj ==null){
		yhbhs = yhbh+yhbhs;
	}
	if(yhbhs.length()>40){
		yhbhs = yhbhs.substring(0,40);
	}
   	Cookie cookie1 = new Cookie("yhbhs",URLEncoder.encode(yhbhs));
   	cookie1.setPath(request.getContextPath());
   	response.addCookie(cookie1);
%>