package T4;
//用数组实现二叉树
public class BTreeArray {

	//数组实现二叉树的存储10,8,7,3,1，-10,6,20,90,100
	//假设0位不存在的数据
	int data[];
	int size;
	
	public BTreeArray(int dat){
		size=33;
		data = new int[size];
		data[1]=dat;
	}
	public BTreeArray(int size,int dat){
		this.size = size;
		data = new int[this.size];
		data[1]=dat;
	}
	//新增节点
	public void addNode(int dat){
		int i=1;
		while(true){
			if(data[i]>dat){//往左走
				i = i*2;//左孩子的下标
				if(data[i]==0){
					data[i]=dat;
					break;
				}
			}else {
				i = i*2+1;//右孩子的下标
				if(data[i]==0){
					data[i]=dat;
					break;
				}
			}
		}
	}
	
	//遍历
	public void display(){
		for(int i=0;i<size;i++){
			System.out.println("data["+i+"]"+data[i]);
		}
	}
	
	public static void main(String[] args) {
		BTreeArray tree = new BTreeArray(10);
		tree.addNode(8);
		tree.addNode(7);
		tree.addNode(20);
		tree.addNode(90);
		tree.addNode(100);
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(-10);
		tree.display();
	}
}
