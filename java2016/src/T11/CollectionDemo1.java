package T11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class CollectionDemo1 {
	public static void main(String[] args){
		Collection coll1 = new ArrayList();
		coll1.add(1);
		coll1.add(2);
		coll1.add("3");
		coll1.add(true);
		coll1.add(3.14);
		coll1.add(1.2f);
		System.out.println("元素的总个数是："+coll1.size());
		//删除元素
		coll1.remove(1);
		System.out.println("元素的总个数是："+coll1.size());
		System.out.println("是否包含值为1的元素："+coll1.contains(2));
		//打印所以元素的值
		Iterator it = coll1.iterator();
		//判断是否存在元素
		while(it.hasNext()){
			Object obj = it.next();
			System.out.println(obj);
		}
	}
}
