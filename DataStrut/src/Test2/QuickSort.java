package Test2;
//快速排序
public class QuickSort {

	int a[];
	public QuickSort() {
		a = new int[]{8,2,-1,0,4,7,99,100,43,5};
	}
	public QuickSort(int a[]){
		this.a = a;
	}
	
	//分区,i是左，j是右
	int partiton(int a[],int i,int j,int size){
		int m = a[i];
		while(i<j){
			//从右往左，查找小于M的元素
			while(i<j && a[j]>=m){
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			//从左往右，查找大于M的元素
			while(i<j && a[i]<m){
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=m;
		return i;
	}
	
	public void quicksort(int a[],int left,int right,int size){
		if(left<right){
			int pos = partiton(a, left, right, size);
			quicksort(a, left, pos-1, size);
			quicksort(a, pos+1, right, size);
		}
	}
	public void print(){
		for (int e : a) {
			System.out.print(e+"\t");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		System.out.println("排序之前的顺序：");
		sort.print();
		System.out.println("排序之后的顺序：");
		sort.quicksort(sort.a, 0, sort.a.length-1, sort.a.length);
		sort.print();
	}
}
