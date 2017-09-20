<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="chat.Message"%>
<%@page import="chat.MessageBiz"%>  
<%  
    request.setCharacterEncoding("utf-8");  
    String author=request.getParameter("text");  
    String message=request.getParameter("textarea");  
      
    Message messages=new Message();  
    messages.setAuthor(author);  
    messages.setMessage(message);  
    MessageBiz messageBiz=new MessageBiz();  
    messageBiz.saveMessage(messages);  
    response.sendRedirect("index.jsp");  
 %>  