package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RespServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> param = request.getHeaderNames();
		while(param.hasMoreElements()){
			String paramName = param.nextElement();
			out.println(paramName +"="+request.getHeader(paramName)+"<br/>");
		}
		out.println(request.getRequestURI()+"<br/>");
		out.println(request.getRequestURL()+"<br/>");
	}

}
