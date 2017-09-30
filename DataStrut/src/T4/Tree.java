package T4;

public class Tree {

	//数据节点
	private int data;
	//左子树
	private Tree left;
	//右子树
	private Tree right;
	
	//初始化
	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	//创建二叉树，返回根节点
	public static Tree createTree(int[] input){
		Tree root = null;
		Tree temp = null;
		for(int i=0;i<input.length;i++){
			//创建根节点
			if(root==null){
				root = temp = new Tree(input[i]);
			}else {
				//回到根节点
				temp = root;
				//添加节点
				while(temp.data!=input[i]){
					if(input[i]<=temp.data){
						if(temp.left!=null){
							temp = temp.left;
						}else {
							temp.left= new Tree(input[i]);
						}
					}else{
						if(temp.right!=null){
							temp = temp.right;
						}else {
							temp.right= new Tree(input[i]);
						}
					}
				}
			}
		}
		return root;
	}
	//前序遍历
	public static void preOrder(Tree tree) {  
		if(tree!=null){
			System.out.println(tree.data+" ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}  
	//中序遍历
	public static void midOrder(Tree tree){
		if(tree!=null){
			midOrder(tree.left);
			System.out.println(tree.data+" ");
			midOrder(tree.right);
		}
	}
	//后序遍历
	public static void posOrder(Tree tree){
		if(tree!=null){
			posOrder(tree.left);
			posOrder(tree.right);
			System.out.println(tree.data+" ");
		}
	}
	
    
	public static void main(String[] args) {
		int[] input = {4, 2, 6, 1, 3, 5, 7};
		Tree tree = createTree(input);
		System.out.println("前序遍历");
		preOrder(tree);
		System.out.println("\n中序遍历");
		midOrder(tree);
		System.out.println("\n后序遍历");
		posOrder(tree);
		
	}
}
