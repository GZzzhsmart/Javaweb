package T11;

import java.util.Stack;
import java.util.Vector;
public class VectorDemo {
	public static void main(String[] args) {
		//初始容量100，如果用完后每次加50个存储空间
		Vector v = new Vector(100,50);
		//元素的总数
		System.out.println(v.size());
		//容量
		System.out.println(v.capacity());
	}
}
