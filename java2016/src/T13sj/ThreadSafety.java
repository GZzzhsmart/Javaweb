package T13sj;



import com.sun.org.apache.xerces.internal.parsers.CachingParserPool.SynchronizedGrammarPool;

public class ThreadSafety {
	public static void main(String[] args) {
		//实例一个打印对象
		Point p = new Point();
		//将给对象共享来创建两个线程对象，并启动
		new ThreadC(p).start();
		new ThreadD(p).start();
	}
}
class Point{
	//方法一打印0到100
	public void print0to100(){
		for(int i=0;i<=100;i++){
			System.out.print(i + " ");
		}
	}
	//方法二打印101到200
	public void print101to200(){
		for(int i=101;i<=200;i++){
			System.out.print(i + " ");
		}
	}
}
//通过继承来实现线程A
class ThreadC extends Thread{
	Point p = null;
	
	public ThreadC(Point p1){
		this.p=p1;
	}
	//实现run方法
	public void run(){
		//同步对象p
		synchronized (p) {
			//调用打印方法
			p.print0to100();
		}
	}
}
//通过继承来实现线程B
class ThreadD extends Thread{
	Point p = null;
	
	public ThreadD(Point p2){
		this.p=p2;
	}
	//实现run方法
	public void run(){
		//同步对象p
		synchronized (p) {
			//调用打印方法
			p.print101to200();
		}
	}
}
