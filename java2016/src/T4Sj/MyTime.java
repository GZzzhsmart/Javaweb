package T4Sj;

/**
 * 在程序中，经常要对时间进行操作，但是并没有时间类型的数据。那么，我们可以自己实现一个时间类，来满足程序中的需要。 
定义名为MyTime的类，其中应有三个整型成员：时（hour），分（minute），秒（second），为了保证数据的安全性，这三个成员变量应声明为私有。 
为MyTime类定义构造方法，以方便创建对象时初始化成员变量。 再定义diaplay方法，用于将时间信息打印出来。  
为MyTime类添加以下方法： addSecond(int sec) addMinute(int min) addHour(int hou) subSecond(int sec) subMinute(int min) subHour(int hou) 
分别对时、分、秒进行加减运算。  
 * */
public class MyTime {
	private int hour;
	private int minute;
	private int second;
	//默认构造函数
	public MyTime(){
		hour   = 0;
		minute = 0;
		second = 0;
	}
	//构造函数重载
	public MyTime(int hour,int minute,int second){
		this.hour   = hour;
		this.minute = minute;
		this.second = second;
	}
	public void display(){
		System.out.println("时间："+hour+":"+minute+":"+second);
	}
	public void addHour(int hour){
		this.hour+=hour;
		this.hour%=24;
	}
	public void subHour(int hour){
		this.hour-=hour;
		this.hour%=24;
	}
	public void addMinute(int minute){
		this.minute+=minute;
		this.minute%=60;
	}
	public void subMinute(int minute){
		this.minute-=minute;
		this.minute%=60;
	}
	public void addSecond(int second){
		this.second+=second;
		this.second%=60;
	}
	public void subSecond(int second){
		this.second-=second;
		this.second%=60;
	}
	public static void main(String[] args){
		MyTime mytime = new MyTime(18,45,30);
		mytime.display();
		mytime.addHour(50);
		mytime.display();
		mytime.addSecond(110);
		mytime.display();
	}
}

