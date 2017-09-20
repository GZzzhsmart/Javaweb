package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet{

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
		String username = req.getParameter("username");//用户名
		String password = req.getParameter("password");//密码
		String cfgpwd = req.getParameter("cfgpwd");//确认密码
		String sex = req.getParameter("sex");//性别
		String age = req.getParameter("age");//年龄
		String hobit[] = req.getParameterValues("hobit");//爱好
		String place = req.getParameter("place");//地址
		PrintWriter pr = resp.getWriter();
		pr.println("<html><head><title>注册信息如下</title></head><body><h1>注册信息如下</h1>");
		pr.println("昵称："+username+"<br/>");
		pr.println("密码："+password+"<br/>");
		pr.println("确认密码："+cfgpwd+"<br/>");
		pr.println("性别："+sex+"<br/>");
		pr.println("年龄："+age+"<br/>");
		StringBuffer str_hobit = new StringBuffer("爱好：");
		for(int i=0;i<hobit.length;i++){
			str_hobit.append(hobit[i]+" ");
			System.out.println(str_hobit);
		}
		pr.println(str_hobit.toString()+"<br/>");
		pr.println("地址："+place+"<br/>");
		pr.println("</body></html>");
		System.out.println("username="+username+";password="+password+";cfgpwd="+
				cfgpwd+";sex="+sex+";age="+age+";hobit="+hobit+";place="+place);
	}
	@Override
	public void destroy() {
		
	}
}
