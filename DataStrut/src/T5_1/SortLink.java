package T5_1;

public class SortLink {

	private Node head;
	
	public SortLink(){
		head = new Node(Integer.MIN_VALUE);
	}
	
	/**
	 * 新增节点，从小到大
	 */
	public void addNode(int num){
		Node data = new Node(num);
		Node p= head;
		for(;p.getNext()!=null;p=p.getNext()){
			if(num <p.getNext().getNum()){
				//排在P的后面
				data.setNext(p.getNext());
				p.setNext(data);
				return;
			}			
		}
		p.setNext(data);
	}
	
	public void printInfo(){
		for(Node p= head.getNext();p!=null;p=p.getNext()){
			System.out.print(p.getNum() + " ");
		}
		System.out.println();
	}
	
	
	public Node getHead(){
		return head;
	}
	
	/**
	 * 合并两个有序链表，a为结果链表
	 * @param a
	 * @param b
	 */
	public static void combine(SortLink a,SortLink b){
		for(Node p= b.getHead().getNext();p!=null;p=p.getNext()){
			a.addNode(p.getNum());
		}
	}
	
	public static void main(String[] args) {
		SortLink linka = new SortLink();
		
		linka.addNode(5);
		linka.addNode(2);
		linka.addNode(10);
		linka.addNode(7);
		linka.addNode(6);
		
		linka.printInfo();
		
		SortLink linkb = new SortLink();
		linkb.addNode(12);
		linkb.addNode(3);
		linkb.addNode(8);
		
		linkb.printInfo();
		
		
		SortLink.combine(linka, linkb);
		linka.printInfo();

	}

}

class Node {
	private int num;
	
	private Node next;
	
	public Node(int num){
		this.num = num;
		this.next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getNum() {
		return num;
	}	
	
	
}
