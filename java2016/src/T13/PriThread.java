package T13;

public class PriThread {
	public static void main(String[] args) {
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		//设置优先级别，值越大越先执行
		a.setPriority(2);
		b.setPriority(3);
		a.start();
		b.start();
	}
}
//创建线程A
class ThreadA extends Thread{
	public void run(){
		System.out.print("  我是线程A");
	}
}
//创建线程B
class ThreadB extends Thread{
	public void run(){
		System.out.print("  我是线程B");
	}
}