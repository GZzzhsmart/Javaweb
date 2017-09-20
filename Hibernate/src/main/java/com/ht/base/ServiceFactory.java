package com.ht.base;

import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ServiceFactory {

	public static HashMap serviceClassNames = new HashMap();
	public static HashMap serviceInstances = new HashMap();
	//读取配置文件
	static{
		SAXBuilder builder = new SAXBuilder();
		try{
			//读取配置文件
			Document doc = builder.build(ServiceFactory.class.getResourceAsStream("service-config.xml"));
			//读取根节点
			Element root = doc.getRootElement();
			List<Element> children=root.getChildren();
			for (Element child : children) {
				//读取name属性
				String name = child.getAttributeValue("name");
				String clazz = child.getAttributeValue("class");
				System.out.println("name="+name+";class="+clazz);
				serviceClassNames.put(name, clazz);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//创建对象
	public static Object createService(String serviceName){
		//读取对应服务的实例
		Object instance=serviceInstances.get(serviceName);
		if(instance==null){
			String className = serviceClassNames.get(serviceName).toString();
			//利用反射机制实例化对象
			try {
				instance = Class.forName(className).newInstance();
				serviceInstances.put(serviceName, instance);
				return instance;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println("begin...");
	}
	
}
