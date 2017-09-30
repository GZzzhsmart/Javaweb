package T8;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.font.*;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import T5Sj.interfaceDemo;
public class FontDemo extends JFrame implements ItemListener,ActionListener{
	private static final int BOLD = 0;
	private static final int PLAIN = 0;
	private static final int ITALIC = 0;
	JLabel lblTitle;
	JCheckBox cbBold,cbItalic;
	
	JComboBox cbSize,cbFont;
	Font font;
	String sFontName="宋体";
	int sFontSize=8,sBold=Font.PLAIN,sItalic=Font.PLAIN;
	Toolkit toolkit;
	public FontDemo(){
		//获取工具类的实例
		toolkit = Toolkit.getDefaultToolkit();
		setTitle("Font类的使用");
		lblTitle = new JLabel("验证Font类的各种属性的效果",JLabel.CENTER);
		setFont(font);
		add(lblTitle,BorderLayout.NORTH);
		cbBold = new JCheckBox("粗体");
		cbItalic = new JCheckBox("斜体");
		String nSize[]={"8","10","12","14","16","18","20","24","28","32","36","48","72"};
		String sFont[]={"宋体","楷体","黑体","隶书"};
		//获取系统字体
		cbSize = new JComboBox(nSize);
		cbFont = new JComboBox(sFont);
		JPanel centerPanel = new JPanel(null);
		cbFont.setBounds(100,50,100,30);
		cbSize.setBounds(100,90,100,30);
		cbBold.setBounds(100,130,100,30);
		cbItalic.setBounds(100,170,100,30);
		//监听
		cbFont.addItemListener(this);
		cbSize.addItemListener(this);
		cbBold.addActionListener(this);
		cbItalic.addActionListener(this);
		
		centerPanel.add(cbFont);
		centerPanel.add(cbSize);
		centerPanel.add(cbBold);
		centerPanel.add(cbItalic);
		add(centerPanel);
		setSize(300,300);
		setVisible(true);
		int width,height;
		width = (toolkit.getScreenSize().width-300)/2;
		height = (toolkit.getScreenSize().height-300)/2;
		//设置左上角的坐标
		this.setLocation(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		
		new FontDemo();
	}
	public void itemStateChanged(ItemEvent e) {
		
		//获取选中字体
		if(e.getSource()==cbFont){
			
			sFontName=cbFont.getSelectedItem().toString();
		}else if(e.getSource()==cbSize){
			
			sFontSize=Integer.parseInt(cbSize.getSelectedItem().toString());
		}
		setFont(font);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cbBold){
			if(cbBold.isSelected()){
				sBold = FontDemo.BOLD;
			}else{
				sBold = FontDemo.PLAIN;
			}
		}else if(e.getSource()==cbItalic){
			if(cbItalic.isSelected()){
				sItalic = FontDemo.ITALIC;
			}else{
				sItalic = FontDemo.PLAIN;
			}
		}
		setFont(font);
		
	}
	public void setFont(){
		font = new Font(sFontName,sBold+sItalic,sFontSize);
		lblTitle.setFont(font);
	}
}
