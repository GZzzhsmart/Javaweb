package Test1;
//节点类
public class Node {

	//数据域
	int data;
	//左孩子
	Node leftChild;
	//右孩子
	Node rightChild;
	//初始化
	public Node(int data){
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
}
