package T3;
//数组队列
public class QueueArray {

	private int size;
	private int front;
	private int rear;
	private Object[] queue;
	
	public QueueArray(int size){
		this.size=size;//初始化队列长度
		this.front = -1;//初始化头指针
		this.rear = -1;//初始化尾指针
		queue = new Object[size];
	}
	//入队操作
	public void inQueue(Object obj){
		if(this.rear<size){
			//先将伪指针向后移动一个单位
			rear++;
			//将数据放入
			queue[rear]=obj;
			System.out.println(obj+"入队");
		}else {
			System.out.println("队列已满");
		}
	}
	//出队操作
	public Object outQueue(){
		Object obj = null;
		if(this.front!=this.rear){
			//将头指针向后移动一个单位，指向要出队的数据
			front++;				
			//将头指针所指数据取出
			obj=queue[front];		
			System.out.println(obj+"出队");
		}else {
			System.out.println("队列已空");
		}
		return obj;
	}
	//遍历队列
	public void display(){
		if(front!=rear){
			for(int i=front+1;i<rear+1;i++){
				System.out.println(queue[i]);
			}
		}else {
			System.out.println("队中无数据");
		}
	}
}
