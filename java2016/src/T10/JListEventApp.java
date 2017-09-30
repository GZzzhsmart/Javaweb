package T10;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFrame;

import T5Sj.interfaceDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
public class JListEventApp extends JFrame implements ListSelectionListener{
	 JList jList1;
	   JLabel label;
	   String[] s1 = {"乔丹", "刘翔", "科比", "姚明", "流川风", "大空翼", "其他"};
	    public JListEventApp() {
	        this.setTitle("JList事件演示");
	        getContentPane().setLayout(new BorderLayout());
	        jList1 = new JList(s1);
	        //用来存放选种的列表值，并设置为红色
	        label = new JLabel(" ");
	        label.setForeground(Color.red);
	        //只允许单选
	        jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	        jList1.setBorder(BorderFactory.createTitledBorder("你最喜欢那个人物？"));
	        //增加list选项改变监听，当选种改变时触发给事件
	        jList1.addListSelectionListener(this);
	        //将下拉列表分别放到一个滚动面板里面
	        this.getContentPane().add(new JScrollPane(jList1),BorderLayout.CENTER);
	        this.getContentPane().add(label,BorderLayout.NORTH);
	        this.pack();
	        this.show();
	    }

	    public void valueChanged(ListSelectionEvent e){
	       int tmp = 0;
	       String stmp = "你目前选取的值为:";
	       //得到当前列表中选种的项
	       int[] index = jList1.getSelectedIndices();
	       //通过循环得到所有的选种的选项值
	       for(int i=0;i<index.length;i++){
	           tmp = index[i];
	           stmp = stmp+s1[tmp]+" ";
	       }
	       //在标签中显示选种的值
	       label.setText(stmp);
	    }

	    public static void main(String[] args) {
	        new JListEventApp();
	    }
}
