package T3;

public class Test1 {

	public static void main(String[] args) {
		LoopQueue lq = new LoopQueue();
		lq.inQueue("1");
		lq.inQueue("2");
		lq.inQueue("3");
		lq.inQueue("4");
		lq.inQueue("5");
		lq.inQueue("aa");
		lq.outQueue();
		lq.outQueue();
		
		lq.inQueue("6");
		lq.inQueue("7");
		
		lq.outQueue();
		lq.outQueue();
		lq.inQueue("8");
		lq.inQueue("9");
		while(!lq.isEmpty())
		{
			System.out.println(lq.outQueue());
		}
	}
}
