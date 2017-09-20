<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="chat.MessageBiz"%>
<%@page import="chat.Message"%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>留言板系统</title>  
     <script>  
        function check(){  
            var name=document.form.text.value;  
            var pass=document.form.textarea.value;  
            if(name.length==0){  
                alert("用户名不得为空！");  
                return false;  
            }  
            if(pass.length==0){  
                alert("留言信息不能为空！");  
                return false;  
            }  
            return true;  
        }  
    </script>  
  </head>  
    
  <body style="text-align:center;" background="images/013.gif">  
    <h1>胡歌留言板</h1>  
    <div style="width:800px; border:#CCCCCC solid 1px;">  
        <%  
            String p=request.getParameter("p");  
            int pageNum=1;          //定义页数  
            int pageSize=6;        //定义每一页显示的个数  
            if(p!=null){            //判断传入的输入值是否为空，并且进行强制类型转换  
                pageNum=Integer.parseInt(p);  
            }  
              
            MessageBiz messageBiz=new MessageBiz();  
            List<Message> list=messageBiz.listByPage(pageSize,pageNum); //根据传入的两个参数，返回一个list集合  
      
            for(int i=list.size()-1;i>=0;i--){  
                Message message=new Message();  
                message=(Message)list.get(i);  
        %>  
          
        <div style="width:800px;">  
            <div style="background-color:#CCCCCC; text-align:left;">作者：<%=message.getAuthor() %>  
                       <%=message.getPostTime() %>  
            </div>  
            <div style="text-align:right;"><%=i+1+(pageNum-1)*pageSize %>#</div>  
            <div><%=message.getMessage() %>  
            </div>  
        </div>  
        <%  
            }  
            //获得最大页码  
            int maxPage;  
            int reCount=messageBiz.getAllUserCount();  
            if(reCount%pageSize==0)  
                maxPage=reCount/pageSize;  
            else  
                maxPage=(reCount/pageSize)+1;  
                  
            int backPage=(pageNum==1) ? 1 :pageNum-1;  
            int nextPage=(pageNum==maxPage) ? maxPage : pageNum+1;  
        %>  
    </div>  
      
    <div style="width:800px; height:30px; border:#000033 solid 0px; margin-top:12px; text-align:right;">  
        <div style="width:50px; height:15px; border:#CCCCCC solid 1px; display:inline; cursor:pointer;">  
            <a href="index.jsp?p=<%=backPage %>">上一页</a>  
        </div>  
        <div style="width:50px; height:15px; border:#CCCCCC solid 1px; display:inline; margin-left:12px; margin-right:20px; cursor:pointer;">  
            <a href="index.jsp?p=<%=nextPage %>">下一页</a>  
        </div>  
    </div>  
    <div style=" width:800px; height:300px; border:#333333 solid 0px;">  
        <form name="form" action="doPost.jsp" method="post" onSubmit="return check()">  
            <table align="center" cellpadding="1" cellspacing="1">  
                    <tr>  
                        <td>用户名：</td>  
                        <td><input type="text" name="text"/></td>  
                    </tr>  
                    <tr>  
                        <td>留言信息：</td>  
                        <td><textarea name="textarea" style="width:400px; height:200px;"></textarea></td>  
                    </tr>  
                    <tr><td><input type="submit" value=" 提 交 "/><input type="reset" value=" 清 空 "></td></tr>  
                </table>  
        </form>  
    </div>  
  </body>  
</html>  