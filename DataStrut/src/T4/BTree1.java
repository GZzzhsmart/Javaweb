package T4;

public class BTree1 {

	//根节点
	Node1 root;
	public BTree1(int data) {
		root = new Node1(data);
	}
	//新增节点
	//10,8,7,20,90,100,3,6,1,-10
	public void addNode(int data){
		//获取根节点
		Node1 p = root;
		//生成新增节点
		Node1 t = new Node1(data);
		while(true){
			//放到根节点的左边
			if(p.data>data){
				if(p.leftChild!=null){
					//继续往下找
					p = p.leftChild;
				}else {
					p.leftChild = t;
					break;
				}
			}else {
				//放到根节点的右边
				if(p.rightChild!=null){
					p = p.rightChild;
				}else {
					p.rightChild = t;
					break;
				}
			}
		}
	}
	
	//遍历
	public void display(Node1 root){
		//先根遍历10,8,7,3,1，-10,6,20,90,100
		System.out.println(root.data);
		if(root.leftChild!=null){
			System.out.println("往左走");
			display(root.leftChild);
		}
		//中根遍历：-10,1,3,6,7,8,10,20,90,100
		System.out.println(root.data);
		if(root.rightChild!=null){
			System.out.println("往右走");
			display(root.rightChild);
		}
		//后根遍历:-10,1,6,3,7,8,100,90,20,10
		System.out.println(root.data);
		
	}
	
	public static void main(String[] args) {
		//10,8,7,20,90,100,3,6,1,-10
		BTree1  tree = new BTree1(10);
		tree.addNode(8);
		tree.addNode(7);
		tree.addNode(20);
		tree.addNode(90);
		tree.addNode(100);
		tree.addNode(3);
		tree.addNode(6);
		tree.addNode(1);
		tree.addNode(-10);
		tree.display(tree.root);
		
	}
}
