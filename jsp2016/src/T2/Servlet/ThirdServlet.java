package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "ThirdServlet");
		//获取ServletContext对象
		ServletContext sc = getServletContext();
		//通过sc 获取RequestDispatcher对象,必须/开头,通过Servet在web.xml中配置的名称去访问
		RequestDispatcher rd = sc.getNamedDispatcher("ExampleServlet");
		//转向
		rd.forward(request, response);
	}

}
