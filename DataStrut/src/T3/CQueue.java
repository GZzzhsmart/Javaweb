package T3;

import java.util.Queue;

public class CQueue {

	Object [] data;
	int size;
	int front;
	int rear;
	public CQueue() {
		this.size = 11;
		front = 0;
		rear = 0;
		data = new Object[this.size];
	}
	public CQueue(int size) {
		this.size = size+1;
		front = 0;
		rear = 0;
		data = new Object[this.size];
	}
	//队列是否已满：队尾指针+1=对首指针
	public boolean isFull(){
		if((rear+1) % this.size == front){
			return true;
		}else{
			return false;
		}
	}
	//队列为空：front==rear;
	public boolean isEmpty(){
		if(front==rear){
			return true;
		}else{
			return false;
		}
	}
	
	//入队
	public int inQueue(Object dat){
		if(isFull()){
			System.out.println("队列已满");
			return -1;
		}else{
			rear++;
			rear = rear % this.size;
			data[rear]=dat;
			System.out.println("入队："+dat);
			return rear;
		}
	}
	//出队
	public int outQueue(){
		if(isEmpty()){
			System.out.println("队列为空");
			return -1;
		}else{
			front++;
			front = front % this.size;
			System.out.println("出队："+data[front]);
			return front;
		}
	}
	//遍历
	public void display(){
		int f = (front+1) % this.size;//1
		int r = (rear+1) % this.size; 
		System.out.println("f="+f+";r="+r);
		while(f!=r){
			System.out.println("遍历："+data[f]);
			f++;
			f=f % this.size;
		}
	}
	public static void main(String[] args) {
		CQueue queue = new CQueue();
		queue.inQueue("1");
		queue.inQueue("2");
		queue.inQueue("3");
		queue.inQueue("4");
		queue.inQueue("5");
		queue.inQueue("6");
		queue.inQueue("7");
		queue.inQueue("8");
		queue.inQueue("9");
		queue.inQueue("10");
		queue.inQueue("11");

		queue.display();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.outQueue();
		queue.inQueue("11");
		queue.inQueue("12");
		queue.inQueue("13");
		queue.inQueue("14");
		queue.display();
	}
}
