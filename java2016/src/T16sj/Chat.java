package T16sj;

/**
 * 聊天室
 * */
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.event.*;

public class Chat extends JFrame implements ActionListener,KeyListener,Runnable{

	private JTextArea ta1,ta2;
	private JScrollPane sp1,sp2;
	private JButton ok;
	private DatagramSocket ds;
	private String name;
	
	//构造方法初始化
	public Chat(String title){
		super(title);
		ta1= new JTextArea();
		ta2= new JTextArea();
		sp1=new JScrollPane();
		sp2=new JScrollPane();
		ok=new JButton("send");
		try{
			ds= new DatagramSocket(9527);
			
		}catch(Exception e){
			
		}
		
		//界面设计
		getContentPane().setLayout(null);
		setBounds(312,84,400,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().add(sp1);
		ta1.setEditable(false);
		ta1.setForeground(Color.BLUE);
		ta1.setFont(new Font("黑体",Font.PLAIN,16));
		ta1.setLineWrap(true);
		sp1.setBounds(30,30,340,200);
		
		getContentPane().add(sp2);
		ta2.setForeground(Color.BLUE);
		ta2.setFont(new Font("黑体",Font.PLAIN,16));
		ta2.setLineWrap(true);
		sp2.setBounds(30,250,340,200);
		ta2.setToolTipText("按 ctrl+enter 可以快速发送消息");
		ta2.addKeyListener(this);
		
		getContentPane().add(ok);
		ok.setBounds(290,470,80,25);
		ok.addActionListener(this);
		
		do{
			name=JOptionPane.showInputDialog(new JPanel(),"请输入你的名称，然后进入聊天室:");
			if(!name.equals(""))break;
		}while(true);
		setVisible(true);
	}
	//接收
	public void run() {
		while(true){
			DatagramPacket dp=null;
			try{
				byte d[]=new byte[1024];
				dp=new DatagramPacket(d,1024);
				ds.receive(dp);
			}catch(Exception e){
			    e.printStackTrace();
			}
			String data=new String(dp.getData(),0,dp.getLength());
			ta1.append(data+"\n");
		}
	}

	//发送
	public void sendMessage(){
		String data=ta2.getText();
		if(data.equals("")){
			JOptionPane.showMessageDialog(new JPanel(),"发送信息不能为空.");
			return;
		}
		try{
			data=name+"说："+data;
			DatagramPacket dp=new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getByName("255.255.255.255"),9527);
			ds.send(dp);
		}catch(Exception de){}
		ta2.setText("");
	}

	//点击send按钮发送消息
	public void actionPerformed(ActionEvent e){
		sendMessage();
	}

	//按下CTRL+ENTER发送信息
	public void keyPressed(KeyEvent e){
		if(e.isControlDown()&&e.getKeyCode()==e.VK_ENTER)sendMessage();
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
			
	//执行入口
	public static void main(String args[]){
		new Thread(new Chat("chat")).start();
	}
}

