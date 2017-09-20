<%@ page contentType="text/html;charset=utf-8"%>

  	<%
  		String s = (String)request.getAttribute("n");
  		if(s!=null){
  			int n = Integer.parseInt(s);
  			int num=0;
  			for(int i=0;i<=n;i++){
  				num=num+i;
  			}
  			out.println("累加和为："+num);
  		}else{
  			out.println("请确定n的值");
  		}
  	 %>
  