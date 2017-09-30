package T5;

public class LinkSort {

	private Link link;
	public static void main(String[] args) {
		//头节点
		Node head = new Node(0,"head");
		//首节点
		Node one = new Node(1,"唐僧");
		Node two=new Node(2,"孙悟空");
		Node three=new Node(3,"猪八戒");
		Node four=new Node(4,"沙和尚");
		Node five=new Node(5,"白龙马");
		//构造链表
		Link link=new Link(head);
		//在尾部添加节点
		link.addNode(one);
		link.addNode(two);
		link.addNode(three);
		link.addNode(four);
		link.addNode(five);
		System.out.println("排序前结果");
		//遍历列表
		link.display();
		
		LinkSort ls = new LinkSort(link);
		ls.sort();
		System.out.println("按节点序号由大到小排序后结果");
		link.display();
	}
	public LinkSort(Link link){
		this.link=link;
	}
	
	//对链表排序
	public void sort(){
		Node head=link.getHead();
		int tempID=0;
		String tempName=null;
		Node temp=null;
		//第一趟从首节点开始
		for(Node p=head.getNext();p.getNext()!=null;p=p.getNext())
		{
			//从p的下一个节点开始比较
			for(Node q=p.getNext();q!=null;q=q.getNext())
			{
				if(p.getID()<q.getID())
				{
					tempName=p.getName();
					p.setName(q.getName());
					q.setName(tempName);
					
					tempID=p.getID();
					p.setID(q.getID());
					q.setID(tempID);
				}
			}
		}
	}
}
//链表类
class Link{
	private Node head;
	public Link(Node head)
	{
		this.head=head;
	}
	public Node getHead()	//返回头节点对象
	{
		return head;
	}
	public void addNode(Node node)
	{
		Node p=head;
		while(true)
		{
			if(!p.hasNext())
			{
				p.setNext(node);
				break;
			}
			p=p.getNext();
		}
	}
	//插入节点
	public void insertNode(Node p,Node q)
	{
		q.setNext(p.getNext());
		p.setNext(q);
	}
	//遍历链表
	public void display()
	{
		Node p=head.getNext();
		while(p!=null)
		{
			System.out.print(p.getName()+"   ");
			p=p.getNext();
		}
		System.out.println();
	}
}
//节点类
class Node{
	private String nodeName;
	private int id;
	private Node next;
	//用数据域构造一个节点对象
	public Node(int id,String nodeName)
	{
		this.id=id;
		this.nodeName=nodeName;
	}
	//返回下一节点的对象
	public Node getNext()
	{
		return this.next;
	}
	//设置本节点的链域
	public void setNext(Node next)
	{
		this.next=next;
	}

	//返回节点的数据域
	public String getName()
	{
		return this.nodeName;
	}
	public int getID()
	{
		return this.id;
	}
	
	public void setName(String name)
	{
		this.nodeName=name;
	}

	public void setID(int id)
	{
		this.id=id;
	}
	//判断是否有下一节点
	public boolean hasNext()
	{
		boolean is=false;

		if(this.next!=null)
		{
			is=true;
		}
		return is;
	}
}
