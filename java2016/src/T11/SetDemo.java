package T11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args){
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(3);
		
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		hashSet.add(4);
		hashSet.add(5);
		hashSet.add(3);
		Iterator<Integer> it = treeSet.iterator();
		System.out.println("treeset的元素如下：");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		Iterator<Integer> it2 = hashSet.iterator();
		System.out.println("hashset的元素如下：");
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}
