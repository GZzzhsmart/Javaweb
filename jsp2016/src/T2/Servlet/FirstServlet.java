package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 创建Servlet的方法
 * */
public class FirstServlet extends HttpServlet{
	
	String username;
	String age;
	String sex;
	
	//初始化函数
	@Override
	public void init() throws ServletException {
		
	}
	//初始化函数，需要读取配置参数时，调用该函数初始化
	@Override
	public void init(ServletConfig config) throws ServletException {
		//读取Servlet中配置中的参数
		username = config.getInitParameter("username");
		age = config.getInitParameter("age");
		sex = config.getInitParameter("sex");
		System.out.println("username="+username+";age="+age+";sex="+sex);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//默认编码是：ISO8859-1，输入的编码必须转换为GBK,GB2312，utf-8
		resp.setContentType("text/html;charset=utf-8");
		//输出内容到浏览器
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>这是我的第一个Servlet程序</title></head>");
		out.println("<body>");
		out.println("<h1>这是我的第一个Servlet程序，执行的是doGet方法</h1>");
		out.println("<hr color='red'>");
		out.println("<h1>读取Servlet的参数值如下：</h1>");
		String str = "username="+username+";age="+age+";sex="+sex;
		out.println("<h2>"+str+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	public void destroy() {
		
	}
}
