package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//乱码处理
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username"); //参数就是控件名称
		String pass = request.getParameter("password");
		System.out.println("username="+username+";password="+pass);
		if(username.equals("admin") && pass.equals("1234")){
			//重定向到success.jsp页面
			response.sendRedirect("success.jsp");
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
			//重定向到success.jsp页面
			response.sendRedirect("failed.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
