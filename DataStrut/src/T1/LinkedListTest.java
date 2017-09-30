package T1;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		//声明链表
		LinkedList list = new LinkedList();
		//添加节点
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		//获取实例,遍历
		Iterator li = list.iterator();
		//判断是否还有下一个节点
		while(li.hasNext()){
			//取得当前节点并获取下一节点
			System.out.println(li.next());
		}
	}
}
