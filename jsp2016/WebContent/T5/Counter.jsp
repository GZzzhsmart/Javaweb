<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	if(session.isNew()){
		synchronized(application){
			Integer count = (Integer)application.getAttribute("count");
			if(count==null){
				count = new Integer(1);
				application.setAttribute("count",count);
			}else{
				count = new Integer(count.intValue()+1);
				application.setAttribute("count",count);
			}
			out.println("你是T5的第"+count+"个访问者");
		}
	}
	
%>