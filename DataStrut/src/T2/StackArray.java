package T2;

public class StackArray {

	Object[] data;
	//栈顶标志
	int top=-1;
	public StackArray(){
		data = new Object[100];
	}
	
	public StackArray(int size){
		data = new Object[size];
	}
	//判断为空的函数
	public boolean isEmpty(){
		boolean isok = false;
		if(top==-1){
			isok = true;
		}
		return isok;
	}
	//判断堆栈是否已满
	public  boolean isFull(){
		boolean isok = false;
		if(top+1>=data.length){
			isok=true;
		}
		return isok;
	}
	//入栈
	public void push(String dat){
		if(isFull()){
			System.out.println("堆栈已满");
			return;
		}
		top++;
		data[top]=dat;
	}
	//出栈
	public Object pop(){
		if(isEmpty()){
			System.out.println("堆栈已空");
			return null;
		}
		return  data[top--];
	}
	//获取栈顶元素
	public Object peek(){
		if (isEmpty()) {
			System.out.println("堆栈已空");
			return null;
		}
		return data[top];
	}
	//返回堆栈大小
	public int size(){
		return top+1;
	}
	//容量
	public int capacity(){
		return data.length;
	}
	//查找
	public void search(String dat){
		for(int i=0;i<=top;i++){
			if(data[i].toString().equals(dat)){
				System.out.println("在第"+(i+1)+"位置找到了"+dat);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		StackArray stack = new StackArray(5);
		stack.push("组长");
		stack.push("部门经理");
		stack.push("部门副总");
		stack.push("总经理");
		stack.push("董事长");
		stack.push("董事长他爹");
		//栈顶元素
		System.out.println("栈顶元素"+stack.peek());
		System.out.println("栈顶元素"+stack.peek());
		//大小
		System.out.println("--------------------size="+stack.size());
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		System.out.println("--------------------size="+stack.size());
		System.out.println("栈顶元素"+stack.peek());
	}
}
