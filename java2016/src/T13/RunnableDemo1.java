package T13;


public class RunnableDemo1 implements Runnable{

	public void run() {
		for(int i=0;i<100;i++){
			//Thread.currentThread()获取当前线程
			System.out.println(Thread.currentThread().getName() +":i="+i);
			//休眠:单位是毫秒
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("休息了10毫秒，好爽。。。。。。。。");
			}
		}
	}

	public static void main(String[] args) {
		RunnableDemo1 r =  new RunnableDemo1();
		Thread thread1 = new Thread(r);
		thread1.setPriority(1);
		Thread thread2 = new Thread(r,"线程2");
		System.out.println("线程2的优先级："+thread2.getPriority());
		Thread thread3 = new Thread(r);
		thread3.setPriority(8);
		thread1.setName("线程1");
		thread1.start();
		thread2.start();
		thread3.start();
		thread3.interrupt();
		
		
	}
}
