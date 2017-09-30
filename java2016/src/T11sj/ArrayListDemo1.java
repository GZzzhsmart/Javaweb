package T11sj;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo1 {
	public static void main(String[] args){
		ArrayList<Integer> a1 = new ArrayList();
		//向集合中随机添加数据
		a1.add(new Integer(1));
		a1.add(new Integer(2));
		a1.add(new Integer(3));
		System.out.println(a1.toString());//排序前
		//通过collection中自带的排序对集合a1进行 内部排序
		Collections.sort(a1);
		//排序后
		System.out.println(a1.toString());
	}
}
