package Fuxi;

public class Quqian implements Runnable{
	static int money=1000;
	static String s = "";
	public void run(){
		while(true){
			synchronized (s) {
				if(money>0){
					money-=100;
					System.out.println(Thread.currentThread().getName()+"取了100元，还剩下"+money+"元");
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}else{
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		Quqian q1 = new Quqian();
		new Thread(q1,"存折").start();
		new Thread(q1,"卡").start();
	}
}
