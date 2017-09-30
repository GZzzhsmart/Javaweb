package T1;
/*
 * 节点类：
 * 1.数据域：可能是一个简单的类，也可能是复杂的类
 * 2.链域：下一个节点的地址
 * */
public class Node {

	String name;
	//自引用，下一个节点的地址
	Node next;
	public Node(){}
	public Node(String name){
		this.name = name;
		next=null;
	}
}
