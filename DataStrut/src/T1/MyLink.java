package T1;

public class MyLink {

	public MyNode head = new MyNode();
	public MyNode current = head;
	
	public void addFirst(MyNode newNode){
		MyNode  temp = head.next;
		head.next = newNode;
		newNode.next=temp;
	}
	
	public void addLast(MyNode newNode){
		MyNode p = head;
		while(p.next!=null){
			p = p.next;
		}
		p.next=newNode;
	}
	public void add(int index,MyNode newNode){
		MyNode p = head;
		MyNode f = null;
		for(int i=0;i<index+1;i++) {
			f = p;
			p = p.next;
		}
		f.next = newNode;
		newNode.next = p;
	}
	//反回被删除的对象
	public MyNode removeFirst() { 
		MyNode temp = head.next;
		head.next = head.next.next;
		return temp;
	}
	public void removeLast() {
		MyNode p = head;
		MyNode f = null;
		while(p.next != null) {
			f = p;
			p = p.next;
		}
		f.next = null;
	}
	
	public void remove(int index) {
		MyNode p = head;
		MyNode f = null;
		for(int i=0;i<index+1;i++) {
			f = p;
			p = p.next;
		}
		f.next = p.next;
	}
	public MyNode findByName(String name) {
		MyNode p = head;
		MyNode temp = null;
		while(p.next != null) {
			p = p.next;
			if(p.name.equals(name)) {
				temp = p;
				break;
			}
		}
		return temp;
	}

	public int getLength() {
		int n = 0;
		MyNode p = head;
		while(p.next != null) {
			n++;
			p = p.next;
		}
		return n;
	}
	
	public void listAll() {
		MyNode current = head;
		while(current.next != null) {
			System.out.println(current.next.name);
			current = current.next;
		}
		
	}
	public static void main(String[] args) {
		MyLink link = new MyLink();
		link.add(0, new MyNode("A"));
		link.add(0, new MyNode("B"));
		link.add(0, new MyNode("C"));
		link.addLast(new MyNode("D"));
		System.out.println(link.findByName("B"));
//		link.addFirst(new MyNode("A"));
//		link.addFirst(new MyNode("B"));
//		link.addFirst(new MyNode("C"));
//		link.addFirst(new MyNode("D"));
//		link.addLast(new MyNode("A"));
//		link.addLast(new MyNode("B"));
//		link.addLast(new MyNode("C"));
		
//		link.removeFirst();
//		link.removeLast();
//		link.remove(3);
//		link.add(1, new MyNode("F"));
		
//		System.out.println(link.first.next.name);
//		System.out.println(link.first.next.next.name);
//		link.listAll();
//		System.out.println(link.getLength());
	}
}
