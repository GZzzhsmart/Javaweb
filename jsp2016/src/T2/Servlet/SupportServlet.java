package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupportServlet extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>软件使用意见反馈</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<h1 align='center'>软件使用意见反馈</h1>");
		out.println("<hr/>");
		out.println("<form name='form1' action='./support.jsp' method='post'>");
		out.print("<table border='0' width='800' align='center'>");
		out.print("<tr>");
		out.print("<td align='right'>姓名：</td>");
		out.print("<td><input type='text' name='username' style='width:400px'></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td align='right'>E_mail:</td>");
		out.print("<td><input type='text' name='email' style='width:400px'></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td align='right'>电话：</td>");
		out.print("<td><input type='text' name='phone' style='width:400px'></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td align='right'>软件：</td>");
		out.print("<td><select name='soft' style='width:400px'><option value='Eclipse'>Eclipse</option><option value='Editplus'>Editplus</option>" +
		"<option value='photoshop'>photoshop</option><option value='SQLserver'>SQLserver</option></select></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td align='right'>操作系统：</td>");
		out.print("<td><select name='os' style='width:400px'><option value='window'>window</option><option value='linux'>linux</option>" +
		"<option value='unix'>unix</option><option value='Mac os'>Mac os</option></select></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td align='right'>问题描述：</td>");
		out.print("<td><textarea name='remark' style='width:400px;height:100px'></textarea></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td colspan='2' align='center'><input type='submit' value=' 确 认 '></td>");
		out.print("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	
	public void init() throws ServletException {
		
	}

}
