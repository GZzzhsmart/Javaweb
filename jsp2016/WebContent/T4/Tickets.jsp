<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>网上投票</title>
  </head>
  <body>
    <h1 align="center">市民生活水平调查</h1>
    <hr/>
    <form name="form1" action="Tickets.jsp" method="post">
    	<input type="radio" name="ticket" value="1" checked>1500元以下<br/>
    	<input type="radio" name="ticket" value="2">1500-3000<br/>
    	<input type="radio" name="ticket" value="3">3000-5000<br/>
    	<input type="radio" name="ticket" value="4">5000元以上<br/>
    	<input type="submit" value=" 投 票 " name="btnTicket">
    </form>
    <%
    	float t1,t2,t3,t4,total=0;
    	int divwidth=300;//100%的宽度
    	t1=t2=t3=t4=0;
 		Hashtable<String,Float> ht_ticket = null;
 		//判断有没有点击了投票按钮
    	if(request.getParameter("btnTicket")!=null){
    		//获取投票结果
    		String val = request.getParameter("ticket");
    		//判断是不是第一次投票；还没有人投票application变量就为空
    		if(application.getAttribute("ticket")==null){
    			ht_ticket = new Hashtable<String,Float>();
    			ht_ticket.put("1",0f);
    			ht_ticket.put("2",0f);
    			ht_ticket.put("3",0f);
    			ht_ticket.put("4",0f);
    			ht_ticket.put(val,1f);
    			//把Hashtable保存到application中
    			application.setAttribute("ticket",ht_ticket);
    		}else{
    			ht_ticket=(Hashtable<String,Float>)application.getAttribute("ticket");
    			t1 = ht_ticket.get("1");
    			t2 = ht_ticket.get("2");
    			t3 = ht_ticket.get("3");
    			t4 = ht_ticket.get("4");
    			if(val.equals("1")){
    				t1++;
    			}else if(val.equals("2")){
    				t2++;
    			}else if(val.equals("3")){
    				t3++;
    			}else if(val.equals("4")){
    				t4++;
    			}
    			ht_ticket.put("1",t1);
    			ht_ticket.put("2",t2);
    			ht_ticket.put("3",t3);
    			ht_ticket.put("4",t4);
    			application.setAttribute("ticket",ht_ticket);
    			total = t1+t2+t3+t4;//总的票数
    			t1=t1/total*300; //计算出来的是div的宽度
    			t2=t2/total*300;
    			t3=t3/total*300;
    			t4=t4/total*300;
    		}
    	}
     %>
    <table width="600" border="0">
    	<caption>总共投票人数是：<%=(int)total%>人</caption>
    	<tr>
    		<td width="120" align="right">1500元以下</td>
    		<td><div id="id1" style="width:<%=t1%>px;height:20px;background:#ff0000;text-align:center;"><%=(int)(t1/3)%>%</div></td>
    	</tr>
    	<tr>
    		<td width="120" align="right">1500-3000</td>
    		<td><div id="id2" style="width:<%=t2%>px;height:20px;background:#ff0000;text-align:center;"><%=(int)(t2/3)%>%</div></td>
    	</tr>
    	<tr>
    		<td width="120" align="right">3000-5000</td>
    		<td><div id="id3" style="width:<%=t3%>px;height:20px;background:#ff0000;text-align:center;"><%=(int)(t3/3)%>%</div></td>
    	</tr>
    	<tr>
    		<td width="120" align="right">5000元以上</td>
    		<td><div id="id4" style="width:<%=t4%>px;height:20px;background:#ff0000;text-align:center;"><%=(int)(t4/3)%>%</div></td>
    	</tr>
    </table>
  </body>
</html>
