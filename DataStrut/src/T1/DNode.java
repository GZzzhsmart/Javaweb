package T1;
//双链表
public class DNode {

	String name;
	//前趋节点地址
	DNode prior;
	//后续节点地址
	DNode next;
	public DNode(){}
	public DNode(String name){
		this.name = name;
		prior = null;
		next = null;
	}
}
