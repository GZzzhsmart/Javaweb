<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="T6.Student" %>
<html>
  <head>
    <title>javabean的调用</title>
  </head>
  
  <body>
  	<h1 align="center">javabean的调用</h1>
  	<hr/>
  	<%
  		Student stud = new Student();
  		stud.setStudid(1001);
  		stud.setStudName("小赖子");
  		stud.setAge(18);
  		stud.setClassName("16秋宏图1班");
  		stud.setMarry(false);
  		stud.setSex("男");
  		String ho[] = {"上网","看书","旅游"};
  		stud.setHobit(ho);
  	 %>
  	 
  	 学号：<%=stud.getStudid() %><br/>
  	 姓名：<%=stud.getStudName() %><br/>
  	 年龄：<%=stud.getAge() %><br/>
  	 性别：<%=stud.getSex() %><br/>
  	 班级：<%=stud.getClassName() %><br/>
  	 <%
  	 	String hob = "";
  	 	for(int i=0;i<stud.getHobit().length;i++){
  	 		hob+=stud.getHobit(i)+",";
  	 	}
  	  %>
  	  兴趣爱好：<%=hob %><br/>
  	  婚姻状况：<%=stud.isMarry() %><br/>
  </body>
</html>
