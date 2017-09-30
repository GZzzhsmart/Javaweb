package T3_1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.EventListener;

public class ManagerFrame extends JFrame implements ActionListener{
	private int num;
	private ImagePanel ip;
	private JPanel p;
	private JButton in;
	private JButton out;
	private LoopQueue lq;
	private int id;
	public ManagerFrame(int num){
		this.num=num+1;
		ip=new ImagePanel(num,this);
		p=new JPanel();
		in=new JButton("进站");
		out=new JButton("出站");
		lq=new LoopQueue(this.num);
		id=0;
		this.setFrame();
		in.addActionListener(this);
		out.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	private void setFrame(){
		//设置图标
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("qq.jpg");
		setIconImage(img);
		this.add(ip);
		p.add(in);p.add(out);
		this.add("South",p);
		this.setBounds(100,100,800,300);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()==in){
			ip.in();
			lq.inQueue(ip.getID());

		}else if(e.getSource()==out){
			ip.out();
			lq.outQueue();
		}
		ip.repaint();
	}
}
class ImagePanel extends JPanel{
	int width=130;
	int height=120;
	boolean isClear=false;
	int max;
	int i=0;
	ManagerFrame mf;
	Image qq=new ImageIcon(this.getClass().getClassLoader().getResource("qq.jpg")).getImage();
	Image clear=new ImageIcon(this.getClass().getClassLoader().getResource("clear.jpg")).getImage();
	public ImagePanel(int max,ManagerFrame mf){
		this.max=max;
		this.mf=mf;
	}
	public void setIsClear(boolean isClear){
		this.isClear=isClear;
	}
	public void in(){
		if(i<max){
			this.setIsClear(false);
			i++;
		}else{
			System.out.println("车站已满");
		}
	}
	
	public void out(){
		if(i>0){
			this.setIsClear(true);
			i--;
		}else{
			System.out.println("车站已空");
		}
	}
	
	public int getID(){
		return i;
	}
	public void paint(Graphics g){
		mf.setTitle("目前停车数量"+i+"");
		if(isClear==false){
			g.drawImage(qq,width*(i-1),0,width,height,Color.blue,this);
		}else if(isClear==true){
			g.drawImage(clear,width*i,0,
			width,height,Color.blue,this);
		}
	}
}