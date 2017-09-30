package T4;

public class BTree {

	int num=0;
	public void insert(Node root,Person person){
		System.out.println("转到节点id："+root.getPerson().getId()+"   要插入的节点:"+person.getId());
		//右子树
		if(root.getPerson().getId()<=person.getId()){
			if(root.getRightChild()==null){
				System.out.println("--------向右插入:"+person.getName());
				root.setRightChild(new Node(person));
			}else {
				System.out.println("向右转");
				insert(root.getRightChild(), person);
			}
		}else {
			//左子树
			if(root.getLeftChild()==null){
				System.out.println("--------向左插入："+person.getName());
				root.setLeftChild(new Node(person));
			}else {
				System.out.println("向左转");
				insert(root.getLeftChild(), person);
			}
		}
	}
	public void leafNum(Node root){
		if(root==null){
			System.out.println("二叉树为空");
		}else {
			//没有子节点
			if((root.getRightChild()==null)&&(root.getLeftChild()==null)){
				//叶子数量+1
				num++;
			}
			System.out.println("访问节点->>"+root.getPerson().getName());
			if(root.getLeftChild()!=null){
				System.out.println("向左转");
				this.leafNum(root.getLeftChild());
			}
			if(root.getRightChild()!=null){
				System.out.println("向右转");
				this.leafNum(root.getRightChild());
			}
		}
	}
	public int getLeafNum(){
		return num;
	}
}
