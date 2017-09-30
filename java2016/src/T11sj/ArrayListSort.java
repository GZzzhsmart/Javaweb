package T11sj;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(11);
		arr.add(101);
		arr.add(118);
		arr.add(21);
		arr.add(31);
		arr.add(51);
		arr.add(41);
		arr.add(61);
		arr.add(81);
		arr.add(71);
		System.out.println("排序前：");
		for(Integer a:arr){
			System.out.println(a);
		}
		//排序
		Collections.sort(arr);
		System.out.println("排序后：");
		for(Integer a:arr){
			System.out.println(a);
		}
		//反转
		Collections.reverse(arr);
		System.out.println("反转之后：");
		for(Integer a:arr){
			System.out.println(a);
		}
	}
}
