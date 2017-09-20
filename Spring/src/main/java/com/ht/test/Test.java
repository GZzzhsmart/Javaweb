package com.ht.test;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ContextLoaderListener;

import com.ht.base.BaseDaoImpl;
import com.ht.base.IBaseDAO;
import com.ht.base.IProxyTest;
import com.ht.base.LogHandler;
import com.ht.base.ProxyTestImpl;
import com.ht.base.WebApplicationContextUtil;
import com.ht.vo.CourseVo;
import com.ht.vo.MajorVo;
import com.ht.vo.TestBean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

	public void readConfigFile(){
		//读取配置文件,读取存放在classpath下面的资源
//		Resource resource = new ClassPathResource("applicationContext.xml");
		//用于读取存放在文件路径下的资源
		Resource resource = new FileSystemResource("D:\\work\\javaProj\\Spring2017\\WebRoot\\WEB-INF\\classes\\applicationContext.xml");
		//创建bean工厂
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		//读取配置文件中某个java bean，参数的值就是配置文件中的id属性对应的值
		TestBean testBean = (TestBean)factory.getBean("testBean");
//		System.out.println(testBean.getHelloWorld());
		System.out.println(testBean.getName() +","+testBean.getHelloWorld());

	}
	public void daoTest(){
		Resource resource = new ClassPathResource("applicationContext.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		IBaseDAO baseDAO = (IBaseDAO)factory.getBean("baseDAO");
		CourseVo course = new CourseVo();
//		course.setCourseName("Hibernate");
//		course.setCredit(4);
//		baseDAO.save(course);
		course.setCourseid(8);
		baseDAO.del(course);
	}
	public void AppContext(){
		
		IBaseDAO baseDAO = (IBaseDAO)WebApplicationContextUtil.createAppService("baseDAO");
		CourseVo course = new CourseVo();
		course.setCourseid(9);
		baseDAO.del(course);
	}
	public void publishEvent(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//发布事件
		ctx.publishEvent(new SomeObject(BaseDaoImpl.class));
	}
	public void ioc(){
		TestBean testBean = (TestBean)WebApplicationContextUtil.createAppService("testBean");
		System.out.println(testBean.getName()+","+testBean.getHelloWorld());
		System.out.println("date="+testBean.getDate().toLocaleString());
		System.out.println("民族列表：");
		for (String str : testBean.getNation()) {
			System.out.println(str);
		}
		System.out.println("list--------------------");
		for (Object obj : testBean.getList()) {
			System.out.println(obj);
		}
		System.out.println("map--------------------");
		Set set = testBean.getMap().keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = it.next().toString();
			System.out.println(key+"="+testBean.getMap().get(key));
		}
	}
	
	//定义日志对象
	Logger logger = Logger.getLogger(this.getClass().getName());
	public void getCourseById(){
		logger.log(Level.INFO, "进入getCourseById函数");
		IBaseDAO baseDAO = (IBaseDAO)WebApplicationContextUtil.createAppService("baseDAO");
		CourseVo course = (CourseVo)baseDAO.get(CourseVo.class,1);
		System.out.println("编号："+course.getCourseid()+",课程名称:"+course.getCoursename());
		MajorVo major = (MajorVo)baseDAO.get(MajorVo.class,1);
		System.out.println("编号："+major.getMajorid()+",专业名称:"+major.getMajorname());
		logger.log(Level.WARNING,"退出getCourseById函数");
	}
	
	public static void main(String[] args) {
		LogHandler logHandle = new LogHandler();
		Test test = new Test();
//		test.daoTest();
//		test.ioc();
		test.getCourseById();
		IProxyTest proxy = (IProxyTest)logHandle.bind(new ProxyTestImpl());
		proxy.add();
		proxy.del();
		proxy.get(1);
	}
	
}
