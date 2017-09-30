package T2;
/**
 * 编写程序用线程模拟用存折和卡取款的程序（即一个账号有一个存折和一张卡）
 * */
public class quqian extends Thread{
	static int money=10000;
	static String s = "";
	public void run(){
		while(true){
			synchronized (s) {
				if(money>0){
					money-=100;
					System.out.println(Thread.currentThread().getName()+"取了100元，剩下"+money);
					try{
						//休眠半秒钟
						Thread.sleep(500);
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
		quqian t1 = new quqian();
		t1.setName("存折");
		t1.start();
		quqian t2 = new quqian();
		t2.setName("卡");
		t2.start();
	}
}
