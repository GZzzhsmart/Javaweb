package T11;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import sun.security.action.PutAllAction;

import T11sj.Orders;

public class MapDemo {
	public static void main(String[] args) {
		Hashtable<String, Orders> ht = new Hashtable<String, Orders>();
		Orders ord1 = new Orders("1000","联想笔记本",4000,"北京");
		Orders ord2 = new Orders("1001","戴尔笔记本",3800,"上海");
		Orders ord3 = new Orders("1002","华硕笔记本",2600,"天津");
		Orders ord4 = new Orders("1003","神州笔记本",3500,"深圳");
		Orders ord5 = new Orders("1004","IBM笔记本",4100,"武汉");
		
		ht.put("1000",ord1);
		ht.put("1001", ord2);
		ht.put("1002", ord3);
		ht.put("1003", ord4);
		ht.put("1004", ord5);
		
		//获取所有的key
		Set<String> keys = ht.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			//get函数，必须通过key才能取到值
			String key = it.next();
			Orders ord = ht.get(key);
			//当打印一个对象时，会自动调用该对象的toString函数
			System.out.println(ord);
			
		}
	}
}
