package T11;

import java.util.HashSet;
import java.util.Iterator;

import T5Sj.interfaceDemo;
public class Set {
	public static void main(String[] args) {
		int[]a={23,45,65,32,67,87,65,34,65,88};
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for(int i=0;i<a.length;i++){
			hashSet.add(a[i]);
		}

		Iterator<Integer> iterator1=hashSet.iterator();
		while(iterator1.hasNext()){
			System.out.println(iterator1.next());
		}
	}
}
