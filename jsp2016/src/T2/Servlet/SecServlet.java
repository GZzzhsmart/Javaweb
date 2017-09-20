package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "SecondServlet");
		//获取ServletContext的变量
		ServletContext sc = getServletContext();
		//通过sc 获取RequestDispatcher对象,必须/开头
		RequestDispatcher rd = sc.getRequestDispatcher("/ExampleServlet");
		//转向
		rd.forward(request, response);
	}

}
