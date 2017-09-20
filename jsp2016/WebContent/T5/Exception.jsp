<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true"%>

<html>
  <head>
    
    <title>Exception对象</title>
  </head>
  <body>
  	Exception:<%=exception %>
  	Message:<%=exception.getMessage() %>
  	Localized Message:<%=exception.getLocalizedMessage() %>
  	Stack Trace:<%=exception.printStackTrace(new java.io.PrintWriter(out)) %>
  </body>
</html>
