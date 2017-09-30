package T5;

public class BubbleSort {
	
	int a[];
	public int[] getA(){
		return a;
	}
	public BubbleSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public BubbleSort(int a[]) {
		this.a = a;
	}
	//冒泡排序
	public void sort(){
		int t=0,k=0,len=a.length;
		//外循环控制循环的趟数
		for(int i=0;i<len-1;i++){
			//内循环控制每一趟的次数
			k=0;
			for(int j=0;j<len-i-1;j++){
				//打印每循环一次后数据的变化
				k++;
//				System.out.println("第"+(i+1)+"趟的第"+k+"次");
				if(a[j]>a[j+1]){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
//				print();
			}
		}
		System.out.println("排序后顺序如下：");
		print();
	}
	public void print(){
		
		for (int e : a) {
			System.out.print(e+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		System.out.println("排序前顺序如下：");
		bubbleSort.print();
		//排序
		long start = System.currentTimeMillis();
		bubbleSort.sort();
		long end = System.currentTimeMillis()-start;
		System.out.println("排序用时:"+end +"毫秒");
	}
}
