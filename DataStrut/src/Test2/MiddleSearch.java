package Test2;

import java.util.Random;
import java.util.Scanner;
import T5.BubbleSort;
//折半查找
public class MiddleSearch {

	int a[];
	public MiddleSearch() {
		a = new int[10];
		Random rnd = new Random();
		for (int i = 1; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(100));
		}
		sort();
	}
	
	public MiddleSearch(int size){
		a = new int[size];
		Random rnd = new Random();
		for (int i = 1; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(1000));
		}
		sort();
	}
	//使用冒泡排序
	public void sort(){
		BubbleSort sort = new BubbleSort(a);
		sort.sort();
		a = sort.getA();
	}
	
	public boolean search(int key){
		int left = 0;
		int right = a.length-1;
		int middle = 0;
		int cnt = 0;
		while(left<=right){
			//统计查找次数
			cnt++;
			middle = (left+right)/2;
			System.out.println("left="+left+",right="+right+",middle="+middle+",a[middle]="+a[middle]);
			//查找后半部分
			if(key>a[middle]){
				left = middle+1;
			}else if(key<a[middle]){//查前半部分
				right = middle-1;
			}else {
				System.out.println("在第"+(middle+1)+"个位置找到了"+key+"，一共找了"+cnt+"次");
				return true;
			}
		}
		if(left>right){
			System.out.println("查无次数");
		}
		return false;
	}
	
	public static void main(String[] args) {
		MiddleSearch middle = new MiddleSearch(100);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要查找的数据：");
		int key = input.nextInt();
		middle.search(key);
	}
}
