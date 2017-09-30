package T13;

import java.util.jar.JarException;

public class SleepThread extends Thread{
	public void run(){
		try{
			Thread.sleep(5 * 1000 * 60);
		}catch(InterruptedException e){
			System.out.println("jist five minutes");
		}
		System.out.println("run() 运行完毕!");
	}
	public static void main(String[] args) throws java.io.IOException{
		Thread t = new SleepThread();
		t.start();
		System.out.println("线程将被挂起5分钟，请按回车键，唤醒该线程");
		System.in.read();
		t.interrupt();
		System.out.println("////////////");
		
	}
}
