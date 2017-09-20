package T2.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	public static final String CONTENT_TYPE = "text/html;charset=utf-8";
	
	public void destroy() {
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		out.println("<br>客户端的sessionID:"+request.getRequestedSessionId());
		out.println("<br>sessionID是否有cookie提供："+request.isRequestedSessionIdFromCookie());
		out.println("<br>sessionID是否在请求URL中解码："+request.isRequestedSessionIdFromURL());
		out.println("<br>客户端返回的sessionID 是否有效："+request.isRequestedSessionIdValid());
		out.println("<br>sessionID是否为新创建的："+session.isNew());
		out.println("<br>session的默认存活期为："+session.getMaxInactiveInterval()+"秒");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
