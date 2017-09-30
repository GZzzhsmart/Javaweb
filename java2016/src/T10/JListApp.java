package T10;

import java.util.Vector;
import javax.swing.JFrame;
import java.awt.color.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;
public class JListApp extends JFrame{
	private static final String BoderFactory = null;

	public JListApp(){
		this.setTitle("JList演示");
		//获取窗口面板
		Container c = getContentPane();
		//设置布局
		c.setLayout(new GridLayout(1,2));
		String s1[] = {"乔丹","科比","刘翔","姚明","流川枫","大空翼","其他"};
		//通过数组创建列表
		JList jlist1 = new JList(s1);
		
		//只允许单选
		jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist1.setBorder(BorderFactory.createTitledBorder("你最喜欢那个人物？"));
		Vector v =new Vector();
		//新增元素
		 v.addElement("Nokia 3310");
		 v.addElement("Nokia 5580");
		 v.addElement("Motorola V8088");
		 v.addElement("Panasonic GD92");
		 v.addElement("Panasonic GD93");
		 v.addElement("NEC DB2100");
		 v.addElement("其他");
		 //通过矢量集来创建列表
		 JList jList2 = new JList(v);
		 //设置通过按下Shift键可以连续选择相邻的多个值SINGLE_INTERVAL_SELECTION
	     //设置通过按下Ctrl键可以选择不相邻的多个值MULTIPLE_INTERVAL_SELECTION
		 jList2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 jList2.setBorder(BorderFactory.createLineBorder(Color.RED,3));
		//将两个下拉列表分别放到一个滚动面板里面
		 c.add(new JScrollPane(jlist1));
		 c.add(new JScrollPane(jList2));
		 this.pack();
		 this.show();
		 
	}
	public static void main(String[] args) {
		new JListApp();
	}
}
