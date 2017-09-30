package T5;

public class QuickSort {
	int a[];
	public QuickSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public QuickSort(int a[]) {
		this.a = a;
	}
	//分区:i是左边界,j是右边界
	int partition(int a[],int i,int j,int size){
		//把小于m的放在m的左边,大于等于m的放在m的右边
		int m=a[i];
		while(i<j){
			//从右往左，查找小于m的元素
			while(i<j && a[j]>=m){
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			//从左往右，查找大于m的元素
			while(i<j && a[i]<m){
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=m;
//		print();
		return i;
	}
	//排序
	public void quickSort(int a[],int left,int right,int size){
		if(left<right){
			int pos = partition(a, left, right, size);
			//左边区块
			quickSort(a, left, pos-1, size); //调用很多次
			quickSort(a, pos+1,right, size);//调用很多次
		}
//		else{
//			System.out.println("排序结束");
//		}
	}
	public void print(){
		for (int e : a) {
			System.out.print(e+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		/*8,19,2,3,100,99,1000,888,-1,0
		 * m=a[0]=8
		 * i=0,j=9
		 * 从右往左：m=a[0]=8,i=0,j=9 a[j]=a[9]=0<m
		 * 0,19,2,3,100,99,1000,888,-1,0	m=8,i=1,j=9
		 * 0,19,2,3,100,99,1000,888,-1,19	m=8,i=1,j=8
		 * 0,-1,2,3,100,99,1000,888,-1,19	m=8,i=2,j=8
		 * 0,-1,2,3,100,99,1000,888,100,19	m=8,i=4,j=7
		 * 0,-1,2,3,100,99,1000,888,100,19	m=8,i=4,j=4
		 * 0,-1,2,3,8,99,1000,888,100,19
		 */
		QuickSort sort = new QuickSort();
		System.out.println("排序前数据顺序：");
		sort.print();
		long start = System.currentTimeMillis();
		sort.quickSort(sort.a, 0, sort.a.length-1, sort.a.length);
		sort.print();
		long end = System.currentTimeMillis()-start;
		System.out.println("排序用时:"+end +"毫秒");
	}
}
