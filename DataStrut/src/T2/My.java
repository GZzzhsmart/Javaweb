package T2;

public class My {

	Object[] data;
	//栈顶标志
	int top=-1;
	public My(){
		data = new Object[100];
	}
	
	public My(int size){
		data = new Object[size];
		System.out.println("要睡觉了，该脱衣服了,^o^");
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
		System.out.println("将"+dat+"放入衣柜");
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
		My stack = new My();
		stack.push("羽绒服");
		stack.push("羊毛衫");
		stack.push("牛仔裤");
		stack.push("毛裤");
		stack.push("袜子");
		System.out.println("----------------------------");
		System.out.println("天亮了，要穿衣服了，^o^");
		System.out.println("----------------------------");
		while(!stack.isEmpty()){
			System.out.println("把"+stack.pop()+"拿出来穿上");
		}
	}
}
