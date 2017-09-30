package T13sj;

import java.lang.Thread;

public class ThreadApp {
	public static void main(String[] args) {
		new ThreadA().start();
		new ThreadB().start();
	}
}
class ThreadA extends Thread{
	public void run(){
		for(int i=65;i<=90;i++){
			System.out.print((char)i);
			try{
				//休眠50毫秒
				new Thread().sleep(50);
			}catch(Exception  e){
				e.printStackTrace();
			}
		}
	}
}
class ThreadB extends Thread{
	public void run(){
		for(int i=97;i<=122;i++){
			System.out.print((char)i);
			try{
				new Thread().sleep(50);//休眠50毫秒
			}catch(Exception  e){
				e.printStackTrace();
			}
		}
	}
}