package T17;

import java.util.Calendar;
import java.util.Date;

public class TestDemo3 {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.setName("张三");
		System.out.println(singleton.getName());
		
		Singleton singleton2 = Singleton.getInstance();
		singleton.setName("李四");
		System.out.println(singleton.getName());
		
		if(singleton==singleton2){
			System.out.println("同一个实例");
		}else{
			System.out.println("不是一个实例");
		}
		System.out.println(singleton.getName());
		System.out.println(singleton2.getName());
	}
}
