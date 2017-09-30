package T5;
//选择排序
public class SelectionSort {
	int a[];
	public SelectionSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public SelectionSort(int a[]) {
		this.a = a;
	}
	//返回从开始位置找到的最小值的下标
	public int getMinIndex(int start){
		int index=start;
		int min = a[start];
		for(int i=start;i<a.length;i++){
			if(min>a[i]){
				min=a[i];
				index = i;
			}
		}
		return index;
	}
	//选择排序
	public void selectionSort(){
		for(int i=0;i<a.length;i++){
			int index = getMinIndex(i);
			if(index !=i){
				int tmp = a[i];
				a[i]=a[index];
				a[index]=tmp;
			}
		}
	}
	public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		System.out.println("排序前顺序如下：");
		sort.print();
		System.out.println("======================");
		sort.selectionSort();
		sort.print();
	}
}
