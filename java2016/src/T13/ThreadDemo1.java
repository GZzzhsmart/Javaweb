package T13;

public class ThreadDemo1 extends Thread{
	public ThreadDemo1(){
		
	}
	public ThreadDemo1(String name){
		setName(name);
	}
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread().getName() + ": i="+i);
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadDemo1 thread1 = new ThreadDemo1("线程1");
		ThreadDemo1 thread2 = new ThreadDemo1("线程2");
		ThreadDemo1 thread3 = new ThreadDemo1("线程3");
		ThreadDemo1 thread4 = new ThreadDemo1();
		
		//调用start方法，线程进入就绪状态
		thread1.start();//启动线程
		thread2.start();//启动线程
		thread3.start();
		thread4.start();//错误：不能直接run方法
		
	}
}
