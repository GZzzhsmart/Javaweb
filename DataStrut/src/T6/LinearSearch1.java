package T6;

import java.util.Random;
import java.util.Scanner;

import javax.xml.stream.events.StartDocument;

//线性查找
public class LinearSearch1 {

	int a[];
	public LinearSearch1(){
		a = new int[10];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(100));
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	public LinearSearch1(int size){
		a = new int[size];
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = Math.abs(rnd.nextInt(1000));
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	public boolean search(int key){
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==key){
				index = i;
				break;
			}
		}
		if(index>=0){
			System.out.println("在第"+(index+1)+"个位置找到了"+key);
			return true;
		}else {
			System.out.println("查不此数");
			return false;
		}
	}
	
	public static void main(String[] args) {
		long start = 0,end = 0;
		start = System.currentTimeMillis();
		LinearSearch1 line = new LinearSearch1(100);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要查找的数据");
		int num = input.nextInt();
		line.search(num);
		end = System.currentTimeMillis()-start;
		System.out.println("查找数据花费了"+end+"毫秒");
	}
}
