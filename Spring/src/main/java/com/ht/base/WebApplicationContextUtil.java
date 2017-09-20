package com.ht.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebApplicationContextUtil {
	//在Servlet中获取spring配置的bean
	public static Object createService(HttpServletRequest request,String beanid){
		WebApplicationContext wac = null;
		if (wac == null)
			wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());
		return wac.getBean(beanid);
	}
	//在struts2的action里面调用该方法，获取spring配置的bean
	public static Object createService(String beanid){
		WebApplicationContext wac = null;
		if (wac == null)
			wac = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext());
		return wac.getBean(beanid);
	}
	//不通过配置，直接读取文件
	public static Object createAppService(String beanid){
		ApplicationContext ctx=null;
		if(ctx==null)
			ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		return ctx.getBean(beanid);
	}

}
