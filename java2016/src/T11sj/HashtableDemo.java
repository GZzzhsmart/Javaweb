package T11sj;

import java.util.Enumeration;
import java.util.Hashtable;



import T4.Person;
import T5Sj.interfaceDemo;
public class HashtableDemo {
	public static void main(String[] args){
		Hashtable numbers = new Hashtable();
		//向Hashtable对象中添加person对象，给每一个对象指定一个唯一的标志key
		numbers.put(new Integer(1), new Person("zhangsan",null, 18, null));
		numbers.put(new Integer(2), new Person("lisi",null, 15, null));
		numbers.put(new Integer(3), new Person("wangwu",null, 18, null));
		//得到Hashtable中的对象集合
		Enumeration e = numbers.keys();
		//对key集合进行循环
		while(e.hasMoreElements()){
			//得到当前的key值
			Integer key = (Integer) e.nextElement();
			System.out.println("编号："+key.toString()+"的人员信息为：");
			//得到当前的key对应的人员对象
			Person p = (Person)numbers.get(key);
			System.out.println(p.toString());
		}
	}
}
//创建一个内部类
class person{
	private String name;
	int age;
	public person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){
		return new String(name+","+age);
		
	}
	//重写equals方法
	public boolean equals(Object obj){
		if(obj instanceof person) {
			person objTemP = (person) obj;
			if(name.equals(objTemP.name) && age == objTemP.age){
				return true;
			}else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	//重写hashCode方法
	public int hashCode(){
		return name.hashCode() + age;
	}
}
