<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>购买的结果</title>
  </head>
  <body>
  	<p>您好！<%=session.getAttribute("username") %></p><br/>
  	<p>您订购的商品如下：</p><br/>
  	<%
  		int a1=30,a2=50,a3=40;
  		Object id1 = application.getAttribute("s1");
  		Object id2 = application.getAttribute("s2");
  		Object id3 = application.getAttribute("s3");
  		Object str1 = application.getAttribute("p1");
  		double g1 = Double.parseDouble(str1.toString());
  		Object str2 = application.getAttribute("p2");
  		double g2 = Double.parseDouble(str2.toString());
  		Object str3 = application.getAttribute("p3");
  		double g3 = Double.parseDouble(str3.toString());
  		String num1 = request.getParameter("num1");
  		String num2 = request.getParameter("num2");
  		String num3 = request.getParameter("num3");
  		session.setAttribute("num1",num1);
  		session.setAttribute("num2",num2);
  		session.setAttribute("num3",num3);
  		Object m1 = session.getAttribute("num1");
  		int n1 = Integer.parseInt(m1.toString());
  		Object m2 = session.getAttribute("num2");
  		int n2 = Integer.parseInt(m2.toString());
  		Object m3 = session.getAttribute("num3");
  		int n3 = Integer.parseInt(m3.toString());
  		if(n1!=0){
  			out.println(id1.toString()+""+"价格为："+str1.toString()
  			+""+"购买数量："+m1.toString()+"<br/>");
  		}else{
  			out.println();
  		}
  		if(n2!=0){
  			out.println(id2.toString()+""+"价格为："+str2.toString()
  			+""+"购买数量："+m2.toString()+"<br/>");
  		}else{
  			out.println();
  		}
  		if(n3!=0){
  			out.println(id3.toString()+""+"价格为："+str3.toString()
  			+""+"购买数量："+m3.toString()+"<br/>");
  		}else{
  			out.println();
  		}
  	 %>
  	 <p>C语言需要支付<%=g1*n1 %>元，C语言库存还剩下：<%=a1-n1 %>本</p>
  	 <p>Java程序设计需要支付<%=g2*n2 %>元，Java程序设计还剩下：<%=a2-n2 %>本</p>
  	 <p>javascript需要支付<%=g3*n3 %>元，javascript还剩下：<%=a3-n3 %>本</p>
  	 <p>您需要支付的总金额是：<%=g1*n1+g2*n2+g3*n3 %>元</p>
  </body>
</html>
