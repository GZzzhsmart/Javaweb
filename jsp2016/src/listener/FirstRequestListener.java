package listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServlet;

public class FirstRequestListener extends HttpServlet implements ServletRequestListener,ServletRequestAttributeListener{

	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("客户端提交了一个请求");
		ServletRequest sr = arg0.getServletRequest();
		if(sr.getRemoteAddr().startsWith("127")){
			sr.setAttribute("isLogin","ok");
		}else{
			sr.setAttribute("isLogin", "no");
		}
	}
	
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("请求被清除");
	}
	
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest对象增加了一个属性，name:"+arg0.getName()+",value:"+arg0.getValue());
	}
	
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest对象某个属性被移除，name:"+arg0.getName()+",value:"+arg0.getValue());
	}
	
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest对象某个属性被改变，name:"+arg0.getName()+",value:"+arg0.getValue());
	}
	
}
