package T6;

public class TreeApp {

	int i=1;
	public static void main(String[] args) {
		TreeApp ta=new TreeApp();
		BTree tree=new BTree();
		Node root=new Node(new Person1(4,"root"));
		tree.insert(root,new Person1(2,"22"));
		tree.insert(root,new Person1(6,"66"));
		tree.insert(root,new Person1(1,"11"));
		tree.insert(root,new Person1(3,"33"));
		tree.insert(root,new Person1(5,"55"));
		tree.insert(root,new Person1(7,"77"));	
		System.out.println("------------- ¿ªÊ¼±éÀú---------------");
		tree.find(root,8);
	}
}
