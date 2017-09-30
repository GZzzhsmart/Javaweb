<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	Map map = new HashMap();
	String d1 = "<member><id>1001</id><name>成员一</name></member><member><id>1002</id><name>成员二</name></member>";
	String d2 = "<member><id>1003</id><name>成员三</name></member><member><id>1004</id><name>成员四</name></member>";
	String d3 = "<member><id>1005</id><name>成员五</name></member><member><id>1006</id><name>成员六</name></member>";
	String d4 = "<member><id>1007</id><name>成员七</name></member><member><id>1008</id><name>成员八</name></member>";
	map.put("d1",d1);
	map.put("d2",d2);
	map.put("d3",d3);
	map.put("d4",d4);
	
	String depart = request.getParameter("depart");
	if(depart==null) depart = "d1";
	StringBuffer sb = new StringBuffer();
	sb.append("<members>");	
	sb.append(map.get(depart).toString());
	sb.append("</members>");
	out.write("<?xml version='1.0' encoding='utf-8' ?>");
	out.write(sb.toString());
%>

