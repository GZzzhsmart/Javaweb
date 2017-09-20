package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//输出内容到浏览器中
		out.println("<html>");
		out.println("<head><title>第一个动态页面</title></head>");
		out.println("<body>");
		out.println("<p style='color:red;font-size:16pt;'>你好，世界！");
		java.util.Date date = new java.util.Date();
		out.println(date.toLocaleString());
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
