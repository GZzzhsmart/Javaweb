package T13sj;

public class Caller extends Thread{
	String msg;
	Callme target;
	Thread t;
	public Caller(Callme targ,String s){
		target=targ;
		msg=s;
		t=new Thread(this);
		t.start();
	}
	public void run(){
		target.call(msg);
	}
	public static void main(String[] args) {
		Callme target = new Callme();
		//实例化三个对象，然后分别调用对应的线程对象t,依次让其输出指定的字符串
		Caller ob1 = new Caller(target,"Hello");
		Caller ob2 = new Caller(target,"Synchronized");
		Caller ob3 = new Caller(target,"World");
		//让三个线程等待一起执行完毕
		try{
			ob1.t.join();ob2.t.join();ob3.t.join();
		}catch(InterruptedException e){
			System.out.println("interrupted");
		}
	}
}
//该类的作用是依次输出 “[ 指定的字符串  ]”
class Callme{

	public void call(String msg) {
		System.out.print("["+msg);
		//输出左中括号[后，让线程暂停1秒种后，再输出右中括号]
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("interrupted");
		}
		System.out.println(" ]");
	}
	
}