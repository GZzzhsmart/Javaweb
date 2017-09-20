package listener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener,ServletContextAttributeListener{

	//application销毁
	public void contextDestroyed(ServletContextEvent arg0) {
		logout("application对象已经被销毁");
	}
	//初始化
	public void contextInitialized(ServletContextEvent arg0) {
		logout("正在初始化application对象");
	}
	//创建一个application变量
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		logout("创建一个application变量："+arg0.getName()+"="+arg0.getValue());
	}
	//删除一个application的变量
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		logout("删除了一个application变量："+arg0.getName()+"="+arg0.getValue());
	}
	//修改application变量的值
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		logout("修改了一个application变量的值："+arg0.getName()+"="+arg0.getValue());
	}
	public void logout(String msg){
		try {
			//创建一个输出流,把输出的内容保存到D盘的log.txt文件中，如果文件不存在则创建，否则就追加
			PrintWriter out = new PrintWriter(new FileOutputStream("D:\\log.txt",true));
			out.println(new Date().toLocaleString()+"->"+msg);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
