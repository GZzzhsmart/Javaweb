package menueAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="helloUser2", urlPatterns={"/menuServlet"},loadOnStartup=1)

public class MenuServlet extends HttpServlet {

	HashMap<String, String> map = new HashMap<String, String>();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		map.put("1", "<member>张三</member><member>李四</member>");
		map.put("2", "<member>王五</member><member>小丽</member>");
		map.put("3", "<member>老王</member><member>小小</member>");
		map.put("4", "<member>李小龙</member><member>张三丰</member><member>江小白</member>");
		//获取参数
		String depid = request.getParameter("depid");
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='utf-8' ?>");
		sb.append("<members>");
		if(depid!=null && !depid.equals("")){
			sb.append(map.get(depid));
		}
		sb.append("</members>");
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(sb);
		out.flush();
		out.close();
	}

}
