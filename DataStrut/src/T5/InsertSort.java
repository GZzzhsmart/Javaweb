package T5;

public class InsertSort {
	int a[];
	public InsertSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public InsertSort(int a[]) {
		this.a = a;
	}
	//插入排序
	public void insertSort(){
		int insertNode;
		int j;
		System.out.println("排序中");
		for(int i=1;i<a.length;i++){
			insertNode = a[i];//保存插入节点到变量中
			j=i-1;
			System.out.println("i="+i+";insertNode="+insertNode+";j="+j);
			while(j>=0 && insertNode<a[j]){
				a[j+1]=a[j];
				j--;
//				print();
			}
			a[j+1]=insertNode;
//			print();
		}
	}
	public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		InsertSort sort = new InsertSort();
		System.out.println("排序之前：");
		sort.print();
		sort.insertSort();
		System.out.println("排序之后");
		sort.print();
	}
}
