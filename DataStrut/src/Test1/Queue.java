package Test1;

public class Queue {
	private int size;
	private int front;
	private int rear;
	private Object [] queue;
	int cnt1,cnt2;
	
	public Queue(){
		this.front=1;//初始化头指针
		this.rear=1;//初始化尾指针
		queue=new Object[size];//初始化数组
	}
	public Queue(int size){
		this.size=size;//初始化队列长度
		this.front=1;//初始化头指针
		this.rear=1;//初始化尾指针
		queue=new Object[size];//初始化数组
		
	}
	//入队
	public void inQueue(int  obj){
		int huan;
		//首先判断队列是否为空
		if(isFull()){
			System.out.println("队列已满");
		}else{
			//System.out.println(front+"-----------------"+rear);
			//队尾指针为其加一然后对列大小进行取模
			this.rear=(rear+1)%size;
			queue[rear]=obj;
			System.out.println(front+"-----------------"+obj);
		}
	}
	
	//出队
	public Object outQueue(){
		//声明一个变量用于保存出队的数据
		Object obj=null;
		if(this.isEmpty()){
			System.out.println("队列为空");
		}else{
			//队尾指针为其加一然后对列大小进行取模
			this.front=(front+1)%size;
			obj=queue[front];
		}
		return obj;
	}
	
	//遍历
	public void display(){
		//先判断队列是否为空
		if(front!=rear){
			//声明临时指针"i"跟踪元素的下标
			for(int i=front+1;i<rear+1;i++){
				System.out.println(queue[i]);
			}
		}else{
			System.out.println("队中无数据");
		}
	}
	
	//判断是否已满
	public boolean isEmpty(){
		boolean empty=true;	
		if(this.front==this.rear){
			empty=true;//队空
		}else{
			empty=false;//不为空
		}
		return empty;
	}
	//判断是否为空
	public  boolean isFull(){
		if((rear+1)%this.size==front){
			return true;
		}else{
			return false;
		}
	}
	//查找
	public void find(int data){
		if(this.front!=this.rear){
				System.out.println("查询的数据："+queue[data-1]);
		}
	}
	//大小
	public void size(){
		int cnt3=cnt1-cnt2;
		System.out.println("实际是数量:"+cnt3);
	}
	
	public static void main(String[] args) {
		Queue qa=new Queue(5);//生成一个队列对象，初始其为10
		qa.inQueue(11);//入队
		qa.inQueue(45);
		qa.inQueue(13);
		qa.inQueue(14);
		qa.inQueue(15);
		//出队
		qa.outQueue();
		qa.outQueue();
		qa.inQueue(6);
		qa.inQueue(7);
		qa.outQueue();
		qa.outQueue();
		qa.inQueue(8);
		qa.inQueue(9);
	}
}
