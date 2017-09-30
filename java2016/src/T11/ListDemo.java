package T11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class ListDemo {
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		LinkedList<Integer> link = new LinkedList<Integer>();
		Vector<Integer> vec = new Vector<Integer>();
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(4);
		vec.add(5);
		//在指定的位置添加元素
		vec.add(1,8);
		//遍历方法1
		for(int i=0;i<vec.size();i++){
			System.out.println(vec.get(i));
		}
		System.out.println("---------------");
		//遍历方法2
		Iterator<Integer> it2 = vec.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}
