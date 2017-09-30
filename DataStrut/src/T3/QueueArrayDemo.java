package T3;

public class QueueArrayDemo {

	private int size;
	private int front;
	private int rear;
	private Object[] data;
	
	public QueueArrayDemo(int size){
		//初始化队列长度
		this.size=size;
		//初始化头指针
		this.front=-1;
		//初始化尾指针
		this.rear=-1;
		//初始化数组
		data = new Object[size];
	}
	//入队
	public void inQueue(Object obj){
		//队列不满才能入队
		if(this.rear<size){
			rear++;
			data[rear] = obj;
			System.out.println(obj+"入队");
		}else {
			System.out.println("队列已满");
		}
	}
	
	//出队
	public Object outQueue(){
		Object obj = null;
		if(this.front!=this.rear){
			front++;
			obj = data[front];
			System.out.println(obj+"出队");
		}else {
			System.out.println("队列为空");
		}
		return obj;
	}
	
	//遍历
	public void display(){
		//遍历前先判断队列是否为空
		if(front!=rear){
			for(int i=front+1;i<rear+1;i++){
				System.out.println(data[i]);
			}
		}else {
			System.out.println("队中无数据");
		}
	}
	
	public static void main(String[] args) {
		//生成一个队列对象，初始值为10
		QueueArrayDemo qa = new QueueArrayDemo(10);
		//入队
		qa.inQueue("1");
		qa.inQueue("2");
		qa.inQueue("3");
		qa.inQueue("4");
		qa.inQueue("5");
		
		qa.outQueue();
		qa.outQueue();
		System.out.println("\n对中无数据");
		//开始遍历
		qa.display();
	}
	
}
