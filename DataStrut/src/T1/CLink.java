package T1;

//循环链表
public class CLink {

	//定义头节点
	Node head;
	//初始化
	public CLink() {
		//建表
		head = new Node();
		head.next = null;
	}
	//新增节点
	public void addNode(String data){
		
		Node p = head;//头节点
		if(p.next ==null){
			Node temp = new Node(data);//第一个节点
			p.next = temp;
			temp.next = head.next;
			return;
		}
		p=p.next;
		//第二个节点开始
		while(p.next!=head.next){
			p=p.next;
		}
		//需要新增的节点
		Node temp = new Node(data);
		p.next = temp;
		//尾节点的下一个节点是第一个节点
		temp.next = head.next;
	}
	//删除节点
	public void delNode(String data){
		
		Node p = head.next;
		while(p.next!=head.next){
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
		Node p = head.next;
		while(p.next!=head.next){
			System.out.println(p.name+"->>");
			p=p.next;
		}
		System.out.println(p.name+"->>");
	}
	//查找
	public void findNode(String data){
		
		Node p = head;
		while(p.next!=head.next){
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
		
		Node p = head.next;
		while(p.next!=head.next){
			if(p.name.equals(param)){
				Node t = p;
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
		int n=1;
		Node p = head.next;
		while(p.next!=head.next){
			p=p.next;
			n++;
		}
		return n;
	}
	public static void main(String[] args) {
		CLink link = new CLink();
		link.addNode("组长");
		link.addNode("部门经理");
		link.addNode("主管副总");
		link.addNode("总经理");
		link.display();
		System.out.println("size="+link.size());
		link.delNode("部门经理");
		link.display();
		System.out.println("---------------------------");
		link.insertNode("组长", "部门经理");
		link.display();
	}
}
