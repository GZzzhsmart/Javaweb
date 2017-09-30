package T1;

//单链表
public class Link {

	//定义头节点
	Node head;
	//初始化
	public Link() {
		//建表
		head = new Node();
		head.next = null;
	}
	//新增节点
	public void addNode(String data){
		//获取表头,通过表头找到最后一个元素,把新增的节点放到最后一个元素的后面
		Node p = head;
		while(p.next!=null){
			p=p.next;
		}
		//需要新增的节点
		Node temp = new Node(data);
		p.next = temp;
	}
	//删除节点
	public void delNode(String data){
		//获取表头,通过表头找到最后一个元素,把最后一个元素删除
		Node p = head;
		while(p.next!=null){
			//删除节点
			if(p.next.name.equals(data)){
				p.next = p.next.next;
				break;
			}else{
				p=p.next;
			}
			
		}
	}
	//遍历
	public void display(){
		Node p = head;
		while(p.next!=null){
			System.out.println(p.next.name+"->>");
			p=p.next;
		}
	}
	//查找
	public void findNode(String data){
		//获取表头,通过表头找到最后一个元素,把最后一个元素删除
		Node p = head;
		while(p.next!=null){
			//删除节点
			if(p.next.name.equals(data)){
				System.out.println("data="+p.next.name);
				break;
			}else{
				p=p.next;
			}
			
		}
	}
	//插入节点
	public void insertNode(String param,String data){
		//param表示新增的节点要插入到该节点的后面,获取表头,通过表头找到param元素的节点,把新增的节点放到改节点的后面
		Node p = head;
		while(p.next!=null){
			if(p.next.name.equals(param)){
				Node t = p.next;
				Node insertNode = new Node(data);
				
				insertNode.next = t.next;
				t.next = insertNode;
				break;
			}else{
				p=p.next;
			}
		}
	}
	//链表大小
	public int size(){
		int n=0;
		Node p = head;
		while(p.next!=null){
			p=p.next;
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		Link link = new Link();
		link.addNode("组长");
		link.addNode("部门经理");
		link.addNode("主管副总");
		link.addNode("总经理");
		//显示结果
		link.display();
		//显示大小
		System.out.println("size="+link.size());
		//删除节点
		link.delNode("部门经理");
		link.display();
		System.out.println("---------------------------");
		//新增节点
		link.insertNode("组长", "部门经理");
		link.display();
	}
}
