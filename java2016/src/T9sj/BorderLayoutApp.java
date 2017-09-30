package T9sj;
//通过swing 的组件来创建一个窗体，并使用边框布局
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
public class BorderLayoutApp extends JFrame{
	Container cn;
	JButton button = new JButton("按钮");
	JLabel label1 = new JLabel("标签一");
	JLabel label2 = new JLabel("标签二");
	JTextField text = new JTextField();
	JComboBox comboBox = new JComboBox();
	public BorderLayoutApp(){
		super("排列常用主件");
		this.addItem(); 
		this.setSize(180,160);
		this.setVisible(true);
	}
	private void addItem() {
		//得到窗体的内容面板
		cn = this.getContentPane();
		//给内容面板设置布局
		cn.setLayout( new BorderLayout());
		text.setText("文本域");
		//向内容面板中添加组件
		cn.add(text,BorderLayout.NORTH);
		cn.add(button,BorderLayout.CENTER);
		cn.add(label1,BorderLayout.WEST);
		cn.add(label2,BorderLayout.EAST);
		comboBox.addItem("选择框");
		cn.add(comboBox,BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new BorderLayoutApp();
	}
}
