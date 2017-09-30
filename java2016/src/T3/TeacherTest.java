package T3;
public class TeacherTest {
	
	public static void main1(String[] args) {
		System.out.println("共有"+Teacher.count+"位老师");//count=0
		Teacher.display();//静态函数（类函数）
		Teacher t1 = new Teacher();
		t1.displayCount();	//count=1  1
		Teacher.displayCount();
		Teacher t2 = new Teacher();
		t2.displayCount();//count=2 1
		Teacher t3 = new Teacher();
		t3.displayCount();//count=3 1
		Teacher t4 = new Teacher();
		t4.displayCount();//count=4 1
		System.out.println("共有"+Teacher.count+"位老师");//count=4
		t4.displayCount();//count=4 1
		t3.displayCount();//count=4 1 
		t2.displayCount();//count=4 1
		t1.displayCount();//count=4 1
		System.out.println("共有"+t1.count+"位老师");//count=4 1
		System.out.println("共有"+t2.count+"位老师");//count=4 1
		System.out.println("共有"+t3.count+"位老师");//count=4 1
		System.out.println("共有"+t4.count+"位老师");//count=4 1
		
		
	}
	public static void main(String[] args) {
		
		int a=10,b=10;
		System.out.println("a==b="+(a==b)); //true
		Teacher t1 = new Teacher("张三","男",18);
		Teacher t2 = t1;//引用，t1,t2代表同一个对象
		System.out.println("t1==t2="+(t1==t2)); //true
		Teacher t3 = new Teacher("李四","男",28);
		System.out.println("t1==t3="+(t1==t3));//false
		System.out.println(t1);
		Student s1 = new Student();
		System.out.println(s1);
		Teacher t4 = new Teacher("李四","男",28);
		
		System.out.println("判断t1,t2的内容是否相等："+t1.equals(t2)); //true
		System.out.println("判断t1,t3的内容是否相等："+t1.equals(t3));//false
		System.out.println("判断t3,t4的内容是否相等："+t4.equals(t3));//true
		System.out.println("判断t3,t4的句柄是否相等："+(t4==t3));//false
		
		
	}
}
