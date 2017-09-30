package T10sj;
//装配置Java开发工具，配置开发环境
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

import T5Sj.interfaceDemo;

import java.util.Vector;

public class JListApp extends JFrame{
	public JListApp(){
		super("JList示例");
		//添加列表选项
		this.addItem();
		this.pack();
		this.setVisible(true);
		//添加窗口关闭监听
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}

	private void addItem() {
		//得到内容面板
		Container contentPane = this.getContentPane();
		//设置布局管理为一行两列
		contentPane.setLayout(new GridLayout(1,2));
		String[] s = {"教师","服务行业","服装设计",
					"销售","餐饮","学生","其他"   };
		Vector v = new Vector();				
		//通过List默认的模型来创建一个一个JList
		DefaultListModel listModel = new DefaultListModel();
		for(int i=0;i<s.length;i++){
			listModel.addElement(s[i]);
		}
		JList list1 = new JList(listModel);
		//支持单选
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//添加标题
		list1.setBorder(BorderFactory.createTitledBorder("您的职业？"));
		
		//将数据先放到一个Vector集合中，通过集合来创建一个JList
		v.addElement("RMB1000");
		v.addElement("RMB1500");
		v.addElement("RMB2000");
		v.addElement("RMB2500");
		v.addElement("RMB3000");
		v.addElement("RMB3500");
		v.addElement("RMB4000");
		
		JList list2 = new JList(v);
		//支持shift进行单选
		list2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//添加标题
		list2.setBorder(BorderFactory.createTitledBorder("您的收入？"));
		
		contentPane.add(new JScrollPane(list1));
		contentPane.add(new JScrollPane(list2));
	}
	public static void main(String[] args) {
		new JListApp();
	}
}
