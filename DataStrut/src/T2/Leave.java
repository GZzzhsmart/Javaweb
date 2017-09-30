package T2;


public class Leave {

	private Object[] data;
	private int top=-1;//堆栈指向标
	private int size;
	public Leave(){
		data = new Object[100];
		this.size=100;
	}
	public Leave(int size){
		data = new Object[size];
		this.size=size;
	}
	//出栈
	public Object pop(){
		Object obj = null;
		if(top>-1){
			obj = this.data[top];
			top--;
		}
		return obj;
	}
	
	//入栈
	public void push(Object obj){
		if(top<size-1){
			top++;
			this.data[top]=obj;
			System.out.println(obj+"上交");
		}else{
			System.out.println("\n----"+obj+"看到了假条并批准----\n");
		}
	}
	
	//判断栈顶是否为空
	public boolean empty(){
		boolean isEmpty = true;
		if(top>-1){
			isEmpty = false;
		}
		return isEmpty;
	}
	
	public static void main(String[] args) {
		Leave leave = new Leave();
		leave.push("组长");
		leave.push("部门经理");
		leave.push("部门副总");
		leave.push("总经理");
		leave.push("董事长");
		System.out.println("--------------");
		while(!leave.empty()){
			System.out.println(leave.pop()+"批准!!!");
		}
		System.out.println("\n呵呵~~回家喽^Q^");
	}
}
