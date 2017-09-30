package T10;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import java.util.Vector;
import java.awt.GridLayout;
public class JListApp3 extends JFrame{
	public JListApp3(){
		this.setTitle("JList  DefaultListModel 演示");
		getContentPane().setLayout(new GridLayout(1,2));
		DefaultListModel model = new DefaultListModel();
		model.addElement("乔丹");
		model.addElement("刘翔");
		model.addElement("科比");
		model.addElement("姚明");
		model.addElement("流川枫");
		model.addElement("大空翼");
		model.addElement("其他");
		JList jList1 = new JList(model);
		//只允许单选
		jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList1.setBorder(BorderFactory.createTitledBorder("你最喜欢哪个人物？"));
		//设置list初始化状态下一次能看5个选项
		jList1.setVisibleRowCount(5);
		 //将下拉列表分别放到一个滚动面板里面
		this.getContentPane().add(new JScrollPane(jList1));
		this.pack();
		this.show();
	}
	public static void main(String[] args) {
		new JListApp3();
	}
}
