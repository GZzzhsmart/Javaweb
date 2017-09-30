package T5;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionListener;

public class LotteryMainFrame extends JFrame implements FocusListener, ActionListener{
	private JTextArea screen;
	private JScrollPane scroll;
	private JTextField input1;
	private JTextField input2;
	private JTextField input3;
	private JTextField input4;
	private JTextField input5;
	private JTextField input6;
	private JTextField input7;
	
	private JButton begin;
	private JButton tosort;
	private JButton exit;
	private JButton clear;
	private JLabel lab;
	
	private JRadioButton is1;
	private JRadioButton is2;
	private ButtonGroup type;
	private JPanel p1,p2,p3,p4,p5;
	private Container contentPane;
	private boolean hand=false;	//默认为手选
	
	private int[] lottery;
	public LotteryMainFrame(){
		screen=new JTextArea();
		scroll=new JScrollPane(screen);
		input1=new JTextField(3);
		input2=new JTextField(3);
		input3=new JTextField(3);
		input4=new JTextField(3);
		input5=new JTextField(3);
		input6=new JTextField(3);
		input7=new JTextField(3);
		
		begin=new JButton("开始");
		tosort=new JButton("排序");
		//tosort.setEnabled(false);
		exit=new JButton("退出");
		clear=new JButton("清空");
		
		lab=new JLabel("数量");
		
		is1=new JRadioButton("机选");
		is2=new JRadioButton("手选");
		is1.setSelected(true);
		type = new ButtonGroup();
		type.add(is1);
		type.add(is2);
		contentPane=this.getContentPane();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		lottery=new int[7];
		is1.addFocusListener(this);
		is2.addFocusListener(this);
		
		begin.addActionListener(this);
		tosort.addActionListener(this);
		exit.addActionListener(this);
		clear.addActionListener(this);
		this.setFrame();
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private void setFrame(){
		p1.add(input1);
		p1.add(input2);
		p1.add(input3);
		p1.add(input4);
		p1.add(input5);
		p1.add(input6);
		p1.add(input7);
		
		p2.add(begin);
		p2.add(tosort);
		p2.add(exit);
		p2.add(clear);
		p3.add(p1);
		p3.add(p2);
		p3.setLayout(new GridLayout(2,1));
		
		p4.setLayout(new GridLayout(2,1));
		p4.add(is1);
		p4.add(is2);
		
		p5.setLayout(new BorderLayout());
		p5.add("North",p4);
		
		this.add(scroll);
		this.add("South",p3);
		this.add("East",p5);
		this.setBounds(100,100,320,240);
		this.setTitle("家家乐彩票机");
	}

	public void focusGained(FocusEvent e){
		if(e.getSource()==is1){//机选
			this.hand=false;		//将是否是手选设为假
			tosort.setEnabled(true);//将排序按钮设为可用
		}else if(e.getSource()==is2){//手选
			this.hand=true;			//将是否是手选设为真
			tosort.setEnabled(false);//将排序按钮锁定为不可用
			
			input1.setText("");		//获得焦点时将7个文本框重置为空
			input2.setText("");
			input3.setText("");
			input4.setText("");
			input5.setText("");
			input6.setText("");
			input7.setText("");
			System.out.println("手选");
			
		}
	}
	public void focusLost(FocusEvent e){
		
	}
	//按钮事件
	public void actionPerformed(ActionEvent e){
		String msg="";
		if(e.getSource()==begin){//开始
			if(this.hand==true){	//手选
				lottery[0]=Integer.parseInt(input1.getText());
				lottery[1]=Integer.parseInt(input2.getText());
				lottery[2]=Integer.parseInt(input3.getText());
				lottery[3]=Integer.parseInt(input4.getText());
				lottery[4]=Integer.parseInt(input5.getText());
				lottery[5]=Integer.parseInt(input6.getText());
				lottery[6]=Integer.parseInt(input7.getText());
				sort();
				msg=this.getLottery();
				screen.append(msg+"\n");
			}else if(this.hand==false){//机选
				this.rand();
			}
		}else if(e.getSource()==tosort){//排序
			this.sort();
			msg=this.getLottery();
			screen.append(msg+"\n");
		}
		else if(e.getSource()==exit){//退出
			System.exit(0);
		}else if(e.getSource()==clear){//清空
			this.screen.setText(null);
			this.input1.setText(null);
			this.input2.setText(null);
			this.input3.setText(null);
			this.input4.setText(null);
			this.input5.setText(null);
			this.input6.setText(null);
			this.input7.setText(null);
		}
	}
	private void sort(){
		int t=0;
		for(int i=0;i<lottery.length-1;i++){
			for(int j=i+1;j<=lottery.length-1;j++){
				if(lottery[i]>lottery[j]){
					t=lottery[i];
					lottery[i]=lottery[j];
					lottery[j]=t;
				}
			}
		}
	}
	private String getLottery(){
		String msg="";
		for(int i=0;i<7;i++){
			msg+=lottery[i]+"    ";
		}
		return msg;
	}
	private void rand(){
		Random random=new Random();
		for(int i=0;i<7;i++){
			int temp=random.nextInt();//从0开始生成任意大的整数
			if(temp<0){				  //将负数改为正数
				temp=-temp;
			}
			//对30取模再加1生成1到30的正整数并存到全局数组lottery里
			lottery[i]=temp%30+1;
		}
		input1.setText(lottery[0]+"");//将随机数填充到7个文本框中
		input2.setText(lottery[1]+"");
		input3.setText(lottery[2]+"");
		input4.setText(lottery[3]+"");
		input5.setText(lottery[4]+"");
		input6.setText(lottery[5]+"");
		input7.setText(lottery[6]+"");
	}
	
	public static void main(String[] args) {
		LotteryMainFrame mainFrame=new LotteryMainFrame();
		mainFrame.show();
	}
}