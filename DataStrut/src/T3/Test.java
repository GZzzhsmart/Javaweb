package T3;

public class Test {

	public static void main(String[] args) {
		//生成一个队列对象，初始化值为10
		QueueArray qa = new QueueArray(10);
		//入队
		qa.inQueue("1");
		qa.inQueue("2");
		qa.inQueue("3");
		qa.inQueue("4");
		qa.inQueue("5");
		//出队
		qa.outQueue();
		qa.outQueue();
		System.out.println("\n队中数据:");
		//开始遍历
		qa.display();
	}
}
