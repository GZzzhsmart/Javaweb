package T17;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.activation.FileDataSource;

public class TestDemo1 {
	public static void main(String[] args) {
		String str = "abc";
		Class clazz = null;
		try{
			clazz = Class.forName("T16.UDPChat");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//读取所有的构造函数
		Constructor[] constructor = clazz.getDeclaredConstructors();
		//读取公有的构造函数
//		Constructor[] constructor = clazz.getConstructors();
		
		for(int i=0;i<constructor.length;i++){
			System.out.print(constructor[i].getName()+"(");
			Class cls1 []=constructor[i].getParameterTypes();
			for(int j=0;j<cls1.length;j++){
				if(j==(cls1.length-1)){
					System.out.print(cls1[j].getName());
				}else{
					System.out.print(cls1[j].getName()+",");
				}
			}
			System.out.println(")");
		}
		
		//读取普通方法
		System.out.println("---------所有函数---------");
		//读取公有的方法
		Method[] method = clazz.getMethods();
		for(int i=0;i<method.length;i++){
			System.out.print(method[i].getName()+"(");
			Class cls1[]=method[i].getParameterTypes();
			for(int j=0;j<cls1.length;j++){
				if(j==(cls1.length-1)){
					System.out.print(cls1[j].getName());
				}else{
					System.out.print(cls1[j].getName()+",");
				}
			}
			System.out.println(")");
		}
		
		//读取所有的成员变量
		System.out.println("---------成员变量---------");
		Field[] field = clazz.getDeclaredFields();
		for(int i=0;i<field.length;i++){
			System.out.println(field[i].getName());
		}
	}
}
