package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//获取session对象；
		HttpSession session = request.getSession();
		//获取application对象;
		ServletContext application = getServletContext();
		System.out.println("driver="+session.getAttribute("driver"));
		System.out.println("url="+application.getAttribute("url"));
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

}
