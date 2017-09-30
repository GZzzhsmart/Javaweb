package T3;
//循环队列
public class LoopQueue {

	private int size;
	private int front;
	private int rear;
	private Object[] data;
	
	public LoopQueue(){
		this.size=11;
		this.front=0;
		this.rear=0;
		data = new Object[size];
	}
	
	public LoopQueue(int size){
		this.size=size+1;
		this.front=0;
		this.rear=0;
		data = new Object[this.size];
	}
	public boolean isFull(){
		boolean full = true;
		if((this.rear+1)%size==this.front){//队满
			full = true;
		}else {//不满
			full = false;
		}
		return full;
	}
	public boolean isEmpty(){
		boolean empty = true;
		if(this.front==this.rear){//队空
			empty = true;
		}else {//不为空
			empty = false;
		}
		return empty;
	}
	//入队操作
	public void inQueue(Object obj){
		//判断对列是否已满
		if(this.isFull()){
			System.out.println("队列已满");
		}else {
			System.out.println(front+"  "+rear);
			this.rear=(rear+1)%size;
			data[rear]=obj;
		}
	}
	//出队操作
	public Object outQueue(){
		Object obj = null;
		//判断队列是否为空
		if(this.isEmpty()){
			System.out.println("对列为空");
		}else {
			//队首指针为其加1然后对队列大小进行取模
			this.front = (front+1)%size;
			obj = data[front];
		}
		return obj;
	}
}
