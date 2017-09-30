package T2;

public class MyStack {

	Node head;
	int size;
	public MyStack(){
		//头节点
		head = new Node();
	}
	
	//新增元素
	public void push(String data){
		//获取头指针
		Node p = head;
		//新增节点
		Node d = new Node(data);
		//设置新节点的下一个节点为头节点的下一个节点
		d.next = p.next;
		//把头节点的下一个节点指到新节点;
		p.next=d;
		size++;
	}
	
	//删除元素
	public String pop(){
		//判断堆栈是否为空
		if(isEmpty()){
			System.out.println("堆栈已经为空，无法删除");
			return null;
		}
		//获取头指针
		Node p = head;
		Node temp = p.next;
		//删除
		p.next=p.next.next;
		size--;
		return temp.name;
	}
	
	//判断堆栈是否为空
	public boolean isEmpty(){
		boolean isok = false;
		if(head.next==null){
			isok=true;
		}
		return isok;
	}
	
	//返回元素个数
	public int size(){
		return size;
	}
	
	//查找
	public void find(String data){
		Node p = head;
		while(p.next!=null){
			if(p.next.name.equals(data)){
				System.out.println("找到了你想要的数据："+data);
			}else {
				p.next = p.next.next;
			}
		}
	}
	
	//获取栈顶元素
	public String peek(){
		if(isEmpty()){
			return null;
		}
		return head.next.name;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("组长");
		stack.push("部门经理");
		stack.push("主管副总");
		stack.push("总经理");
		stack.push("董事长");
		System.out.println("栈顶元素："+stack.peek());
		System.out.println("栈顶元素："+stack.peek());
		System.out.println("---------------size="+stack.size());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("---------------size="+stack.size());
	}
}
