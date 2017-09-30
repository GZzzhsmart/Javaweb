package T5Sj;
/*定义一个抽象的"Role"类，有姓名，年龄，性别等成员变量 
1. 要求尽可能隐藏所有变量(能够私有就私有,能够保护就不要公有)，再通
过GetXXX()和SetXXX()方法对各变量进行读写。具有一个抽象的play()方法，
该方法不返回任何值，同时至少定义两个构造方法。Role类中要体现出this的几种用法。 
2. 从Role类派生出一个"Employee"类，该类具有Role类的所有成员（构
造方法除外），并扩展 salary成员变量，同时增加一个静态成员变量“职工编号（ID）”。
同样要有至少两个构造方法，要体现出this和super的几种用法，还要求覆盖play()方法，
并提供一个final sing()方法。 3. "Manager"类继承"Employee"类，
有一个final成员变量"vehicle" 
4. 在main()方法中制造Manager和Employee对象,并测试这些对象的方法  
 * */
import java.util.Scanner;
public abstract class Role {
	private int age;
	private String name;
	public Role(int a){
		this.setAge(a);
	}
	public Role(String b){
		this.setName(b);
	}
	public Role(int a,String b){
		this(a);
		this.setName(b);
	}
	public void setAge(int a){
		age=a;
	}
	public void setName(String b){
		name=b;
	}
	public int getAge(){
		return age;
	}
	public String getName(){
		return name;
	}
	public abstract void play();
}
