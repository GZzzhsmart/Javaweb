package T3_1;

public class LoopQueue{
	private int size;
	private int front;
	private int rear;
	private Object[] data;
	public LoopQueue(){
		this.size=10;
		this.front=0;
		this.rear=0;
		data=new Object[size];
	}
	
	public LoopQueue(int size){
		this.size=size;
		this.front=0;
		this.rear=0;
		data=new Object[size];
	}
	//入队
	public void inQueue(Object obj){
		if(this.isFull()){			
			//首先判断队列是否已满
			System.out.println("队列已满");
		}else{
			System.out.println(obj+"入站");
			this.rear=(rear+1)%size;//队尾指针为其加1然后对队列大小进行取模
			data[rear]=obj;
		}
	}
	//出队
	public Object outQueue(){
		Object obj=null;
		if(this.isEmpty()){		
			//首先判断队列是否为空
			System.out.println("队列为空");
		}else{
			this.front=(front+1)%size;//队首指针为其加1然后对队列大小进行取模
			obj=data[front];
			System.out.println(obj+"出站");
		}
		return obj;
	}
	//判断队列是否为空
	public boolean isEmpty(){
		boolean empty=true;
		if(this.rear==this.front){
			//队空
			empty=true;
		}else{					
			//不为空
			empty=false;
		}
		return empty;
	}
	//判断队列是否已满
	public boolean isFull(){
		boolean full=true;
		if((this.rear+1)%size==this.front){
			//队满
			full=true;
		}else{						
			//不满
			full=false;
		}
		return full;
	}
}