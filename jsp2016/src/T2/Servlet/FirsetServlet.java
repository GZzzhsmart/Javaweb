package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirsetServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "FirsetServlet");
		//获取requestDispatcher对象
		RequestDispatcher rd = request.getRequestDispatcher("ExampleServlet");
		//转向
		rd.forward(request, response);
//		request.getRequestDispatcher("ExampleServlet").forward(request, response);
	}

}
