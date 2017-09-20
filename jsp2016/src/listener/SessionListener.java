package listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.*;
//同时实现ServletContextListener,获取application对象
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener,ServletContextListener{

	//获取application对象
	ServletContext application=null;
	//打开游览器时执行
	public void sessionCreated(HttpSessionEvent arg0) {
		setApp(1);
		logout("初始化session对象，目前在线人数有："+getApp());
	}
	public void sessionDestroyed(HttpSessionEvent arg0) {
		setApp(-1);
		logout("销毁session对象");
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		logout("创建一个session变量：id="+arg0.getSession().getId()+","+arg0.getName()+"="+arg0.getValue());
		logout("目前有："+getApp()+"位在线人数");
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		logout("删除一个session变量：id="+arg0.getSession().getId()+","+arg0.getName()+"="+arg0.getValue());
		logout("目前有："+getApp()+"位在线人数");
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		logout("修改一个session变量：id="+arg0.getSession().getId()+","+arg0.getName()+"="+arg0.getValue());
		
	}
	//写日志
	public void logout(String msg){
		try {
			//创建一个输出流，把输出的内容保存到C盘的log.txt文件中，如果文件不存在则创建，否则就追加
			PrintWriter out = new PrintWriter(new FileOutputStream("c:\\log.txt",true));
			out.println(new Date().toLocaleString()+"->"+msg);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//给application变量设值
	public void setApp(int n){
		int count =0;
		//第一个用户访问网站
		if(application.getAttribute("count")==null){
			application.setAttribute("count",new Integer(1));
		}else{
			count = Integer.parseInt(application.getAttribute("count").toString());
			count = count +n;
			application.setAttribute("count",new Integer(count));
		}
	}
	public int getApp(){
		int count = 1;
		if(application.getAttribute("count")!=null){
			count = Integer.parseInt(application.getAttribute("count").toString());
		}
		return count;
	}
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	//初始化ServletContext时，可以获取对象
	public void contextInitialized(ServletContextEvent sce) {
		application=sce.getServletContext();
	}
}
