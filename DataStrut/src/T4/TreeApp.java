package T4;

public class TreeApp {

	int i=1;
	public static void main(String[] args) {
		TreeApp ta = new TreeApp();
		BTree tree = new BTree();
		Node root = new Node(new Person(4,"root"));
		
		tree.insert(root, new Person(2,"22"));
		
		tree.insert(root,new Person(6,"66"));
		tree.insert(root,new Person(1,"11"));
		tree.insert(root,new Person(3,"33"));
		tree.insert(root,new Person(5,"55"));
		tree.insert(root,new Person(7,"77"));	
		System.out.println("开始遍历----------");
		tree.leafNum(root);
		System.out.println("这棵树上一共有"+tree.getLeafNum()+"片叶子");
	}
}
