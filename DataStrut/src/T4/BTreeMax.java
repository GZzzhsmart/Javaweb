package T4;

public class BTreeMax {

	int max;
	public BTreeMax(Node root){
		//让根节点的id初始化为max
		max = root.getPerson().getId();
	}
	
	//新增
	public void insert(Node root,Person person){
		System.out.println(root.getPerson().getId()+"  "+person.getId());
		if(root.getPerson().getId()<=person.getId()){//右子树
			if(root.getRightChild()==null){
				System.out.println("----------向右插入"+person.getName());
				root.setRightChild(new Node(person));
			}else {
				System.out.println("向右转");
				insert(root.getRightChild(), person);
			}
		}else {//左子树
			if(root.getLeftChild()==null){
				System.out.println("----------向左插入"+person.getName());
				root.setLeftChild(new Node(person));
			}else {
				System.out.println("向左转");
				insert(root.getLeftChild(), person);
			}
		}
	}
	
	//遍历
	public void display(Node root){
		 if (root == null){
	            System.out.println("二叉树为空");
	     }else{
            if (max < root.getPerson().getId()) { //开始比较
                max = root.getPerson().getId();
            }
            System.out.println("访问节点  ---->  " + root.getPerson().getName());
            if (root.getLeftChild() != null) {
                System.out.println("向左转");
                this.display(root.getLeftChild());
            }
            if (root.getRightChild() != null) {
                System.out.println("向右转");
                this.display(root.getRightChild());
            }
    	}
	}
	
	public static void main(String[] args) {
		Node root = new Node(new Person(3,"root"));
		BTreeMax tree = new BTreeMax(root);
		tree.insert(root,new Person(2,"22"));
		tree.insert(root, new Person(4, "44"));
        tree.insert(root, new Person(1, "11"));
        tree.insert(root, new Person(99, "9999"));
        tree.insert(root, new Person(5, "55"));
        System.out.println("开始遍历");
        //得到的最大值
        tree.display(root);
		
	}
}
