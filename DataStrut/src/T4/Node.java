package T4;

public class Node {

	//保存节点的信息
	private Person person;
	//左孩子
	private Node leftChild;
	//右孩子
	private Node rightChild;
	public Node(Person person){
		this.person = person;
		this.leftChild=null;
		this.rightChild=null;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
}
class Person{
	private int id;
	private String name;
	public Person(int id,String name){
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
