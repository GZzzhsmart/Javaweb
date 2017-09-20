package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet1 extends HttpServlet{

	//初始化
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String soft = req.getParameter("soft");
		String system = req.getParameter("system");
		String remark = req.getParameter("remark");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>软件使用信息反馈如下</title></head><body><h1 align='center' color='cyan'>软件使用信息反馈如下</h1>");
		out.println("昵称："+username+"<br/>");
		out.println("邮箱地址："+email+"<br/>");
		out.println("电话："+telephone+"<br/>");
		out.println("软件："+soft+"<br/>");
		out.println("操作系统："+system+"<br/>");
		out.println("备注："+remark+"<br/>");
		out.println("</body></html>");
		System.out.println("username="+username+";email="+email+";telephone="+
				telephone+";soft="+soft+";system="+system+";remark="+remark);
		
	}
	@Override
	public void destroy() {
		
	}
}
