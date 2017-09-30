package T6;

public class BTree {

	public void insert(Node root,Person1 person){
		
		System.out.println(root.getPerson().getID()+"    "+person.getID());
		
		if(root.getPerson().getID()<=person.getID()){	//右子树
		
			if(root.getRightChild()==null){
				System.out.println("---------------向右插入"+person.getName());
				root.setRightChild(new Node(person));
			}else{
				System.out.println("向右转");
				insert(root.getRightChild(),person);
			}
		}else{											//左子树

			if(root.getLeftChild()==null){
				System.out.println("---------------向左插入"+person.getName());
				root.setLeftChild(new Node(person));
			}else{
				System.out.println("向左转");
				insert(root.getLeftChild(),person);
			}
		}
	}
	
	//节点的查找
	public void find(Node root,int id){
		Node node = root;
		
		if(node.getPerson().getID()==id){//开始查找时首先开始判断
			System.out.println("找到数据"+node.getPerson().getName());
			return;
		}
		if(node.getPerson().getID()<id){//如果不是要查找的节点则比较大小
		
			if(node.getRightChild()!=null){
				this.find(node.getRightChild(),id);//向右子树遍历
			}else{
				System.out.println("没有找到数据");
				return;
			}
				
		}else if(node.getPerson().getID()>id){
			if(node.getLeftChild()!=null){
				this.find(node.getLeftChild(),id);//向左子树遍历
			}else{
				System.out.println("没有找到数据");
				return;
			}
		}
		if(node.getLeftChild()==null&&node.getRightChild()==null){
			System.out.println("没有找到数据");
			return;	//没有找到数据
		}			
	}
}
