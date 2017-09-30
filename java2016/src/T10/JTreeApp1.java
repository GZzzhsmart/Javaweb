package T10;

import java.awt.BorderLayout;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JTree;
public class JTreeApp1 extends JFrame{
	public JTreeApp1(){
		/**
		 * 集合:hashtable哈希表,键值对
		 * 1.键必须是唯一的
		 * 2.值可以是任何类型
		 * 
		 * */
		this.setTitle("JTree演示");
		String s1[] = {"学校管理内容","备课内容","私人文件"};
		Hashtable hashtable = new Hashtable();
		hashtable.put("我的公文包", s1);
		JTree jTree1 = new JTree(hashtable);
		this.getContentPane().add(jTree1);
		this.setSize(200,200);
		this.show();
	}
	public static void main(String[] args) {
		new JTreeApp1();
	}
}
