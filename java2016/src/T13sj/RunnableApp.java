package T13sj;

public class RunnableApp {
	public static void main(String[] args) {
		new Thread(new RunnableA()).start();
		new Thread(new RunnableB()).start();
	}
}
class RunnableA implements Runnable{
	public void run(){
		for(int i=0;i<=10000;i++){
			System.out.print("  +A"+i);
		}
	}
}
class RunnableB implements Runnable{
	public void run(){
		for(int i=90000;i<=100000;i++){
			System.out.print("  B"+i);
		}
	}
}
