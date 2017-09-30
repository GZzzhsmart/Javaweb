package T13;

import java.util.jar.JarException;

import javax.sql.rowset.Joinable;

public class JohnThread extends Thread{
	public void run(){
		System.out.println("begin run");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			System.out.println(" interruptedException ");
		}
	}
	public static void main(String[] args) throws java.lang.InterruptedException{
		Thread t = new Thread();
		t.start();
		System.out.println("等待5秒后，线程t死亡");
		t.join();
		System.out.println("主线程死亡");
	}
}
