package T6;

import java.util.Random;
import java.util.Scanner;

import T5.BubbleSort;

//使用递归的方式进行折半查找
public class DMiddleSearch {

	int a[];
	
	public DMiddleSearch(){
		a = new int[10];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(100));
		}
		sort();
	}
	
	public DMiddleSearch(int size){
		a = new int[size];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(1000));
		}
		sort();
	}
	
	//排序
	public void sort(){
		BubbleSort sort = new BubbleSort(a);
		sort.sort();
		a = sort.getA();
	}
	
	int cnt = 0;
	public void search(int left,int right,int key){
		int middle = 0;
		//查找
		if(left>right){
			System.out.println("查无此数");
			return;
		}else {
			//统计查找次数
			cnt++;
			middle = (right+left)/2;
			System.out.println("left="+left+",middle="+middle+",right="+right+",a[middle]="+a[middle]);
			if(key>a[middle]){
				//查后半部分
				left = middle+1;
				//递归调用自己
				search(left, right, key);
			}else if(key<a[middle]){
				right = middle-1;
				//递归调用自己
				search(left, right, key);
			}else {
				System.out.println("在第"+(middle+1)+"个位置找到了"+key+",共找了"+cnt+"次");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		long start =0,end=0;
		start = System.currentTimeMillis();
		DMiddleSearch middle = new DMiddleSearch(100);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要查找的数据");
		int key = input.nextInt();
		middle.search(0, middle.a.length-1, key);
		end = System.currentTimeMillis()-start;
		System.out.println("查找花费了"+end+"毫秒");
	}
}
