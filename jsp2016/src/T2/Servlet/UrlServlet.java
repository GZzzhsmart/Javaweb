package T2.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UrlServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        //获得请求的URL
        String url = request.getHeader("referer");
        //在经过第一次请求后仍取得最初的URL
        if(url.indexOf("?")!=-1){
            url=url.substring(0,url.indexOf("?"));
        }
        //获得提交的参数
        String test = request.getParameter("test");
        //对URL进行编码并对URL进行重写
        String url1 = response.encodeURL(url+"?test="+ test);
        //对sendRedirect方法使用的指定URL进行编码
        String url2=response.encodeRedirectURL(url1);
        //重新定向
        response.sendRedirect(url2);
        out.close();
    }

    //Process the HTTP Post request
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }

    //Clean up resources
    public void destroy() {
    	
    }
}
