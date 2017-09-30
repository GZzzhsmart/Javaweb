package Fuxi;
/**
 * 售票系统
 * */
public class Tickets extends Thread{
	static int ticket=100;
	static String s = "";
	public void run(){
		while(true){
			synchronized (s) {
				if(ticket>0){
					ticket-=1;
					System.out.println(Thread.currentThread().getName()+"取了1张票，还剩下"+ticket+"张票");
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
		Tickets t1  = new Tickets();
		t1.setName("售票员");
		t1.start();
		Tickets t2 = new Tickets();
		t2.setName("票");
		t2.start();
	}
	
}
