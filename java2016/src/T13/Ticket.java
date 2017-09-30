package T13;

/**
 * 模拟车站售票系统
 * 
 * */
public class Ticket implements Runnable {

	//车票数量
	int ticketCount=100;
	public void run() {
		saleTicket2();
	}
	//卖票
	public synchronized void saleTicket(){
		//临界点,要用互斥锁实现同步
		
		try{
			while(ticketCount>0){
				String name = Thread.currentThread().getName();
				ticketCount = ticketCount-1;
				System.out.println(name+"卖了一张票，还剩"+ticketCount+"张票");
				Thread.sleep(100);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void saleTicket2(){
		//临界点,要用互斥锁实现同步
		
		try{
			while(true){
				//需要锁，锁就是一个Object类型的变量
				synchronized (this) {//临界点
					if(ticketCount<1)
						break;
					String name = Thread.currentThread().getName();
					ticketCount = ticketCount-1;
					System.out.println(name+"卖了一张票，还剩"+ticketCount+"张票");
					Thread.sleep(10);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(ticket,"售票员1").start();
		new Thread(ticket,"售票员2").start();
		new Thread(ticket,"售票员3").start();
		new Thread(ticket,"售票员4").start();
		
	}
}
